package com.sns.timeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sns.post.bo.PostBO;

@RequestMapping("/timeline")
@Controller
public class timelineController {

	@Autowired
	private PostBO postBO;
	@GetMapping("/timeline-view")
	public String timelineView(Model model) {
		model.addAttribute("viewName", "timeline/timeline");
		return "template/layout";
	}
	
	// DB 글 목록 조회
	List<Post> postList = 
}
