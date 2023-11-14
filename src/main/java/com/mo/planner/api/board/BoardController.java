package com.mo.planner.api.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mo.planner.api.board.dto.req.BoardReq;
import com.mo.planner.api.board.dto.resp.BoardResp;

import lombok.RequiredArgsConstructor;

/**
 * packageName    : com.mo.planner.api.board
 * fileName       : BoardController
 * author         : Jang Hyun Suk
 * date           : 11/14/23
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 11/14/23       Jang Hyun Suk       최초 생성
 */
@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	@PostMapping("")
	public ResponseEntity<?> saveBoard(@RequestBody BoardReq req) {

		boardService.saveBoard(req);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("")
	public ResponseEntity<?> findBoardList() {

		List<BoardResp> resp = boardService.findBoardList();
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findBoardDetails(@PathVariable Long id) {

		BoardResp resp = boardService.findBoardDetails(id);
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBoard(@PathVariable Long id) {

		boardService.deleteBoard(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
