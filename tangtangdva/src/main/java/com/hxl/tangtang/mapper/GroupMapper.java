package com.hxl.tangtang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxl.tangtang.model.Group;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 分组模型对应mapper
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/22 9:55
 */
@Repository
public interface GroupMapper extends BaseMapper<Group> {

    /**
     * 获得用户的所有分组
     *
     * @param userId 用户id
     * @return 所有分组
     */
    List<Group> selectUserGroups(@Param("userId") Long userId);

    /**
     * 获得用户的所有分组id
     *
     * @param userId 用户id
     * @return 所有分组id
     */
    List<Long> selectUserGroupIds(@Param("userId") Long userId);


    /**
     * 检查用户是否在该名称的分组里
     *
     * @param userId    用户id
     * @param groupName 分组名
     * @return 个数
     */
    int selectCountUserByUserIdAndGroupName(@Param("userId") Long userId, @Param("groupName") String groupName);

}
