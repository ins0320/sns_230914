package com.sns.entity;

import java.util.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "post")
@Entity
public class PostEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		private int userId;
		
		private String subject;
		
		private String content;
		
		private String imagePath;
		
		@UpdateTimestamp
		@Column(name = "createdAt", updatable = false)
		private Date createdAt;
		
		@UpdateTimestamp
		@Column(name = "updatedAt")
		private Date updatedAt;
}
