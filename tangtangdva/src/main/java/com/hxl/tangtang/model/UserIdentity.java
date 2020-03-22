package com.hxl.tangtang.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * 用户授权 模型表
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/22 9:40
 */
@Data
@TableName("tang_user_identity")
public class UserIdentity {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    // 用户id
    private Long userId;

    // 认证类型，例如 username_password，用户名-密码认证
    private String identityType;

    // 认证，例如 用户名
    private String identifier;

    // 凭证，例如 密码
    private String credential;

    @JsonIgnore
    private Date createTime;

    @JsonIgnore
    private Date updateTime;

    @TableLogic
    @JsonIgnore
    private Date deleteTime;
}
