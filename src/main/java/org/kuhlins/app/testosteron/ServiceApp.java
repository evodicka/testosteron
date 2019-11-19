package org.kuhlins.app.testosteron;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ServiceApp {
	
	private Date dateStart = new Date();
	
	public Date getDateStart() {
		return dateStart;
	}
	
}
