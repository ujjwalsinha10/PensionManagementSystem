package com.cts.pensionerDetails.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import com.cts.pensionerDetails.Exception.NotFoundException;
import com.cts.pensionerDetails.Model.BankDetails;
import com.cts.pensionerDetails.Model.PensionerDetailEntity;
import com.cts.pensionerDetails.Model.PensionerDetails;
import com.cts.pensionerDetails.Repository.PensionerDetailsRepository;
import com.cts.pensionerDetails.Util.DateUtil;

/**
 *  @author Ujjwal Sinha
 *  @author 857152
 * 
 *         PensionDetailsService is a class which contain the
 *         getPensionerDetailByAadhaarNumber function to get the pensioner
 *         details
 * 
 */
@Service
public class PensionerDetailServiceImpl implements IPensionerDetailService {
	private static final Logger log = LogManager.getLogger(PensionerDetailServiceImpl.class);

	@Value("${errorMessage}")
	private String AADHAAR_NUMBER_NOT_FOUND;
	
	@Autowired
	private PensionerDetailsRepository pensionerDetailsRepository;
	

	/**
	 * Loads pensioner from the details if it exists. After loading the details,
	 * compares the given Aadhaar Number from the Details CSV Files.
	 * 
	 * @param Aadhaar Number
	 * @return Pensioner Details
	 */
	public PensionerDetails getPensionerDetailByAadhaarNumber(String aadhaarNumber) {

		String line = "";
		BufferedReader br = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/details.csv")));
		try {
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				// convert record into strings
				String[] person = line.split(",");
				// if Aadhaar number is found, then return the details
				if (aadhaarNumber.contentEquals(person[0])) {
				log.info("Details found");
					return new PensionerDetails(person[1], DateUtil.parseDate(person[2]), person[3],
							Double.parseDouble(person[4]), Double.parseDouble(person[5]), person[6],
							new BankDetails(person[7], Long.parseLong(person[8]), person[9]));
				}
			}
		} catch (NumberFormatException | IOException | ParseException e) {
			throw new NotFoundException(AADHAAR_NUMBER_NOT_FOUND);
		}
		throw new NotFoundException(AADHAAR_NUMBER_NOT_FOUND);
	}
	
	@PostConstruct
	public void savePensionerData() throws Exception {
		log.info("STARTED - savePensionerData");
		List<PensionerDetailEntity> pensionerDetailList = new ArrayList<>();

		try {

//			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/details.csv"));
			BufferedReader br = new BufferedReader(
					new InputStreamReader(this.getClass().getResourceAsStream("/details.csv")));
			log.info("inside buffered reader");
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				log.info("before Entity Object creation");
				PensionerDetailEntity pensionerDetail = new PensionerDetailEntity();
				log.info("entity object created");
				pensionerDetail.setAadhaarNumber(data[0]);
				pensionerDetail.setName(data[1]);
				pensionerDetail.setDateOfBirth(DateUtil.parseDate(data[2]));
				pensionerDetail.setPanNumber(data[3]);
				pensionerDetail.setSalary(Double.parseDouble(data[4]));
				pensionerDetail.setAllowance(Double.parseDouble(data[5]));
				pensionerDetail.setPensionType(data[6]);
				pensionerDetail.setBankDetail(new BankDetails(data[7], Long.valueOf(data[8]), data[9]));
				
				pensionerDetailList.add(pensionerDetail);
			}

		} catch (IOException e) {
			log.error("EXCEPTION - savePensionerData");
			throw new Exception("pensioner detail not added");
		}
		
		pensionerDetailsRepository.saveAll(pensionerDetailList);
//		System.out.println(pensionerDetailList);
		log.info("END - savePensionerData");
	}
	
	//get all pensioner details as list
	public List<PensionerDetailEntity> getAllPensionerDetails(){
		log.info("STARTED - getAllPensionerDetails");
		try {
			List<PensionerDetailEntity> pensionerList = pensionerDetailsRepository.findAll();
			log.info("END - getAllPensionerDetails");
			return pensionerList;
		} catch (NumberFormatException e) {
			throw new NotFoundException(AADHAAR_NUMBER_NOT_FOUND);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new NotFoundException(AADHAAR_NUMBER_NOT_FOUND);
	}

}
