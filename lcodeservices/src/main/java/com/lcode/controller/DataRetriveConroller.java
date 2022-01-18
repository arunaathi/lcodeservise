package com.lcode.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcode.exception.UserException;
import com.lcode.model.Accounts;
import com.lcode.model.Customer;
import com.lcode.model.CustomerAccountsDtl;
import com.lcode.service.CustomerService;

/**
 * 
 * @author Arunmugesh J
 *
 */
@RestController
@RequestMapping("LcodeDataRetrive")
@CrossOrigin(origins = "*")
public class DataRetriveConroller {

	private Logger logger = LoggerFactory.getLogger(DataRetriveConroller.class);
	
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(path = "/healthcheck")
	@ResponseBody
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Hi! I am Lcode Data Retrive Service and I am up and running", HttpStatus.OK);
	}

	@PostMapping(path = "/checkToken")
	@ResponseBody
	public ResponseEntity<String> checkToken(@RequestParam("Token") String token) {
		System.out.println("Before...................");
		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}

	@GetMapping(path = "/getEntityData")
	@ResponseBody
	public ResponseEntity<Object> getEntityData(@RequestParam("processDoc") String processDoc) {
		String returnString = "Response Data";
		return new ResponseEntity<>(returnString, HttpStatus.OK);
	}

	
	@GetMapping(path = "/getData")
	@ResponseBody
	public ResponseEntity<String> getData(@RequestParam("doctype") String doctype) {
		logger.debug("Starts getData method");
		String returnString = "Testing Data";
		logger.debug("Ends getData method");
		return new ResponseEntity<>(returnString, HttpStatus.OK);
	}
	
	@PostMapping(path = "/sentData")
	public ResponseEntity<Object> sentData(@RequestBody String reqDto) {
		System.out.println(reqDto);
		
		try{
			ObjectMapper om=new ObjectMapper();
			CustomerAccountsDtl custaccountdtl=om.readValue(reqDto, CustomerAccountsDtl.class);
			Customer custdtl=custaccountdtl.getCutinfo();
			System.out.println(custdtl.getCustName());
			System.out.println(custaccountdtl.getListAccounts().size());
			return new ResponseEntity<>(custaccountdtl, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		String respinfo="RespInfo--"+reqDto;
		return new ResponseEntity<>("Fail", HttpStatus.OK);
	}
	
	@PutMapping(path = "/saveCustAccount")
	public ResponseEntity<Object> saveCustAccount(@RequestBody String reqDto) {
		System.out.println(reqDto);
		
		try{
			ObjectMapper om=new ObjectMapper();
			CustomerAccountsDtl custaccountdtl=om.readValue(reqDto, CustomerAccountsDtl.class);
			Customer currentcust=custaccountdtl.getCutinfo();
			System.out.println(currentcust.getCustName());
			System.out.println(custaccountdtl.getListAccounts().size());
			/*customerService.saveCustomer(currentcust);
			customerService.saveAllAccount(custaccountdtl.getListAccounts());*/
			customerService.savecutAllAccount(custaccountdtl);
			/*for(Accounts acc:custaccountdtl.getListAccounts()){
				System.out.println(acc.getAccountName());
				customerService.saveAccount(acc);
			}*/
			return new ResponseEntity<>("Success", HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Fail", HttpStatus.OK);
	}
	
	@GetMapping(path = "/getCustomerAccountdtl/{custno}")
	public ResponseEntity<Object> getCustomerAccountdtl(@PathVariable("custno") String custno) {
		System.out.println(custno);
		try{
		CustomerAccountsDtl custaccountdtl=new CustomerAccountsDtl();
		Customer custinfo=customerService.findByCustid(custno);
		custaccountdtl.setCutinfo(custinfo);
		ArrayList<Accounts> accountList=customerService.getAccounts(custno);
		custaccountdtl.setListAccounts(accountList); 
		ObjectMapper om=new ObjectMapper();
		String respinfo=om.writeValueAsString(custaccountdtl);
		return new ResponseEntity<>(respinfo, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Fail", HttpStatus.OK);
	}
	
	@PutMapping(path = "/saveCust")
	public ResponseEntity<Object> saveCust(@RequestBody Customer reqDto) {
		try{
		System.out.println(reqDto.getCustName());
		System.out.println(reqDto.getAge());
		System.out.println(reqDto.getCustnumber());
		customerService.saveCustomer(reqDto);
		return new ResponseEntity<>("Success", HttpStatus.OK);
		}catch (UserException e) {
			e.printStackTrace();
			return new ResponseEntity<>("Fail", HttpStatus.OK);
		}
	}
	
	@PostMapping(path = "/getCust")
	public ResponseEntity<Object> getCust(@RequestBody Customer reqDto) {
		System.out.println(reqDto.getCustnumber());
		Customer respinfo=customerService.findByCustid(reqDto.getCustnumber());
		return new ResponseEntity<>(respinfo, HttpStatus.OK);
	}
	
	@PostMapping(path = "/getAccounts")
	public ResponseEntity<Object> getAccounts(@RequestBody Customer reqDto) {
		try{
		System.out.println(reqDto.getCustnumber());
		ArrayList<Accounts> respinfo=customerService.getAccounts(reqDto.getCustnumber());
		return new ResponseEntity<>(respinfo, HttpStatus.OK);
		}catch (UserException e) {
			e.printStackTrace();
			return new ResponseEntity<>("Fail", HttpStatus.OK);
		}
	}
	
	@PutMapping(path = "/saveAccounts")
	public ResponseEntity<Object> sentCust(@RequestBody ArrayList<Accounts> reqDto) {
		for(Accounts accinfo:reqDto){
			try{
		    	customerService.saveAccount(accinfo);
			}catch (UserException e) {
				e.printStackTrace();
				return new ResponseEntity<>("Fail", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
	
}