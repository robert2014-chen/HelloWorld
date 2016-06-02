package com.robert.blend.spring.user.dao;

import com.robert.blend.spring.user.domain.UserAttempts;

public interface IUserDetailsDao {

	void updateFailAttempts(String username);

	void resetFailAttempts(String username);

	UserAttempts getUserAttempts(String username);
}
