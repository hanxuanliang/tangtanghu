package com.hxl.tangtang.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * 分组 模型表
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/22 9:15
 */
@Data
@TableName("tang_group")
public class Group {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    // 分组名称，例如：搬砖者
    private String name;

    // 分组信息：例如：搬砖的人
    private String info;

    @JsonIgnore
    private Date createTime;

    @JsonIgnore
    private Date updateTime;

    @JsonIgnore
    @TableLogic
    private Date deleteTime;
}
