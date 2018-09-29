package com.wangchao.icebearbc.server.Impl;

import com.wangchao.icebearbc.bean.Note;
import com.wangchao.icebearbc.dao.NoteDao;
import com.wangchao.icebearbc.server.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther:WangChao
 * @ClassName:NoteServerImlp
 * @Date:Created in 2018/9/28 21:16
 * @Despriction:
 * @Modify By:
 */
@Service
public class NoteServerImpl implements NoteService {
    @Autowired
    private NoteDao dao;
    @Override
    public void save(Note note) {
        dao.save(note);
    }

    @Override
    public List<Note> findAll() {
        Sort sort = new Sort(Sort.DEFAULT_DIRECTION, "time");
        return dao.findAll(sort);
    }

    @Override
    public Note findOne(String nid) {
        return dao.findOne(nid);
    }
}
