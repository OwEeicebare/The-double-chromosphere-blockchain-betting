package com.wangchao.icebearbc.dao;

import com.wangchao.icebearbc.bean.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Auther:WangChao
 * @ClassName:OrderDao
 * @Date:Created in 2018/10/8 19:43
 * @Despriction:
 * @Modify By:
 */
public interface OrderDao extends JpaRepository<Order,String>{
    //自定义一个通过uid查询所有的方法
    List<Order> findAllByUid(String uid);
}
