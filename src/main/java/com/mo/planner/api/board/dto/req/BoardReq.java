package com.mo.planner.api.board.dto.req;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.mo.planner.api.board.dto.req
 * fileName       : BoardReq
 * author         : Jang Hyun Suk
 * date           : 11/14/23
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 11/14/23       Jang Hyun Suk       최초 생성
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardReq {

	private String title;
	private String content;
	private LocalDateTime conferenceStartAt;
	private LocalDateTime conferenceEndAt;

}
