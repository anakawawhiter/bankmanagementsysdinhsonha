package model;

import java.io.Serializable;
import java.util.Date;

public class DepositAccount implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String type;

	private Date opendate;

	private double balance;

	private double interestrates;
	
    private Staff staff;
}


