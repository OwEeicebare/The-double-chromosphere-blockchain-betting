package com.wangchao.icebearbc.server;



import com.wangchao.icebearbc.bean.User; /**
 * @Auther:WangChao
 * @ClassName:UserService
 * @Date:Created in 2018/9/27 16:56
 * @Despriction:
 * @Modify By:
 */

public interface UserService {

    void doRegister(User user);

    User dologin(String mobile, String password);
}
