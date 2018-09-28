package com.wdhybridFW.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	
		Properties pro = new Properties(); //This is a builtin method in java
		
		public ReadConfig()//This is a constructor 
		{
			File src = new File("./Configuration/config.properties");
			System.out.println("In Readconfig file");
			
			//Using Try catch block to catch exceptions in case of any failures
			
			try
			{
				FileInputStream fis = new FileInputStream(src);
				pro.load(fis);
				System.out.println("File loaded successfully");
				
			}catch(Exception e)
			{
				System.out.println("Exception is " + e.getMessage());
			}
			
		}
		
		public String getApplicationURL()
		{
			String url = pro.getProperty("baseURL");
			return url;
		}
		
		public String getUserName()
		{
			String userName = pro.getProperty("username");
						return userName;
		}
		public String getPassword()
		{
			String Password = pro.getProperty("password");
			System.out.println(Password);
			return Password;
		}
		public String getChromePath()
		{
			String chromepath = pro.getProperty("chromepath");
			return chromepath;
		}
		public String getFirefoxPath()
		{
			String firefoxpath = pro.getProperty("firefoxpath");
			System.out.println(firefoxpath);
			return firefoxpath;
		}
		public String getIEPath()
		{
			String IEpath = pro.getProperty("IEpath");
			return IEpath;
		}
		
		public String getRole()
		{
			String role = pro.getProperty("Sup_Org_Id");
			return role;
		}
		
		//If new Variables are added in config.properties files, new methods should be added in this file to make them accessible.
}
