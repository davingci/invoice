package org.davingci.albert.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
		
    @Autowired
    HttpSession httpSession;
	
	@GetMapping(value= {"/index"})
    public String index() {
		
		if( httpSession.getAttribute("username") == null) {
			return "/login";
		}
				
        return "/index";
    }
	
	

}
