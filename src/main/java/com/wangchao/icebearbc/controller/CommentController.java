package com.wangchao.icebearbc.controller;

import com.wangchao.icebearbc.bean.Comment;
import com.wangchao.icebearbc.bean.User;
import com.wangchao.icebearbc.server.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Auther:WangChao
 * @ClassName:CommetController
 * @Date:Created in 2018/9/29 11:17
 * @Despriction: 帖子评论controller层
 * @Modify By:
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService service;


    @PostMapping("/add")
    public String add(HttpSession session, HttpServletRequest request, Comment comment){
        //接收参数
        User user = (User) session.getAttribute("user");
        //通过session拿到user对象
        comment.setAddr(request.getRemoteAddr());
        //设置评论者的IP
        comment.setUsername(user.getUsername());
        //设置评论者的名字
        comment.setTime(new Date().toLocaleString());
        //设置评论者的时间

        service.save(comment);
        //调用service层方法
        return "redirect:/note/detail?nid="+comment.getNid();
        //返回从定向到note层中的detail方法传入Nid

    }
}
