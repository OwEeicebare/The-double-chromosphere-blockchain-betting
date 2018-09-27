package com.wangchao.icebearbc.dao;

import com.wangchao.icebearbc.bean.Ballhistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther:WangChao
 * @ClassName:HistoryDao
 * @Date:Created in 2018/9/26 10:57
 * @Despriction:
 * @Modify By:
 */
public interface HistoryDao extends JpaRepository<Ballhistory,String>{
}
