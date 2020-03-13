package com.hxl.core.token;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 令牌数据
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/12 10:30
 */
@Getter
@AllArgsConstructor
public class DoubleToken {

    private String accessToken;

    private String refreshToken;
}
