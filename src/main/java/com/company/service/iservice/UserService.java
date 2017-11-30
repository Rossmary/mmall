package com.company.service.iservice;

import com.company.common.ServerResponse;
import com.company.dao.pojo.User;

/**
 * Created by Administrator on 2017/11/29 0029.
 */
public interface UserService {

    public ServerResponse<User> login(String username,String password);
}
