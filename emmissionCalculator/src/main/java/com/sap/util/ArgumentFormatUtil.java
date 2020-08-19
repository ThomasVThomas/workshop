package com.sap.util;

import java.util.HashMap;
import java.util.Map;

public class ArgumentFormatUtil {
	
	
	public static Map<String,String>  getArgumentMap(String[] args){
		Map<String,String> argMap = new HashMap<>();
		
		for (int i=0;i<args.length ;i++) {
			if(args[i].trim()!=""){
				String[] splitFromEqual = args[i].split("=");
				if(splitFromEqual.length==2){
					String key = splitFromEqual[0].substring(2);
					String value = splitFromEqual[1].replaceAll("--", "");
					argMap.put(key, value);
				}else if(i+1 <args.length){
					argMap.put(args[i].replaceAll("--", ""), args[i+1]);
					i++;
				}
			}
		}
		
		return argMap;
	}

}
