package com.openeye.model;

import java.io.Serializable;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Adderss implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4176049149532245842L;
	@Id
	private Long addressId;
	private String houseNo;
	private String streetName;
	private String cityName;
	private String state;
	private String country;
	private String pinCode;

}
