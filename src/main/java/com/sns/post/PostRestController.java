package com.sns.post;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sns.post.bo.PostBO;

@RequestMapping("/post")
@RestController
public class PostRestController {

	@Autowired
	private PostBO postBO;
	
	@PostMapping("/create")
	public Map<String, Object> postCreate(
			@RequestParam("content") String content
			, @RequestParam("imagePath") String imagePath
			){
		
		// db insert
		postBO.addPost(content, imagePath);
		
		//응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		
	}
}
