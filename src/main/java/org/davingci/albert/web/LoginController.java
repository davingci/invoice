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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
    @Autowired
    HttpSession httpSession;
    
    @Autowired
    UserService userService;
	
	
	@PostMapping("/login")
	public Response doPost(@RequestParam String username, @RequestParam String password){

		User loginUser = userService.getByUsername(username);
		if(loginUser == null) {
			return Response.builder().code(202).message("重新登录").build();
		}else {
			httpSession.setAttribute("username", username);
			return Response.builder().code(200).message("登录成功").build();
		}
		
	}

}
