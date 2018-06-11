package com.country.lookup.client.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.country.lookup.client.domain.IPAddressBean;

/**
 * Class to read a file data and load into a list
 * 
 * @author Samuel Radingwane
 *
 */
public class FileHelper {
	
	public List<IPAddressBean> readFile (File file) {
		List<IPAddressBean> addresses = new ArrayList<>();
		
	     try (BufferedReader in=new BufferedReader(new FileReader(file.getAbsolutePath()))) {
	    	 
				String line;
				String[] lineSplit;

				// read file data and add to list
				System.out.println("============= File Data =======");
				while ((line = in.readLine()) != null) {
					System.out.println(line);
					
					// split the line into IP Address and Company Name. And add to list
					lineSplit = line.split(",");
			    	addresses.add(new IPAddressBean(lineSplit[0], lineSplit[1]));
				}
				System.out.println("============= File Data =======\n\n");

	     } catch (FileNotFoundException e) {
	        System.err.println("File Not Found :: " + e.getMessage());
	        e.printStackTrace();
	        
	    } catch (IOException e) {
	        System.err.println("IO Exception :: " + e.getMessage());
	        e.printStackTrace();
	    }
	     return addresses;
	}

}
