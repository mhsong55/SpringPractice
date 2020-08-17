package com.kopo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.kopo.dao.BoardDAO;
import com.kopo.dto.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	@Override
	public BoardVO selectOne(int id) throws Exception {
		return dao.selectOne(id);
	}
	@Override
	public List<BoardVO> selectAllPost() throws Exception {

		return dao.selectAllPost();
	}

	@Override
	public String insert(Map<String, String> postDataMap) throws Exception {
		String id = postDataMap.get("id");
		String title = postDataMap.get("title");
		String content = postDataMap.get("content");
		Date date = Date.valueOf(LocalDate.now());
		BoardVO post = new BoardVO();
		
		// gongji_insert.jsp 에서 새 글 등록 요청받은 경우
		if(id.equals("INSERT")) {
			post.setTitle(title);
			post.setContent(content);
			post.setDate(date);
			if(dao.insertPost(post) == 1) {
				return "게시글이 등록되었습니다.";
			} else {
				return "게시글 등록 실패";
			}
		} else {	// gongji_update.jsp 에서 기존 등록된 글 수정 요청받은 경우
			if(id != null && title != null && content != null) {
				post.setId(Integer.parseInt(id));
				post.setTitle(title);
				post.setContent(content);
				post.setDate(date);
			} else {
				// id, title, content 에 null 존재
			}
		}
		return "테스트 실패";
	}
	
	public BoardVO lastInsertedPost() throws Exception {
		int lastId = dao.lastInsertedPostId();
		return dao.selectOne(lastId);
	}
	
}