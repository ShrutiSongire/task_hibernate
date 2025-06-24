package com.service;

import com.dao.StudentDao;

public class Service {
	
	public void InsertData() {
		StudentDao ed=new StudentDao();
		ed.insert();
	}
	public void UpdateData() {
		StudentDao ed=new StudentDao();
		ed.update();
	}
	public void DeleteData() {
		StudentDao ed=new StudentDao();
		ed.delete();
	}
	public void SelectData() {
		StudentDao ed=new StudentDao();
		ed.select();
	}


}
