package com.hxl.tangtang.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 分组权限 模型表
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/22 9:34
 */
@Data
@TableName("tang_group_permission")
public class GroupPermission {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    // 分组id
    private Long groupId;

    // 权限id
    private Long permissionId;

    public GroupPermission(Long groupId, Long permissionId) {
        this.groupId = groupId;
        this.permissionId = permissionId;
    }
}
