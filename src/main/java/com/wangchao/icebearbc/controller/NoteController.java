package com.wangchao.icebearbc.controller;

import com.wangchao.icebearbc.bean.Note;
import com.wangchao.icebearbc.bean.User;
import com.wangchao.icebearbc.server.NoteService;
import com.wangchao.icebearbc.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Auther:WangChao
 * @ClassName:NoteController
 * @Date:Created in 2018/9/28 20:40
 * @Despriction:帖子页面的controller层
 * @Modify By:
 */
@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService service;

    @GetMapping("/index")
    public String noteUI(Model model){
        //跳转到帖子主页

       List<Note> notes = service.findAll();
       //调用方法查找所有帖子用list集合保存
       model.addAttribute("notes",notes);
       //通过model传给前端浏览器
        return "bbs_index";
    }

    @GetMapping("/detail")
    public String detail(Model model,String nid){
        //接收评论的id
        Note note = service.findOne(nid);
        //调用方法通过nid拿到note对象
        model.addAttribute("note",note);
        //通过model吧note对象传给浏览器
        return "bbs_detail";

    }
    @PostMapping("/add")
    public String add(HttpSession session, HttpServletRequest request,Note note){
        //接收参数添加数据
        User user = (User) session.getAttribute("user");
        //通过session拿到用户对象
        note.setTime(new Date().toLocaleString());
        //设置帖子创建时间
        note.setAddr(request.getRemoteAddr());
        //设置发帖人的ip地址
        note.setNid(UUIDUtils.getId());
        //设置发帖人的id
        note.setUsername(user.getUsername());
        //设置发帖人的名字
        service.save(note);
        //调用方法保存入数据库

        return "redirect:/note/index";
        //从定向到帖子主页

    }
}
