package com.company.dao.idao;

import com.company.dao.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 登录时验证用户名是否存在
     * @param username  用户名
     * @return
     */
    int checkUsername(String username);

    /**
     * 验证用户登录
     * @param username
     * @param password
     * @return
     */
    User login(@Param("username") String username,@Param("password") String password);

    User registry(User user);

}