package com.country.lookup.client;

import java.io.File;
import java.util.Collections;
import java.util.List;

import com.country.lookup.client.domain.IPAddressBean;
import com.country.lookup.client.helper.FileHelper;
import com.country.lookup.client.helper.RestCallerHelper;

/**
 * Main class to control a flow from reading a file to calling a service and print results
 * 
 * @author Samuel Radingwane   
 *
 */
public class MainClient {
	
	public static void main(String... args) {
		FileHelper fileHelper = new FileHelper();
		RestCallerHelper restCallerHelper = new RestCallerHelper();
		
		File file = new File("data/test.txt");
		
		// read file data
		List<IPAddressBean> addresses = fileHelper.readFile(file);
		
		// sort list
		Collections.sort(addresses);
		
		// test data against the service
		addresses.forEach(addressBean -> { addressBean.setResult(restCallerHelper.getCountry(addressBean.getIpAddress())); });
		
		// print results
		System.out.println("============================= Results ====================================");
		addresses.forEach(addressBean -> System.out.println(addressBean.toString()) );
		System.out.println("============================= Results ====================================");
	}

	

}
