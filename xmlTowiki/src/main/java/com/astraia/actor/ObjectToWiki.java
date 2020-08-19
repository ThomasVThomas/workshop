package com.astraia.actor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.astraia.report.stub.Bold;
import com.astraia.report.stub.Italic;
import com.astraia.report.stub.Report;
import com.astraia.report.stub.Section;

public class ObjectToWiki {
	/**
	 * 
	 * @param report
	 * @param fileName
	 * @param location
	 * 
	 * test java doc
	 */
	public static void generateWikiFile(Report report, String fileName,String location){
		
		StringBuilder reportTxt = new StringBuilder();
		
		if(report!=null && report.getContent()!=null && report.getContent().size()>0){
			handleContents(reportTxt, report.getContent(),1);
		}
		
		System.out.println(reportTxt.toString());
		
		File file = new File(location+(String) File.separator+fileName.replace(".xml", ".wiki"));
		try {
			FileUtils.writeStringToFile(file, reportTxt.toString().replaceAll("(?m)^[ \t]*\r?\n",""),Charset.defaultCharset());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private static void handleContent(StringBuilder reportTxt, Object content, int level) {
		if(content!=null){
			if(content instanceof Section){
				handleSection(reportTxt,(Section)content,level);
			}else if(content instanceof Bold){
				handleBold(reportTxt,(Bold)content,level);
			}
			else if(content instanceof Italic){
				handleItalics(reportTxt,(Italic)content,level);
			}
			else if(content instanceof String){
				setText(reportTxt,(String)content,level);
			}
		}
	
	}
	
	
	private static void setHeading(StringBuilder reportTxt,String header, int headerDepth ){
		
		for(int i =0;i<headerDepth;i++){
			header ="="+header+"=";
		}reportTxt.append("\n");
		setText(reportTxt,header,headerDepth);
		//reportTxt.append("\n");
		
	}
	
	private static void handleBold(StringBuilder reportTxt,Bold content,int level){
		
		String endString = reportTxt.substring(reportTxt.length()-1, reportTxt.length());
		if(!endString.contains("\n") && !endString.contains("'")){
			reportTxt.append(" ");
		}
		
		reportTxt.append("'''");
		handleContents(reportTxt,content.getContent(),level);
		reportTxt.append("'''");
	}
	
	private static void handleItalics(StringBuilder reportTxt,Italic content,int level){
		String endString = reportTxt.substring(reportTxt.length()-1, reportTxt.length());
		if(!endString.contains("\n") && !endString.contains("'")){
			reportTxt.append(" ");
		}
		reportTxt.append("''");
		handleContents(reportTxt,content.getContent(),level);
		reportTxt.append("''");
	}
	
	private static void setText(StringBuilder reportTxt,String content,int level){
		if(content!=null){
			
			if(!content.trim().equals("")){
				reportTxt.append(content.trim());
			}
		}
	}
	
	
	private static void handleSection(StringBuilder reportTxt,Section section,int level){
		
		if(section.getHeading()!=null){
			setHeading(reportTxt, section.getHeading(), level);	
		}
		List<Object> contents = section.getContent();
		if(contents!=null){
			reportTxt.append("\n");
			
			for(int i=0;i<contents.size();i++){
				handleContent(reportTxt,contents.get(i),level+1);
				if(i>0 && i<contents.size()-1){
					if(contents.get(i) instanceof String){
						if(contents.get(i-1) instanceof Bold && contents.get(i+1) instanceof Bold){
							reportTxt.append("\n");
						}
					}
					
				}
			}
			
			reportTxt.append("\n");
		}
		
	}


	private static void handleContents(StringBuilder reportTxt, List<Object> contents,int level) {
		if(contents!=null){
		contents.forEach((content)->
		handleContent(reportTxt,content,level));
		}
	}

	
	
}
