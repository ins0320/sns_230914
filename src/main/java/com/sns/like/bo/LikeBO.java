package com.sns.like.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.like.domain.Like;
import com.sns.like.mapper.LikeMapper;

@Service
public class LikeBO {

	@Autowired
	private LikeMapper likeMapper;
	
	// input: postId, userId   output: X
	public void likeToggle(int postId, int userId) {		
		// like가 있으면
		if (likeMapper.selectLikeCountByPostIdUserId(postId, userId) > 0) {
			// -- 삭제
			likeMapper.deleteLikeByPostIdUserId(postId, userId);
		} else { 		// 없으면 
			// -- 추가
			likeMapper.insertLike(postId, userId);			
		}	
	}
	
	// input: postId, output: X
	public int getLikeCountByPostId(int postId) {
		return likeMapper.selectLikeCountByPostId(postId);
	}
	
	public int getLikeCountByPostId(int postId, int userId) {
		return likeMapper.selectLikeCountByPostIdUserId(postId, userId);
	}
}
