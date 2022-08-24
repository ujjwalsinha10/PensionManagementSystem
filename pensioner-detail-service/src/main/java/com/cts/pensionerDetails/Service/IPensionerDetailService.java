package com.cts.pensionerDetails.Service;

import java.io.FileNotFoundException;
import java.util.List;

import com.cts.pensionerDetails.Model.PensionerDetailEntity;
import com.cts.pensionerDetails.Model.PensionerDetails;

/**
 * Interface providing implementations for PensionerDetailService
 * 
 */
public interface IPensionerDetailService {

	public PensionerDetails getPensionerDetailByAadhaarNumber(String aadhaarNumber);
	public List<PensionerDetailEntity> getAllPensionerDetails();

}
