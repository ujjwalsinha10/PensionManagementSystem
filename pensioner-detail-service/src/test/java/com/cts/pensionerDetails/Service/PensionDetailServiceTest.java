package com.cts.pensionerDetails.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.pensionerDetails.Exception.NotFoundException;
import com.cts.pensionerDetails.Model.BankDetails;
import com.cts.pensionerDetails.Model.PensionerDetailEntity;
import com.cts.pensionerDetails.Model.PensionerDetails;
import com.cts.pensionerDetails.Repository.PensionerDetailsRepository;
import com.cts.pensionerDetails.Util.DateUtil;

/**
 *  @author Ujjwal Sinha
 *  @author 894137
 * 
 *         This is the service test class
 * 
 *         Test cases for the Pension Detail Service
 *
 */
@SpringBootTest
class PensionDetailServiceTest {

	@Autowired
	IPensionerDetailService pds;

	@Value("${errorMessage}")
	private String AADHAAR_NUMBER_NOT_FOUND;

	/**
	 * Test the Pensioner Detail service is null or not
	 */

//	@MockBean
//	private PensionerDetailsRepository pensionerRepo;
	
	@Test
	void testNotNullPensionDetailServiceObject() {
		assertNotNull(pds);
	}

	/**
	 * Test Case for the Correct Details Returned From Service With Correct
	 * AadharNumber
	 */

	@Test
	void testCorrectDetailsReturnedFromServiceWithCorrectAadharNumber()
			throws IOException, NotFoundException, NumberFormatException,
			com.cts.pensionerDetails.Exception.NotFoundException, ParseException, NullPointerException {
		final String aadhaarNumber = "123456789012";

		PensionerDetails pensionerDetail = new PensionerDetails("Achyuth", DateUtil.parseDate("12-09-1956"),
				"BHMER12436", 27000, 10000, "self", new BankDetails("ICICI", 12345678, "private"));
		assertEquals(pds.getPensionerDetailByAadhaarNumber(aadhaarNumber).getPan(), pensionerDetail.getPan());
		assertEquals(pds.getPensionerDetailByAadhaarNumber(aadhaarNumber).getBank().getAccountNumber(), pensionerDetail.getBank().getAccountNumber());
	}

	/**
	 * Test Case for the incorrect details returned From Service With Invalid
	 * Aadhaar Number
	 */

	@Test
	void testForIncorrectAadharNumber() {
		final String aadhaarNumber = "12345678";

		NotFoundException exception = assertThrows(NotFoundException.class,
				() -> pds.getPensionerDetailByAadhaarNumber(aadhaarNumber));
		assertEquals(exception.getMessage(), AADHAAR_NUMBER_NOT_FOUND);
		assertNotNull(exception);
	}
	
//	@Test
//	void testGetAllPensionerDetails() {
//		PensionerDetailEntity pensionerDetailEntity= new PensionerDetailEntity("111","ABC",new Date(),"ABC",5000,100,"Self",new BankDetails("TEst", 12121L, "Private"));
//		List<PensionerDetailEntity> pensionerList = new ArrayList<>();
//		pensionerList.add(pensionerDetailEntity);
//		Mockito.when(pensionerRepo.findAll()).thenReturn(pensionerList);
//		assertEquals(pensionerRepo.findAll(), pensionerList);
//	}
}
