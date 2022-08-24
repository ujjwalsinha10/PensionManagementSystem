package com.cts.disbursepension.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model class for pensioner details
 * 
 *  @author Ujjwal Sinha
 *  @author 857152
 *
 */
//@NoArgsConstructor
@Getter
@Setter
public class PensionerDetail {
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd", timezone = "IST")
	private Date dateOfBirth;
	private String pan;
	private double salary;
	private double allowance;
	private String pensionType;
	private BankDetails bank;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getAllowance() {
		return allowance;
	}
	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
	public String getPensionType() {
		return pensionType;
	}
	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}
	public BankDetails getBank() {
		return bank;
	}
	public void setBank(BankDetails bank) {
		this.bank = bank;
	}
	public PensionerDetail() {
		
	}
	public PensionerDetail(String name, Date dateOfBirth, String pan, double salary, double allowance,
			String pensionType, BankDetails bank) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.pan = pan;
		this.salary = salary;
		this.allowance = allowance;
		this.pensionType = pensionType;
		this.bank = bank;
	}
	
}
