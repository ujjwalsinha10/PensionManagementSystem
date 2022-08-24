package com.cts.processPension.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Model class for pensioner input, given by the user
 * 
 *  @author Ujjwal Sinha
 *  @author 857152
 *
 */
@Getter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class PensionerInput {

	@Column
	@NotBlank(message = "Name cannot be blank")
	private String name;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd", iso = ISO.DATE)
	private Date dateOfBirth;

	@Column
	@NotNull(message = "PAN Number cannot be null")
	@NotBlank(message = "PAN Number cannot be blank")
	private String pan;

	@Id
	@Pattern(regexp = "[0-9]{12}", message = "Aadhaar Number is in invalid format")
	private String aadhaarNumber;

	@Column
	@NotBlank(message = "Pension Type cannot be blank")
	private String pensionType;

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

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getPensionType() {
		return pensionType;
	}

	public void setPensionType(String pensionType) {
		this.pensionType = pensionType;
	}
public PensionerInput() {
	
}
	public PensionerInput(@NotBlank(message = "Name cannot be blank") String name, Date dateOfBirth,
			@NotNull(message = "PAN Number cannot be null") @NotBlank(message = "PAN Number cannot be blank") String pan,
			@Pattern(regexp = "[0-9]{12}", message = "Aadhaar Number is in invalid format") String aadhaarNumber,
			@NotBlank(message = "Pension Type cannot be blank") String pensionType) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.pan = pan;
		this.aadhaarNumber = aadhaarNumber;
		this.pensionType = pensionType;
	}

}