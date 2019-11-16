package com.example.demo;

import java.util.ArrayList;
import java.util.Map;

public class Demo {

	private int id;
	private String name;
	private String status;
	
	private Map<String,String> jobStatusMap;

	private ArrayList<Object> jobStatusList;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public Map<String, String> getJobStatusMap() {
		return jobStatusMap;
	}

	public void setJobStatusMap(Map<String, String> jobStatusMap) {
		this.jobStatusMap = jobStatusMap;
	}

	public ArrayList<Object> getJobStatusList() {
		return jobStatusList;
	}

	public void setJobStatusList(ArrayList<Object> jobStatusList) {
		this.jobStatusList = jobStatusList;
	}


	

}
