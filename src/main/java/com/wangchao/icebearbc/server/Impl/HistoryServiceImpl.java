package com.wangchao.icebearbc.server.Impl;

import com.wangchao.icebearbc.bean.Ballhistory;
import com.wangchao.icebearbc.dao.HistoryDao;
import com.wangchao.icebearbc.server.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Auther:WangChao
 * @ClassName:HistoryServiceImpl
 * @Date:Created in 2018/9/26 10:54
 * @Despriction:
 * @Modify By:
 */
@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDao dao;
    @Override
    public List<Ballhistory> findAll() {
         return dao.findAll();
    }
   public Page<Ballhistory> findByPage(Pageable pageable){
        return dao.findAll(pageable);
   }

    @Override
    public Ballhistory findByCode(String code) {
        return dao.findOne(code);
    }

}
