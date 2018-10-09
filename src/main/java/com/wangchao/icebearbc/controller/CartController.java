package com.wangchao.icebearbc.controller;

import com.alibaba.fastjson.JSONArray;
import com.wangchao.icebearbc.bean.Cart;
import com.wangchao.icebearbc.bean.CartItem;
import com.wangchao.icebearbc.utils.BallUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther:WangChao
 * @ClassName:CartController
 * @Date:Created in 2018/9/29 15:26
 * @Despriction:
 * @Modify By:
 */
@Controller
@RequestMapping("/cart")
public class CartController {

    @GetMapping("/selectUI")
    public String selectUI(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart==null){
           cart =  new Cart();
           session.setAttribute("cart",cart);
        }
        return "select";
    }
    @GetMapping("/add")
    @ResponseBody
    public String add(HttpSession session,String balls){
        //接收参数一个是session一个是异步请求从前端传过来的balls
        Cart cart = (Cart) session.getAttribute("cart");
        //通过session拿到cart对象
        if (cart==null){
            //如果拿到的cart为空
             cart = new Cart();
             //那么新建一个cart
             session.setAttribute("cart",cart);
             //把cart再保存到session中
        }
        List<CartItem> cartItems = JSONArray.parseArray(balls, CartItem.class);
            //通过fastjson解析前天传过来的数据用cartItem的数组来保存

        for (CartItem cartItem : cartItems) {
            //循环遍历前台传来的随机双色球
            cart.add(cartItem);
            //把它们都添加到cartItem中的map集合中
        }
        return cart.getCount()+"";
    }
    @GetMapping("/cartUI")
    public String cartUI(){
        return "cart.html";
    }

    //机选一注逻辑
    @GetMapping("/randomOen")
    public String randomOen(HttpSession session){
        String redBall = BallUtils.randomRedBall();
        String randomBlue = BallUtils.randomBlueBall();
        CartItem cartItem = new CartItem();
        cartItem.setRed(redBall);
        cartItem.setBlue(randomBlue);
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart==null){
            //如果拿到的cart为空
            cart = new Cart();
            //那么新建一个cart
            session.setAttribute("cart",cart);
            //把cart再保存到session中
        }
        cart.add(cartItem);
        return "redirect:/cart/cartUI";
    }
    //删除全部的逻辑
    @GetMapping("/clear")
    public String clear(HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        cart.clear();
        return "redirect:/cart/cartUI";
    }

    //删除单个逻辑
    @GetMapping("/remove")
    public String remove(String key,HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        cart.remove(key);
        return "redirect:/cart/cartUI";
    }
}
