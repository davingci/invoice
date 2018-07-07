package org.davingci.albert.web;

import javax.servlet.http.HttpSession;

import org.davingci.albert.main.User;
import org.davingci.albert.response.Response;
import org.davingci.albert.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController {
	
    @Autowired
    HttpSession httpSession;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/signup")
	public Response doPost(@RequestParam String username, @RequestParam String password) {
		User u = userService.getByUsername(username);
		if (u != null) {
			
			return Response.builder().code(202).message("用户已存在").build();
		}
			
		httpSession.setAttribute("username", username);
		User user = User.builder().username(username).password(password).build();
		userService.save(user);
			
		return Response.builder().code(200).message("注册成功").build();
			
		
	}

}
