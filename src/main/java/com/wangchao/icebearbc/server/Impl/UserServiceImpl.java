package com.wangchao.icebearbc.server.Impl;

import com.wangchao.icebearbc.bean.User;
import com.wangchao.icebearbc.dao.UserDao;
import com.wangchao.icebearbc.server.UserService;
import com.wangchao.icebearbc.utils.MD5Utils;
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
    private String salt = ")(*&^%##..";
    @Override
    public void doRegister(User user) {
        //MD5的密码加密
        String password = user.getPassword();
        user.setPassword(MD5Utils.encode(password,salt));
        dao.save(user);
    }

    @Override
    public User dologin(String mobile, String password) {
       String newPassword = MD5Utils.encode(password,salt);

        return dao.findByMobileAndPassword(mobile,newPassword);
    }
}
