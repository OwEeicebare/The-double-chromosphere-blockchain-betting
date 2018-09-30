package com.wangchao.icebearbc.controller;

import com.aliyuncs.exceptions.ClientException;
import com.wangchao.icebearbc.bean.User;
import com.wangchao.icebearbc.server.UserService;
import com.wangchao.icebearbc.utils.BallUtils;
import com.wangchao.icebearbc.utils.SMSUtils;
import com.wangchao.icebearbc.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

/**
 * @Auther:WangChao
 * @ClassName:UserController
 * @Date:Created in 2018/9/27 16:15
 * @Despriction:用户
 * @Modify By:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registerUI")
    public String registerUI(){
        return "register";
    }
        //注册的逻辑
    @PostMapping("/register")
    public String register(User user,String code, HttpSession session, Model model){
        String secode = (String) session.getAttribute("secode");
        //通过session拿到用户的验证码
        if (!secode.equals(code)){
            //如果用户的验证码和系统生成的验证码不匹配
            model.addAttribute("mus","输入的验证码不匹配");
            //则告诉用户不正确
            return "register";
            //返回登录
        }

        user.setUid(UUIDUtils.getId());
        //通过工具类UUID设置用户ID
        user.setState(0);
        //初始化用户状态为0
        user.setMoney(100);
        //初始化注册送100代币

        userService.doRegister(user);
        //调用方法保存用户信息
        return "redirect:/user/loginUI";
        //如果用户注册成功则跳转登录页面
    }
    @GetMapping("/loginUI")
    public String loginUI(){
        return "login";
    }
    //校验验证码逻辑
    @ResponseBody
    @GetMapping("/sendSms")
    public String sendSms(String mobile, HttpSession session)  {
        try {
            String secode = SMSUtils.sendSms(mobile);
            //调用工具类传入手机号阿里会发送验证码到用户手机得到注册验证码
            session.setAttribute("secode",secode);
            //将得到的验证码交给session保存
        } catch (ClientException e) {
            e.printStackTrace();
            return "失败";
        }
        return "success";
    }
    //登录逻辑
    @PostMapping("/login")
    public String login(String mobile,String password,Model model,HttpSession session){
            //接收参数准备登录
           User user = userService.dologin(mobile,password);
            //调用方法传入手机号与密码与数据库进行匹配
           if (user == null){
               //如果匹配不成功也就是为空
               model.addAttribute("msg","输入的用户名或密码不正确");
               //则提示用户密码不正确
               return "login";
               //继续登录
           }else {
               session.setAttribute("user",user);
               //else将user保存到session
               return "redirect:/";
               //跳转到首页
           }
    }
    //跳转个人中心
    @GetMapping("/myUI")
    public String myUI(Model model){
        List<String> red = Collections.singletonList(BallUtils.randomRedBall());
        //通过随机红球拿到一组list红球
        String blue = BallUtils.randomBlueBall();
        //拿到随机蓝球

        model.addAttribute("red",red);
        //传给浏览器红球
        model.addAttribute("blue",blue);
        //传给浏览器蓝球
        return "my";
    }


}
