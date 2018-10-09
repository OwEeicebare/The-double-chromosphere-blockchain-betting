package com.wangchao.icebearbc.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther:WangChao
 * @ClassName:Cart
 * @Date:Created in 2018/9/29 16:51
 * @Despriction:
 * @Modify By:
 */
public class Cart {

    Map<String,CartItem> carts = new HashMap<>();
    //添加功能
    public void add(CartItem cartItem){
        String key = cartItem.getRed()+"_"+cartItem.getBlue();
        //拼接拿到独一无二的key
        if (carts.containsKey(key)){
            //如果集合中有了这个key
            CartItem oldCartItem = carts.get(key);
            //拿到这个集合中对应key的购物车对象
            oldCartItem.setCount(oldCartItem.getCount()+1);
            //拿到这个对象中的数量加一
        }else {
            carts.put(key,cartItem);
            //否则直接把这个键值对添加到集合中
        }
    }
    //删除单个项目功能
    public void remove(String key){
        carts.remove(key);
        //调用方法删除
    }
    //清空购物车功能
    public void clear(){
        carts.clear();
        //调用方法清空
    }
    //获取购物车总金额
    public double getTotal(){
        double item = 0;
        for (CartItem cartItem : carts.values()) {
            item += cartItem.getSubtotal();

        }
        return item;
    }
    //获取购物车数量的总和
    public int getCount(){
        int count = 0;
        for (CartItem cartItem : carts.values()) {

            count += cartItem.getCount();
        }
        return count;
    }
    //获取所有的cartitem
    public Collection<CartItem> getCartItem(){
        return carts.values();
    }
}
