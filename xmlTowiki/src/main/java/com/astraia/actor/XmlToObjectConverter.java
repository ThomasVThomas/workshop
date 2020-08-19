package com.astraia.actor;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.astraia.report.stub.Report;

public class XmlToObjectConverter {
	
	
	
	public static Report getReportFromXML(File file) throws JAXBException{
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
		Unmarshaller  unmarshaller = jaxbContext.createUnmarshaller();
		Report report = (Report)unmarshaller.unmarshal(file);
		
		return report;
	}
	

}
