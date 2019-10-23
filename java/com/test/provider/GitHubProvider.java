package com.test.provider;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.test.dto.AccesstTokenDTO;
import com.test.dto.GitHubUserDTO;
import com.test.entity.User;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Component
public class GitHubProvider {
	
public String SendPostRequest(AccesstTokenDTO accesstTokenDTO) throws IOException{
	//点击使用github登录，验明网站的，返回code，使用code和回调和授权的信息，请求access——token，得到token，请求获取得到用户信息。
	String objJson = JSON.toJSONString(accesstTokenDTO);
 MediaType JSONa= MediaType.get("application/json; charset=utf-8");
OkHttpClient client = new OkHttpClient();
  RequestBody body = RequestBody.create(JSONa,objJson);
  Request request = new Request.Builder()
      .url("https://github.com/login/oauth/access_token")
      .post(body)
      .build();
  try (Response response = client.newCall(request).execute()) {
	  String string = response.body().string().split("&")[0].split("=")[1];
    return string;
  }
	
	
}
public User getUserInfo(String token) throws IOException{
	User user=new User();
	OkHttpClient client = new OkHttpClient();
	Request request = new Request.Builder()
		      .url("https://api.github.com/user?access_token="+token)
		      .build();
	Response response = client.newCall(request).execute();
	 String body = response.body().string();//注意不要写成toString()，会报错
	 GitHubUserDTO parseObject = JSON.parseObject(body, GitHubUserDTO.class);
      user.setImgurl(parseObject.getAvatar_url());
      user.setIntroduction(parseObject.getBio());
      user.setUsername(parseObject.getLogin());
      
      user.setSex("1");
      //如果是github登录，那么密码就是唯一标识
      user.setPasswd(parseObject.getId());
      return user;
}
}
