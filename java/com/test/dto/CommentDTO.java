package com.test.dto;

import lombok.Data;
//评论DTO
@Data
public class CommentDTO {
private Integer parent_id;//问题的id
private Integer code;//类型
private String content;//内容
private Integer usera_id;//评论id？
}
