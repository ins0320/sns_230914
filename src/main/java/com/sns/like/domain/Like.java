package com.sns.like.domain;

import java.util.Date;


import lombok.Data;
import lombok.ToString;

@ToString
@Data // lombok
public class Like {
	private int postId;
	private int userId;
	private Date createdAt;
}
