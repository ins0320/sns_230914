package com.sns.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.entity.PostEntity;
import com.sns.post.domain.Post;
import com.sns.post.repository.PostRepository;

@Service
public class PostBO {

	@Autowired
	private PostRepository postRepository;

	
	// input: subject content imagePath  output: PostEntity
	public Integer addPost(String content, String imagePath) {
		PostEntity postEntity =  postRepository.save(
				PostEntity.builder()
					.content(content)
					.imagePath(imagePath)
					.build()
				);
		return postEntity == null ? null : postEntity.getId();
	}


}
