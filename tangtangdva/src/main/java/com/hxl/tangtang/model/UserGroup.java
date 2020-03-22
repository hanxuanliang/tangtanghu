package com.hxl.tangtang.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户分组 模型表
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/22 9:43
 */
@Data
@TableName("tang_user_group")
public class UserGroup {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    // 用户id
    private Long userId;

    // 分组id
    private Long groupId;

    public UserGroup(Long userId, Long groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }
}
