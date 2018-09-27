package com.wangchao.icebearbc.server;

import com.wangchao.icebearbc.bean.Ballhistory;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * @Auther:WangChao
 * @ClassName:HistoryService
 * @Date:Created in 2018/9/26 10:52
 * @Despriction:
 * @Modify By:
 */
public interface HistoryService {

    List<Ballhistory> findAll();
    Page<Ballhistory> findByPage(Pageable pageable);

    Ballhistory findByCode(String code);
}
