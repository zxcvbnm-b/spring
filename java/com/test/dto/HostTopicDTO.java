package com.test.dto;

import java.util.List;

import com.test.entity.Question;

import lombok.Data;
@Data
public class HostTopicDTO {
private int question_Count;
private int like_Count;
private List<String> HostLabel;
private List<Question> list;

  }
