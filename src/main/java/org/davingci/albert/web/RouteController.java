package org.davingci.albert.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.davingci.albert.main.Invoice;
import org.davingci.albert.main.User;
import org.davingci.albert.service.InvoiceService;
import org.davingci.albert.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	InvoiceService invoiceService;
	
	@Autowired
	UserService userService;
	
    @GetMapping("/")
    public String logina() {
        return "login";
    }
    
    @GetMapping("/login")
    public String loginb() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
    
	@GetMapping("/listInvoice")
	public String listInvoice(ModelMap map) {
		if(httpSession.getAttribute("username") == null) {
			return "login";
		}
		List<Invoice> invoiceList = invoiceService.list();
		map.addAttribute("invoiceList", invoiceList);
		return "pages/invoice/listInvoice";
	}
	
	
	@GetMapping("/addInvoice")
	public String addInvoice() {
		if(httpSession.getAttribute("username") == null) {
			return "index";
		}
		return "pages/invoice/addInvoice";
	}
	
	@GetMapping("/listUser")
	public String listUser(ModelMap map) {
		if(httpSession.getAttribute("username") == null) {
			return "index";
		}
		List<User> userList = userService.list();
		map.addAttribute("userList", userList);
		return "pages/user/listUser";
		
	}
	
	
	@GetMapping("/addUser")
	public String addUserService () {
		if(httpSession.getAttribute("username") == null) {
			return "index";
		}
		return "pages/user/addUser";
	}
	
	@GetMapping("/changepw")
	public String changepw(ModelMap map) {
		if(httpSession.getAttribute("username") == null) {
			return "index";
		}
		String username = (String) httpSession.getAttribute("username");
		User user = userService.getByUsername(username);
		map.addAttribute("user", user);
		return "pages/user/changepw";
	}
	
	
	@GetMapping("/profile")
	public String profile() {
		if(httpSession.getAttribute("username") == null) {
			return "index";
		}
		return "pages/user/profile";
	}
	
	@GetMapping("/Logout")
	public String logout() {
		httpSession.removeAttribute("username");
		return "login";
	}


}
