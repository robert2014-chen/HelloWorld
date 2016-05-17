package com.robert.blend.hibernate.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 */
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Person {

	private Integer Id;

	private String name;

	private Date birthday;

	private int age;

	private List<String> schools = new ArrayList<String>();

	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	/**
	 * @return the name
	 */
	@Column(name = "person_name")
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthday
	 */
	@Temporal(TemporalType.DATE)
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the age
	 */
	@Transient
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the schools
	 */
	@ElementCollection(targetClass = String.class)
	@CollectionTable(name = "school_info", joinColumns = @JoinColumn(name = "person_id", nullable = false))
	@Column(name = "school_name")
	@OrderColumn(name = "list_order")
	public List<String> getSchools() {
		return schools;
	}

	/**
	 * @param schools
	 *            the schools to set
	 */
	public void setSchools(List<String> schools) {
		this.schools = schools;
	}

}
