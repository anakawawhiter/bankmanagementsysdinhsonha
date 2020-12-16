package model;

import java.io.Serializable;
import java.util.Date;



public class SpendAccount implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer  id;

	private String type;

	private Date opendate;

	private double interestrates;
    private Staff staff;
}