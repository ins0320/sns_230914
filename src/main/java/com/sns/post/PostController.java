package com.sns.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sns.entity.PostEntity;
import com.sns.post.bo.PostBO;
import com.sns.post.domain.Post;
import com.sns.post.repository.PostRepository;



@Controller
public class PostController {
	

	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/timeline/timeline-view")
	public String timelineListView(
			@RequestParam("userId") int userId
			, Model model) {
		
		List<PostEntity> postEntity  =  (List<PostEntity>) postRepository.findByUserId(userId);
		
		
		model.addAttribute("postList", postEntity);
		
		model.addAttribute("viewName", "timeline/timeline");
		return "template/layout";
		
		
	}
	
}
