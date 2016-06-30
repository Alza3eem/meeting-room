package com.ps.induction.meeting.room.facade;

import com.ps.induction.meeting.room.domain.entity.User;

/**
 * @author Eyad Jarrar
 *
 */
public interface UserFacade {
	
	Iterable<User> getAllUsers();

}
