package com.sns.timeline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sns.comment.bo.CommentBO;
import com.sns.comment.domain.Comment;
import com.sns.post.bo.PostBO;
import com.sns.post.entity.PostEntity;
import com.sns.timeline.bo.TimelineBO;
import com.sns.timeline.domain.CardView;

import jakarta.servlet.http.HttpSession;

@Controller
public class TimelineController {

	@Autowired
	private TimelineBO timelineBO;
	
	@GetMapping("/timeline/timeline-view")
	public String timelineView(Model model, HttpSession session) {

		Integer userId = (Integer)session.getAttribute("userId");
		List<CardView> cardViewList = timelineBO.generateCardViewList(userId); // view용 객체 가공
		
		model.addAttribute("cardViewList", cardViewList);
				
		model.addAttribute("viewName", "timeline/timeline");
		return "template/layout";
	}
	
}