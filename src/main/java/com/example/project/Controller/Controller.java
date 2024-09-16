package com.example.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.LoginReturn;
import com.example.project.model.User;
import com.example.project.service.UserService;

@RestController
@CrossOrigin
public class Controller {
	@Autowired
	UserService service;

	@RequestMapping("login")
	public LoginReturn login(@RequestBody String[] str) {
		LoginReturn res = service.login(str);
		return res;
	}
	@RequestMapping("register")
	public int register(@RequestBody User user) {
		return service.register(user);
	}

}
