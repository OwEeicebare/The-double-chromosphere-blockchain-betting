package com.wangchao.icebearbc.server.Impl;

import com.wangchao.icebearbc.bean.Comment;
import com.wangchao.icebearbc.dao.CommenDao;
import com.wangchao.icebearbc.server.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther:WangChao
 * @ClassName:CommentServiceImpl
 * @Date:Created in 2018/9/29 11:44
 * @Despriction:
 * @Modify By:
 */
@Service
public class CommentServiceImpl implements CommentService {
        @Autowired
     private CommenDao dao;
    @Override
    public void save(Comment comment) {
        dao.save(comment);
    }
}
