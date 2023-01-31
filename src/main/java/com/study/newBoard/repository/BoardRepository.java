package com.study.newBoard.repository;


import com.study.newBoard.entity.Board;
import org.hibernate.event.service.spi.JpaBootstrapSensitive;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface BoardRepository extends JpaRepository<Board,Integer> {
    Board findByTitle(String title);
    Board findByTitleAndContent(String title, String content);
    Board findByTitleLike(String title);
    Board findByContentLike(String content);
}
