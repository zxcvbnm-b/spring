package com.test.service;

import java.util.List;

import com.test.entity.Category;
import com.test.entity.User;
import com.test.utils.NoticeDTO;

public interface UserService {

	List<User> findByUser(String username, String passwd);

	List<Category> getCategoryList();

	List<NoticeDTO> getNoticeCount(Integer attribute);

}
