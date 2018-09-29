package com.wangchao.icebearbc.dao;

import com.wangchao.icebearbc.bean.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther:WangChao
 * @ClassName:CommenDao
 * @Date:Created in 2018/9/29 11:46
 * @Despriction:
 * @Modify By:
 */
public interface CommenDao extends JpaRepository<Comment,Integer>{
}
