package com.cts.disbursepension.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Model class for Bank Charges
 * 
 * @author Ujjwal Sinha
 * @author 894137
 *
 */
@Entity
//@NoArgsConstructor
@Getter
public class BankCharges {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String bankType;
	@Column
	private double charges;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	public BankCharges(Integer id, String bankType, double charges) {
		super();
		this.id = id;
		this.bankType = bankType;
		this.charges = charges;
	}

	public BankCharges() {

	}
}
