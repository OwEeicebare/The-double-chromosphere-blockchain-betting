package com.wangchao.icebearbc.server.Impl;

import com.wangchao.icebearbc.bean.User;
import com.wangchao.icebearbc.dao.UserDao;
import com.wangchao.icebearbc.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther:WangChao
 * @ClassName:UserServiceImpl
 * @Date:Created in 2018/9/27 16:58
 * @Despriction:
 * @Modify By:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    @Override
    public void doRegister(User user) {
        dao.save(user);
    }
}
