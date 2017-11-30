package com.company.service.impl;

import com.company.common.ServerResponse;
import com.company.dao.idao.UserMapper;
import com.company.dao.pojo.User;
import com.company.service.iservice.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional(readOnly = true)
    @Override
    public ServerResponse<User> login(String username, String password) {
        //1-验证用户名是否存在，若不存在，返回错误信息
        int rsCount = userMapper.checkUsername(username);
        if(rsCount == 0){
            return ServerResponse.createErrorMessageResponse("用户名不存在");
        }
        //2-登录验证
        //TODO 对密码进行MD5加密
        User user =userMapper.login(username,password);
        //2-1-
        if(user == null){
            return ServerResponse.createErrorMessageResponse("密码错误");
        }
        //2-2-登陆成功后，清空密码
        user.setPassword(StringUtils.EMPTY);
        return ServerResponse.createSuccessResponse("登陆成功",user);
    }
}
