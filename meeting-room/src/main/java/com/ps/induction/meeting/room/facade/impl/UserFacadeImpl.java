/**
 * 
 */
package com.ps.induction.meeting.room.facade.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ps.induction.meeting.room.domain.entity.User;
import com.ps.induction.meeting.room.domain.repository.UserRepository;
import com.ps.induction.meeting.room.facade.UserFacade;

/**
 * @author Eyad Jarrar
 *
 */
@Transactional
public class UserFacadeImpl implements UserFacade{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void removeUserById(Long id) {
		userRepository.delete(id);
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		return userRepository.findOneByUsernameAndPassword(username, password);
	}

}
