package com.gestaofilas.controller.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
	
	public static String decodeParam(String string) {
		try {
			return URLDecoder.decode(string, "UTF-8");	
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static List<Integer> decodeIntList(String integers){
		List<Integer> list = new ArrayList<Integer>();
		String[] vet = integers.split(",");
		
		for(int i = 0; i < vet.length; i++) {
			list.add(Integer.parseInt(vet[i]));
		}
		
		return list;
	}

}
