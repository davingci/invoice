package org.davingci.albert.dao;

import java.util.List;

import org.davingci.albert.main.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
	User getUserByUsername(String username);
	User getUserById(Integer id);
	List<User> findAll();

}
