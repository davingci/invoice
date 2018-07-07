package org.davingci.albert.service;

import java.util.List;

import org.davingci.albert.main.User;

public interface UserService {
	public void save(User user);
	public User getByUsername(String username);
	public User getById(Integer id);
	public void deleteById(Integer id);
	public List<User> list();


}
