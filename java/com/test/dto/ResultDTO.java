package com.test.dto;

import lombok.Data;

@Data
public class ResultDTO {
private Integer code;
private String message;
private Object object;
public ResultDTO(Integer code, String message, Object object) {
	this.code = code;
	this.message = message;
	this.object = object;
}
public ResultDTO(Integer code, String message) {
	super();
	this.code = code;
	this.message = message;
}

}
