package com.sns.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sns.entity.PostEntity;
import com.sns.user.entity.UserEntity;

public interface PostRepository extends JpaRepository<PostEntity, Integer> {
	// Spring Data JPA

	// null or UserEntity(단건)
	 public PostEntity findByUserId(int userId);

}
