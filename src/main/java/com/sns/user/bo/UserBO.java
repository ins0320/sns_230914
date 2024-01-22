package com.sns.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sns.user.entity.UserEntity;
import com.sns.user.repository.UserRepository;

@Service
public class UserBO {
	
	@Autowired
	private UserRepository userRepository;
	
	// 아이디 중복
	// input: loginId    output: UserEntity(있거나 or null)
	public  UserEntity getUserEntityByLoginId(String loginId) {
		return userRepository.findByLoginId(loginId);
	}
	
	// 회원가입
	// input: 파라미터 4개    output: Integer id(pk) 
	public Integer addUser(String loginId,String password, String name, String email) {
		UserEntity userEntity = userRepository.save(
					UserEntity.builder()
					.loginId(loginId)
					.password(password)
					.name(name)
					.email(email)
					.build()
				);
		return userEntity == null ? null : userEntity.getId();
	}
	
	// 로그인
	// input: loginId, password  output: UserEntity
	public UserEntity getUserEntityBtLoginIdPassword(String loginId, String password) {
		return userRepository.findByLoginIdAndPassword(loginId, password);
	}
	
	// id 일치하는 user 가져오기
	// input: userId   output: UserEntity 
	public UserEntity getUserEntityById(int id) {
		return userRepository.findById(id).orElse(null);
	}
}

