package com.sns.like.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sns.like.domain.Like;

@Mapper
public interface LikeMapper {

	public List<Map<String, Object>> selectLike();
	
	public int selectLikeCountByPostIdUserId(
			@Param("postId") int postId, 
			@Param("userId") int userId);
	
	public void insertLike(
			@Param("postId") int postId, 
			@Param("userId") int userId);

	public void deleteLikeByPostIdUserId(
			@Param("postId") int postId, 
			@Param("userId") int userId);
	
	public int selectLikeCountByPostId(int postId);
}
