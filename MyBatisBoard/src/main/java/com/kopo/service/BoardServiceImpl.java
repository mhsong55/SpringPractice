package com.kopo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
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
	public String insert(Map<String, String> postDataMap) throws Exception {
		
		String title = postDataMap.get("title");
		String content = postDataMap.get("content");
		Date date = Date.valueOf(LocalDate.now());
		BoardVO post = new BoardVO();
		
		post.setTitle(title);
		post.setContent(content);
		post.setDate(date);
		
		// update query가 성공적으로 수행되었다면 DB에서 영향을 받은 record의 수는 1
		if(dao.insertPost(post) == 1) {
			return "게시글이 등록되었습니다.";
		}
		
		return "게시글 등록 실패";
	}
	
	@Override
	public BoardVO selectOne(int id) throws Exception {
		
		return dao.selectOne(id);
	}
	
	@Override
	public List<BoardVO> selectAllPost() throws Exception {

		return dao.selectAllPost();
	}

	public BoardVO lastInsertedPost() throws Exception {
		
		int lastId = dao.lastInsertedPostId();
		return dao.selectOne(lastId);
	}
	
	@Override
	public String update(HashMap <String, String> postDataMap) throws Exception {
		BoardVO post = new BoardVO();
		
		post.setId(Integer.parseInt(postDataMap.get("id")));
		post.setTitle(postDataMap.get("title"));
		post.setContent(postDataMap.get("content"));
		
		// update query가 성공적으로 수행되었다면 DB에서 영향을 받은 record의 수는 1
		if (dao.update(post) == 1) {
			return "게시글이 수정되었습니다.";
			
		}
		return "게시글 수정 실패";
	}
	
	@Override
	public String delete(int id) throws Exception {
		
		// delete query가 성공적으로 수행되었다면 DB에서 영향을 받은 record의 수는 1
		if (dao.delete(id) == 1) {
			return "게시글이 삭제되었습니다.";
		}
		return "게시글 삭제 실패";
	}
}