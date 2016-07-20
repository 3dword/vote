package com.sinaapp.whu13ds.vote.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	public static String remove(String args){
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(args);
		String str = m.replaceAll("");
		return str;
	}
}
