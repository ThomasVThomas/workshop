package com.astraia.actor;

import java.io.File;
import java.io.FilenameFilter;

import javax.xml.bind.JAXBException;

public class ReportToWikiInvoker {
	
	public static void main(String [] args){
		String srcLocation = "C:\\Users\\tvt\\Desktop\\examples";//args[0];
		String destLocation ="C:\\Users\\tvt\\Desktop\\examples"; //args[1];
		
		
		
		File src = new  File(srcLocation);
		File [] files = src.listFiles(new FilenameFilter(){
			
		public boolean accept(File dir,String name){
				return name.toUpperCase().endsWith("XML");
			}
		});
		
		if(files!=null && files.length>0){
			for(File file:files){
				try {
					ObjectToWiki.generateWikiFile(
							XmlToObjectConverter.getReportFromXML(file), 
												file.getName(), destLocation);
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		

		
	}

}
