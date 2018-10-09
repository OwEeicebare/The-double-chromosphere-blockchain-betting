package com.wangchao.icebearbc.server;

import com.wangchao.icebearbc.bean.Order;

import java.util.List;

/**
 * @Auther:WangChao
 * @ClassName:OrderService
 * @Date:Created in 2018/10/8 19:41
 * @Despriction:
 * @Modify By:
 */
public interface OrderService {
    void save(Order order);

    List<Order> findAll(String uid);
}
