package com.sns.timeline.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.comment.bo.CommentBO;
import com.sns.comment.domain.CommentView;
import com.sns.post.bo.PostBO;
import com.sns.post.entity.PostEntity;
import com.sns.timeline.domain.CardView;
import com.sns.user.bo.UserBO;
import com.sns.user.entity.UserEntity;

@Service
public class TimelineBO {

	@Autowired
	private PostBO postBO;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private CommentBO commentBO;
	
	// view용 가공 객체
	// input: X ( 다 가져오니까) output: List<CardView>
	public List<CardView> generateCardViewList(){
		
		List<CardView> cardViewList = new ArrayList<>();
		
		// 글 목록을 가져옴 List<PostEntity>
		List<PostEntity> postList = postBO.getPostList();

		// 글 목록 반복문 순회
		for(PostEntity post : postList) {
			
			// post 하나에 대응되는 하나의 card를 만든다.
			CardView cardView = new CardView();
			
			// 글 1개
			cardView.setPost(post);
			
			// 글쓴이 정보 (비 로그인 시에도 보임)
			UserEntity user = userBO.getUserEntityById(post.getUserId());
			cardView.setUser(user);
			
			// 댓글들
			List<CommentView> commentList = commentBO.generateCommentViewListByPostId(post.getId());		
			cardView.setCommentList(commentList);
			// 좋아요 개수
			
			// ★★★★★ 마지막에 cardView를 list에 넣는다.
			cardViewList.add(cardView);
			
		}
		
		
		
		return cardViewList;
	}
	
}
