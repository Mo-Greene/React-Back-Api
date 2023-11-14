package com.mo.planner.api.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mo.planner.global.entity.Board;

/**
 * packageName    : com.mo.planner.api.board.repository
 * fileName       : BoardRepository
 * author         : Jang Hyun Suk
 * date           : 11/14/23
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 11/14/23       Jang Hyun Suk       최초 생성
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
}
