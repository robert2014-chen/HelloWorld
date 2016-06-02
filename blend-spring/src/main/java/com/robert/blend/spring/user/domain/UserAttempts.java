package com.robert.blend.spring.user.domain;

import java.util.Date;

public class UserAttempts {

	private int id;

	private String username;

	private int attempts;

	private Date lastModified;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserAttempts [id=" + id + ", username=" + username
				+ ", attempts=" + attempts + ", lastModified=" + lastModified
				+ "]";
	}

}
