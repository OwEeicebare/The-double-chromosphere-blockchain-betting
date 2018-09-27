package com.wangchao.icebearbc.controller;

import com.aliyuncs.exceptions.ClientException;
import com.wangchao.icebearbc.bean.User;
import com.wangchao.icebearbc.server.UserService;
import com.wangchao.icebearbc.utils.SMSUtils;
import com.wangchao.icebearbc.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @Auther:WangChao
 * @ClassName:UserController
 * @Date:Created in 2018/9/27 16:15
 * @Despriction:
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

    @PostMapping("/register")
    public String register(User user,String code, HttpSession session, Model model){
        String secode = (String) session.getAttribute("secode");
        if (!secode.equals(code)){
            model.addAttribute("mus","输入的验证码不匹配");
            return "register";
        }

        user.setUid(UUIDUtils.getId());
        user.setState(0);
        user.setMoney(100);


        userService.doRegister(user);

        return "redirect:/user/loginUI";

    }
    @GetMapping("/loginUI")
    public String loginUI(){
        return "login";
    }

    @ResponseBody
    @GetMapping("/sendSms")
    public String sendSms(String mobile, HttpSession session)  {
        try {
            String secode = SMSUtils.sendSms(mobile);
            session.setAttribute("secode",secode);
        } catch (ClientException e) {
            e.printStackTrace();
            return "失败";
        }
        return "success";
    }

}
