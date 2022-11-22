package com.ssafy.home.board.controller;

import java.util.List;
import java.util.Map;

import com.ssafy.home.board.dto.CommentDTO;
import com.ssafy.home.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.home.board.dto.BoardDTO;
import com.ssafy.home.board.service.BoardService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/board")
public class BoardController {
	private final BoardService bservice;
	private final CommentService cservice;
	@Autowired
	public BoardController(BoardService bservice, CommentService cservice) {
		this.bservice = bservice;
		this.cservice = cservice;
	}

	@GetMapping
	public ResponseEntity<Map<String, Object>> list(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "gugun", defaultValue = "종로구") String gugun) {
		return new ResponseEntity<Map<String, Object>>(bservice.makePage(page, gugun), HttpStatus.ACCEPTED);
	}
	@GetMapping("/test")
	public ResponseEntity<Map<String, Object>> list2(@RequestParam int page, @RequestParam(defaultValue = "종로구") List<String> gugun) {
		return new ResponseEntity<Map<String, Object>>(bservice.makePage2(page, gugun), HttpStatus.ACCEPTED);
	}
	@PostMapping
	public ResponseEntity<String> write(@RequestBody BoardDTO board){
		boolean writeResult = bservice.writeBoard(board);
		if (writeResult)
			return new ResponseEntity<String>("success", HttpStatus.ACCEPTED); // 글쓰기 완료 화면이 달라진다.
		else
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/read")
	public ResponseEntity<Map<String, Object>> read(@RequestParam int bno) {
		return new ResponseEntity(bservice.selectOne(bno), HttpStatus.ACCEPTED);
	}
	
	@PutMapping
	public ResponseEntity<?> modifyBoard(@RequestBody BoardDTO boardDTO){
		int result = bservice.modifyBoard(boardDTO);
		if(result == 1) {
			return new ResponseEntity<String>("success", HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>("fail", HttpStatus.ACCEPTED);
		}

	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteBoard(@RequestParam int bno){
		System.out.println(bno);
		return new ResponseEntity(bservice.deleteBoard(bno), HttpStatus.ACCEPTED);

	}

	@GetMapping("/comment")
	public ResponseEntity<?> getCommentList(@RequestParam int bno){
		System.out.println(bno);
		try {
			List<CommentDTO> list = cservice.getList(bno);
			return new ResponseEntity<List<CommentDTO>>(list, HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/comment")
	public ResponseEntity<?> writeComment(@RequestBody CommentDTO commentDTO){
		System.out.println("commentDTO = " + commentDTO);

		try {
			cservice.writeComment(commentDTO);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
	}

}
