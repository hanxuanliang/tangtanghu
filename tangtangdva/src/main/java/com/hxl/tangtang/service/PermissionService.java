package com.hxl.tangtang.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxl.tangtang.mapper.PermissionMapper;
import com.hxl.tangtang.model.Permission;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限 service
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/22 18:51
 */
@Service
public class PermissionService extends ServiceImpl<PermissionMapper, Permission> {

    public List<Permission> getPermissionByGroupId(Long groupId) {
        return baseMapper.selectPermissionsByGroupId(groupId);
    }

    public List<Permission> getPermissionByGroupIds(List<Long> groupIds) {
        return baseMapper.selectPermissionsByGroupIds(groupIds);
    }

    public List<Permission> getPermissionByGroupIdsAndModule(List<Long> groupIds, String module) {
        return baseMapper.selectPermissionsByGroupIdsAndModule(groupIds, module);
    }

    /**
     * 为什么不使用联表进行查询？
     * 1. 联表很麻烦，需要关联2，3次，涉及到3张表，会严重影响性能
     * 2. 由于使用了IN关键字，所以性能其实很不好
     * 3. 不直观，可读性差
     * 4. 用户的分组一般都比较少，一般情况下都在2个一下
     */
    public Map<Long, List<Permission>> getPermissionMapByGroupIds(List<Long> groupIds) {
        HashMap<Long, List<Permission>> map = new HashMap<>(groupIds.size());
        groupIds.forEach(groupId -> {
            List<Permission> permissions = baseMapper.selectPermissionsByGroupId(groupId);
            map.put(groupId, permissions);
        });
        return map;
    }

}
