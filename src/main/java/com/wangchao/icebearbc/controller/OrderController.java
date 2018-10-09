package com.wangchao.icebearbc.controller;


import com.wangchao.icebearbc.bean.*;
import com.wangchao.icebearbc.server.OrderService;
import com.wangchao.icebearbc.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Auther: Kaijun
 * @Date: 2018/9/28 09:16
 * @Description: 订单模块
 */
@Controller
@RequestMapping("/order") //表示的是模块的前缀
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping("/save")
    public String save(HttpSession session,Model model){
        //1.参数
        User user = (User) session.getAttribute("user");

        Cart cart = (Cart) session.getAttribute("cart");

        //2.根据cart对象的内容,封装订单对象
        Order order = new Order();

        order.setOid(UUIDUtils.getId()); //订单编号
        order.setTotal(cart.getTotal());
        order.setState(0); //订单状态 : 0 未付款, 1:待开奖, 2:已中奖, 3:已兑奖, 4:未中奖
        order.setUid(user.getUid()); // 用户编号
        order.setCreateTime(new Date()); //订单时间

        //3.根据cart中的购物项对象,封装订单项对象
        List<OrderItem> orderItems = new ArrayList<>();

        for (CartItem cartItem : cart.getCartItem()) {
            OrderItem orderItem = new OrderItem();

            orderItem.setRed(cartItem.getRed());
            //订单项属于哪个订单
            orderItem.setOid(order.getOid());
            //设置订单项自身的编号
            orderItem.setItemid(UUIDUtils.getId());
            orderItem.setCount(cartItem.getCount());
            orderItem.setCode("2018020");
            orderItem.setBlue(cartItem.getBlue());
            orderItem.setSubtotal(cartItem.getSubtotal());

            //保存封装好的订单项对象
            orderItems.add(orderItem);
        }

        //将订单项对象封装到订单对象
        order.setOrderItems(orderItems);


        //调用业务保存订单对象
        service.save(order);

        model.addAttribute("order",order);
        //跳转去订单详情页面
        return "order_detail";
    }

    @GetMapping("/list")
    public String list(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        String uid = user.getUid();
        List<Order> orders = service.findAll(uid);
        System.out.println(orders);

        model.addAttribute("oders",orders);

        return "order_list";
    }
}
