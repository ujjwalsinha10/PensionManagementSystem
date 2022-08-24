package com.cts.processPension.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Model class for pension details
 * 
 *  @author Ujjwal Sinha
 *  @author 857152
 *
 */
//@AllArgsConstructor
@Getter
public class PensionDetail {

	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	private String pan;
	private String pensionType;
	private double pensionAmount;
	public PensionDetail() {
		
	}
	public PensionDetail(String name, Date dateOfBirth, String pan, String pensionType, double pensionAmount) {
		
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.pan = pan;
		this.pensionType = pensionType;
		this.pensionAmount = pensionAmount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getPensionType() {
		return pensionType;
	}
	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}
	public double getPensionAmount() {
		return pensionAmount;
	}
	public void setPensionAmount(double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}
	
	

}