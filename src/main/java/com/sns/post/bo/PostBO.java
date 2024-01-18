package com.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.post.entity.PostEntity;
import com.sns.post.repository.PostRepository;

@Service
public class PostBO {

	@Autowired
	private PostRepository postRepository;
	
	// input: X   output: List<PostEntity>
	public List<PostEntity> getPostList() {
		return postRepository.findAllByOrderByIdDesc();
	}
	
	// input: content, file    output: x
	public Integer addPost(String content, String imagePath) {
		PostEntity postEntity = postRepository.save(
				PostEntity.builder()
				.content(content)
				.imagePath(imagePath)
				.build()
				);
		
		return postEntity == null ? null : postEntity.getId();
	};
}