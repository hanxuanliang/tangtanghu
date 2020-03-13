package com.hxl.core.token;

import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.JWTVerifier;
import static com.auth0.jwt.JWT.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hxl.core.consts.TokenConst;
import com.hxl.core.utils.DateUtil;
import lombok.Getter;

import java.util.Date;
import java.util.Map;

/**
 * 双令牌模式
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/12 10:31
 */
@Getter
public class DoubleJwt {

    private long accessExpire;

    private long refreshExpire;

    private Algorithm algorithm;

    private JWTVerifier accessVerifier;

    private JWTVerifier refreshVerifier;

    private Builder jwtBuilder;

    /**
     * 调用者传入加密算法，双token模式
     * @param: accessExpire   access_token过期时间
     * @param: refreshExpire  refresh_token过期时间
     * @param: algorithm      加密算法
     * @date: 2020/3/12 12:40
     */
    public DoubleJwt(long accessExpire, long refreshExpire, Algorithm algorithm) {
        this.accessExpire = accessExpire;
        this.refreshExpire = refreshExpire;
        this.algorithm = algorithm;
        this.initBuilder();
    }

    /**
     * 传入密钥，则默认使用 HMAC256 加密算法
     * @param: accessExpire   access_token过期时间
     * @param: refreshExpire  refresh_token过期时间
     * @param: secret         密钥
     * @date: 2020/3/12 12:42
     */
    public DoubleJwt(long accessExpire, long refreshExpire, String secret) {
        this.accessExpire = accessExpire;
        this.refreshExpire = refreshExpire;
        this.algorithm = Algorithm.HMAC256(secret);
        this.initBuilder();
    }

    /**
     * 生成所给参数的Token
     * @param: tokenType   token类型
     * @param: identity    身份
     * @param: scope       范围
     * @param: expire      过期时间段
     * @date: 2020/3/12 15:09
     */
    public String generateToken(String tokenType, long identity, String scope, long expire) {
        Date expireDate = DateUtil.getDurationDate(expire);
        return jwtBuilder.withClaim("type", tokenType)
                .withClaim("identity", identity)
                .withClaim("scope", scope)
                .withExpiresAt(expireDate)
                .sign(algorithm);
    }

    public String generateAccessToken(long identity) {
        return generateToken(TokenConst.ACCESS_TYPE, identity, TokenConst.TANG_SCOPE, this.accessExpire);
    }

    public String generateRefreshToken(long identity) {
        return generateToken(TokenConst.REFRESH_TYPE, identity, TokenConst.TANG_SCOPE, this.refreshExpire);
    }

    /**
     * 生成
     * @param:
     * @date: 2020/3/12 15:26
     */
    public DoubleToken generateTokens(long identity) {
        String access = this.generateToken(TokenConst.ACCESS_TYPE, identity, TokenConst.TANG_SCOPE, this.accessExpire);
        String refresh = this.generateToken(TokenConst.REFRESH_TYPE, identity, TokenConst.TANG_SCOPE, this.refreshExpire);
        return new DoubleToken(access, refresh);
    }

    public Map<String, Claim> decodeAccseeToken(String accessToken) {
        DecodedJWT jwt = accessVerifier.verify(accessToken);
        checkTokenExpired(jwt.getExpiresAt());
        checkTokenScope(jwt.getClaim("scope").asString());
        checkTokenType(jwt.getClaim("type").asString(), TokenConst.ACCESS_TYPE);
        return jwt.getClaims();
    }

    public Map<String, Claim> decodeRefreshToken(String refreshToken) {
        DecodedJWT jwt = refreshVerifier.verify(refreshToken);
        checkTokenExpired(jwt.getExpiresAt());
        checkTokenType(jwt.getClaim("type").asString(), TokenConst.REFRESH_TYPE);
        checkTokenScope(jwt.getClaim("scope").asString());
        return jwt.getClaims();
    }

    private void initBuilder() {
        accessVerifier = require(algorithm)
                .acceptExpiresAt(this.accessExpire)
                .build();
        refreshVerifier = require(algorithm)
                .acceptExpiresAt(this.refreshExpire)
                .build();
        jwtBuilder = create();
    }

    private void checkTokenExpired(Date expiresAt) {
        long now = System.currentTimeMillis();
        // expiresAt --- now ：expiresAt < now 说明以后过期了
        if (expiresAt.getTime() < now) {
            throw new TokenExpiredException("token is expired");
        }
    }

    private void checkTokenType(String type, String accessType) {
        if (type == null || !type.equalsIgnoreCase(accessType)) {
            throw new InvalidClaimException("token type is invalid");
        }
    }

    private void checkTokenScope(String scope) {
        if (scope == null || !scope.equals(TokenConst.TANG_SCOPE)) {
            throw new InvalidClaimException("token scope is invalid");
        }
    }

}
