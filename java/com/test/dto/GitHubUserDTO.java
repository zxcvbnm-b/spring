package com.test.dto;

import lombok.Data;

@Data
public class GitHubUserDTO {
	private String id;//唯一id
	private String  avatar_url;//头像地址
	private String email;//email
	private  String login;//登錄名
	private String name;//名稱
	private String bio;//簡述
}
