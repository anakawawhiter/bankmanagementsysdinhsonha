package model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Staff implements Serializable	{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String idstaff;

	private String name;

	private String idcard;

	private int experience;

	private String dob;

	private String address;

	private String phonenumber;

	private String position;

	private String username;

	private String password;

	private String level;

}
