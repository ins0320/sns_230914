package com.sns.timeline.domain;

import java.util.List;

import com.sns.comment.domain.CommentView;
import com.sns.post.entity.PostEntity;
import com.sns.user.entity.UserEntity;

import lombok.Data;
import lombok.ToString;

// View용 객체
// 글 1개와 매핑됭

@ToString
@Data // lombok
public class CardView {
	// 글 1개
	private PostEntity post;
	
	// 글쓴이 정보 ( 글 1개에 대한)
	private UserEntity user;
	
	
	// 댓글들 ( 글 1개에 대한)
	private List<CommentView> commentList;
	
	// 좋아요 개수
	private int likeCount;
	
	// 로그인 된 사람이 좋아요를 누른지 여부
	private boolean filledLike;
	
	
}
