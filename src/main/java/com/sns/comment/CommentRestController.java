package com.sns.comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sns.comment.bo.CommentBO;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/comment")
public class CommentRestController {

	@Autowired
	private CommentBO commentBO;
	
	@PostMapping("/create")
	public Map<String, Object> commentCreate(
			@RequestParam("postId") int postId
			, @RequestParam("content") String content
			, HttpSession session){
		
		Integer userId = (Integer) session.getAttribute("userId");
		commentBO.addComment(postId, postId, content);
		
		// 응닶값
		Map<String,Object> result = new HashMap<>();
		
		if (userId == null) {
			result.put("code", 500);
			result.put("error_message", "로그인을 해주세요.");
			return result;
		}
		
				
			result.put("code", 200);
			result.put("result", "성공");
		
		return result;
	}
}
