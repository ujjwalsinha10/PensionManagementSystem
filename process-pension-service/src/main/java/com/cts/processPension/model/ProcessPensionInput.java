package com.cts.processPension.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Model class for processPensionInput
 * 
 *  @author Ujjwal Sinha
 *  @author 857152
 *
 */
//@NoArgsConstructor
@Getter
@Setter
public class ProcessPensionInput {
	
	@ApiModelProperty(value = "Aadhaar Number")
	@NotNull(message = "Aadhaar Number can not be blank")
	@Pattern(regexp = "[0-9]{12}", message = "Aadhaar Number is Invalid")
	private String aadhaarNumber;

	@ApiModelProperty(value = "Pension Amount")
	@NotNull(message = "Pension Amount can not be blank")
	@Range(min = 0, message = "Pension Amount can not be negative")
	private double pensionAmount;

	@ApiModelProperty(value = "Bank Service Charges")
	@NotNull(message = "Bank Service Charges can not be blank")
	@Range(min = 0, message = "Bank Service Charges can not be negative")
	private double bankServiceCharge;

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public double getPensionAmount() {
		return pensionAmount;
	}

	public void setPensionAmount(double pensionAmount) {
		this.pensionAmount = pensionAmount;
	}

	public double getBankServiceCharge() {
		return bankServiceCharge;
	}

	public void setBankServiceCharge(double bankServiceCharge) {
		this.bankServiceCharge = bankServiceCharge;
	}
public ProcessPensionInput() {
	
}
	public ProcessPensionInput(
			@NotNull(message = "Aadhaar Number can not be blank") @Pattern(regexp = "[0-9]{12}", message = "Aadhaar Number is Invalid") String aadhaarNumber,
			@NotNull(message = "Pension Amount can not be blank") @Range(min = 0, message = "Pension Amount can not be negative") double pensionAmount,
			@NotNull(message = "Bank Service Charges can not be blank") @Range(min = 0, message = "Bank Service Charges can not be negative") double bankServiceCharge) {
		
		this.aadhaarNumber = aadhaarNumber;
		this.pensionAmount = pensionAmount;
		this.bankServiceCharge = bankServiceCharge;
	}

}
