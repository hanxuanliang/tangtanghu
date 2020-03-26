package com.hxl.tangtang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxl.tangtang.model.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限模型对应的mapper
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/22 18:52
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 通过分组ids得到所有分组下的权限
     *
     * @param groupIds 分组ids
     * @return 权限
     */
    List<Permission> selectPermissionsByGroupIds(@Param("groupIds") List<Long> groupIds);

    /**
     * 通过分组id得到所有分组下的权限
     *
     * @param groupId 分组id
     * @return 权限
     */
    List<Permission> selectPermissionsByGroupId(@Param("groupId") Long groupId);

    /**
     * 通过 分组ids+权限模块 得到所有分组下的权限
     *
     * @param groupIds 分组ids
     * @param module   权限模块
     * @return 权限
     */
    List<Permission> selectPermissionsByGroupIdsAndModule(@Param("groupIds") List<Long> groupIds, @Param("module") String module);
}
