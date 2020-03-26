package com.hxl.tangtang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hxl.tangtang.model.User;
import org.springframework.stereotype.Repository;

/**
 * 用户模型对应的mapper
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/22 17:22
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 查询用户名为 username 的人数
     *
     * @param username 用户名
     * @return 人数
     */
    int selectCountByUsername(String username);

    /**
     * 查询用户id为 id 的人数
     *
     * @param id 用户id
     * @return 人数
     */
    int selectCountById(Long id);

}
