package com.sns.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sns.entity.PostEntity;
import com.sns.post.bo.PostBO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/post")
@RestController
public class PostRestController {

	@Autowired
	private PostBO postBO;

	@PostMapping("/create")
	public Map<String, Object> createPost(
			@RequestParam("content") String content
			, @RequestParam(value= "file" , required = false) String file
			, HttpSession session ){
		
			
			// 글쓴이 번호
			int userId = (int)session.getAttribute("userId");
			
			// db 조회
			postBO.addPost(content, file);
			
			// 응답값
			Map<String, Object> result = new HashMap<>();
			result.put("code", 200);
			result.put("result", "성공");
			return result;
		}
		
	

}
