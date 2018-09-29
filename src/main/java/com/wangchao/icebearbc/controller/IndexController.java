package com.wangchao.icebearbc.controller;

import com.wangchao.icebearbc.bean.Ballhistory;
import com.wangchao.icebearbc.server.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Auther:WangChao
 * @ClassName:IndexController
 * @Date:Created in 2018/9/26 10:46
 * @Despriction:主页往期开奖信息
 * @Modify By:
 */
@Controller
public class IndexController {
    @Autowired
    private HistoryService historyService;
    @GetMapping("/")
    public String index(Model model, Integer pageNumber){
                    //pageNumber 接收一个int型的分页数
        if (pageNumber == null){
            //首先判断为不为空如果为空
            pageNumber=1;
            //赋值为1
        }
        Sort sort = new Sort(Sort.Direction.DESC,"code");
                              //传入倒序          //根据code来排序
        int size=6;
        //size定义每一页展示的数量             //页码从零开始所以要减1
        Pageable pageable = new PageRequest(pageNumber-1,size,sort);
        //new一个pagerequest分页信息需要传入前两个数量           //倒序
        Page<Ballhistory> page = historyService.findByPage(pageable);
        //通过service层的定义的方法findall传入pageable获得集合
        model.addAttribute("page",page);
        //把page分页信息通过model传给浏览器

//       List<Ballhistory> historys = historyService.findAll();
//        //调用findAll来获取所有条目存入list集合中
//       model.addAttribute("historys",historys);
       return "index";
    }
    @GetMapping("/detail")
    public String detail(String code,Model model){//跳转到彩票详情页面
        //接收参数
        System.out.println(code+"+++++++++++++");
      Ballhistory history = historyService.findByCode(code);
      //调用方法通过code查到对应的彩票信息
      model.addAttribute("history",history);
      //通过model传给前端展示
      return "detail";
    }

}
