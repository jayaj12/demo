package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Value("${version}") 
	private String scheduled;
	
	@RequestMapping("/")
	public Demo home() {
		
	Demo d= new Demo();
	d.setId(1);
	d.setName("Service");
	//d.setStatus("Open");
	
	  Map<String,String> map=new HashMap<String,String>();  
	  map.put("Open",scheduled);  
	  map.put("Scheduled",scheduled);  
	  map.put("Pending",scheduled);  
	  d.setJobStatusMap(map);
	  
	  ArrayList<Integer> list=new ArrayList<Integer>();  
	  list.add(100);  
	  list.add(101);  
	  list.add(102);
	  ArrayList<String> listStr=new ArrayList<String>();  
	  listStr.add("Open");  
	  listStr.add("Scheduled");  
	  listStr.add("Parts Pending");  
	  ArrayList<Object> listComb=new ArrayList<Object>();  
	  listComb.add(listStr);
	  listComb.add(list);
	  d.setJobStatusList(listComb);
	return d;
	}


}
