package com.anataarisa.pimtool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PimToolApplication {
	private static DemoData data;
	@Autowired
	PimToolApplication(DemoData data) {
		this.data = data;
	}
	public static void main(String[] args) {
		SpringApplication.run(PimToolApplication.class, args);
		data.addEmployee();
		data.addGroup();
	}


}
