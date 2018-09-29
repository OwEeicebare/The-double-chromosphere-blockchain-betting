package com.wangchao.icebearbc.dao;

import com.wangchao.icebearbc.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther:WangChao
 * @ClassName:UserDao
 * @Date:Created in 2018/9/27 17:00
 * @Despriction:
 * @Modify By:
 */
public interface UserDao extends JpaRepository<User,String>{
    User findByMobileAndPassword(String mobile, String newPassword);
}
