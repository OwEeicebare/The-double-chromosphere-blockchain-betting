package com.wangchao.icebearbc.server;

import com.wangchao.icebearbc.bean.Note;

import java.util.List;

/**
 * @Auther:WangChao
 * @ClassName:NoteService
 * @Date:Created in 2018/9/28 21:15
 * @Despriction:
 * @Modify By:
 */
public interface NoteService {
    void save(Note note);

    List<Note> findAll();

    Note findOne(String nid);
}
