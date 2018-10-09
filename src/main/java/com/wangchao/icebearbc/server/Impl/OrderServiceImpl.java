package com.wangchao.icebearbc.server.Impl;

import com.wangchao.icebearbc.bean.Order;
import com.wangchao.icebearbc.dao.OrderDao;
import com.wangchao.icebearbc.server.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther:WangChao
 * @ClassName:OrderServiceImpl
 * @Date:Created in 2018/10/8 19:42
 * @Despriction:
 * @Modify By:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao dao;
    @Override
    public void save(Order order) {
        dao.save(order);
    }

    @Override
    public List<Order> findAll(String uid) {
        return dao.findAllByUid(uid);
    }
}
