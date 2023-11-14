package com.mo.planner.api.board;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mo.planner.api.board.dto.req.BoardReq;
import com.mo.planner.api.board.dto.resp.BoardResp;
import com.mo.planner.api.board.repository.BoardRepository;
import com.mo.planner.global.entity.Board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * packageName    : com.mo.planner.api.board
 * fileName       : BoardService
 * author         : Jang Hyun Suk
 * date           : 11/14/23
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 11/14/23       Jang Hyun Suk       최초 생성
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;

	public List<BoardResp> findBoardList() {

		return boardRepository.findAll()
			.stream()
			.map(b -> BoardResp.builder()
				.title(b.getTitle())
				.content(b.getContent())
				.conferenceStartAt(b.getConferenceStartAt())
				.conferenceEndAt(b.getConferenceEndAt())
				.build()
			).toList();
	}

	public void saveBoard(BoardReq req) {

		Board board = Board.saveBoard(req);
		boardRepository.save(board);
	}

	public BoardResp findBoardDetails(Long id) {

		Board board = boardRepository.findById(id)
			.orElseThrow(NullPointerException::new);

		return BoardResp.builder()
			.title(board.getTitle())
			.content(board.getContent())
			.conferenceStartAt(board.getConferenceStartAt())
			.conferenceEndAt(board.getConferenceEndAt())
			.build();
	}

	public void deleteBoard(Long id) {

		boardRepository.deleteById(id);
	}
}
