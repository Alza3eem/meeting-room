/**
 * @author u592
 *
 */
package com.ps.induction.meeting.room.domain.repository;

import org.springframework.data.repository.CrudRepository;

import com.ps.induction.meeting.room.domain.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}