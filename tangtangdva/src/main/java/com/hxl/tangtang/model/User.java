package com.hxl.tangtang.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * 用户 模型表
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/22 9:38
 */
@Data
@TableName("tang_user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    // 用户名，唯一
    private String username;

    // 用户昵称
    private String nickname;

    // 头像url
    private String avatar;

    private String email;

    @JsonIgnore
    private Date createTime;

    @JsonIgnore
    private Date updateTime;

    @JsonIgnore
    @TableLogic
    private Date deleteTime;
}
