package org.davingci.albert.web;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.davingci.albert.dto.ListInvoiceServiceReturnDTO;
import org.davingci.albert.dto.ListUserServiceReturnDTO;
import org.davingci.albert.main.Invoice;
import org.davingci.albert.main.User;
import org.davingci.albert.response.Response;
import org.davingci.albert.service.InvoiceService;
import org.davingci.albert.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	InvoiceService invoiceService;
	
	@Autowired
	UserService userService;
	

	
	@PostMapping("/AddInvoiceService")
	public Response addInivoice(ModelMap map, @RequestParam String code, @RequestParam String registerUsername, @RequestParam String registerTime) {
	List<Invoice> invoiceList = invoiceService.list();
	//duplicated value check
	Map<Integer, String> codeMap = invoiceList.stream().collect(Collectors.toMap(x -> x.getId(), x -> x.getCode()));
		if(codeMap.containsValue(code)) {
		return Response.builder().code(202).message("duplicated invoice code").build();
	}
	
	Invoice invoice = Invoice.builder().code(code).registerUsername(registerUsername).registerTime(registerTime).build();
	invoiceService.save(invoice);
	invoiceList.add(invoice);
	map.addAttribute(invoiceList);
		
	return Response.builder().code(200).message("success").build();
	}
	

	
	@PostMapping("/AddUserService")
	public Response addUser(ModelMap map, @RequestParam String username, @RequestParam String password) {
		if(httpSession.getAttribute("username") == null) {
			return Response.builder().code(201).message("error").build();
		}
		List<User> userList = userService.list();
		User user = User.builder().username(username).password(password).build();
		userService.save(user);
		userList.add(user);
		map.addAttribute(userList);
		return Response.builder().code(200).message("success").build();
	}
	
	@PostMapping("/UpdateUserService") //url: /UpdateUserService?id={user.id}
	public Response updateUser(@RequestParam("password") String password, @RequestParam("id") String id) {
		User user = userService.getById(Integer.parseInt(id));
		user.setPassword(password);
		userService.save(user);
		return Response.builder().code(200).message("success").build();
	}
	


}
