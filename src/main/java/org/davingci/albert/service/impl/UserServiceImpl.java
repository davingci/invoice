package org.davingci.albert.service.impl;

import java.util.List;

import org.davingci.albert.dao.UserDao;
import org.davingci.albert.main.User;
import org.davingci.albert.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	public void save(User user) {
		userDao.save(user);
	}
	@Override
	public User getByUsername(String username) {
		return userDao.getUserByUsername(username);
	}
	@Override
	public User getById(Integer id) {
		return userDao.getUserById(id);
	}
	@Override
	public void deleteById(Integer id) {
		userDao.deleteById(id);
	}
	
	@Override
	public List<User> list(){
		return userDao.findAll();
	}

}
