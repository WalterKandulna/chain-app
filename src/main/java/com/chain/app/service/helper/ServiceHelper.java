package com.chain.app.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chain.app.handler.AccountServiceHandler;
import com.chain.app.handler.EmployeeServiceHandler;
import com.chain.app.handler.ManagementServiceHandler;
import com.chain.app.handler.ServiceHandler;

@Service
public class ServiceHelper {
	
	@Autowired private EmployeeServiceHandler employeeServiceHandler;
	
	@Autowired private ManagementServiceHandler managementServiceHandler;
	
	@Autowired private AccountServiceHandler accountServiceHandler;
	
	
	public ServiceHandler getServiceHandler() {
		
		employeeServiceHandler
			.nextHandler(accountServiceHandler)
			.nextHandler(managementServiceHandler);
		
		return employeeServiceHandler;
		
	}
}
