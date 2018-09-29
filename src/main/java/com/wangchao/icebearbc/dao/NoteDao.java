package com.wangchao.icebearbc.dao;

import com.wangchao.icebearbc.bean.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther:WangChao
 * @ClassName:NoteDao
 * @Date:Created in 2018/9/28 21:30
 * @Despriction:
 * @Modify By:
 */
public interface NoteDao extends JpaRepository<Note,String>{
}
