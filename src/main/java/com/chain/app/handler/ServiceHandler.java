package com.chain.app.handler;

import java.util.Objects;
import com.chain.app.request.ChainRequest;
import com.chain.app.request.HeaderRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ServiceHandler {
	
	public static final String SPACE = "-";
	
	private ServiceHandler nextHandler;
	
	public abstract boolean execute(ChainRequest request, HeaderRequest header, String action);
	
	public boolean executeServiceFlow(ChainRequest request, HeaderRequest header, String action) {
		
		String handlerName = getHandlerName();
				
		log.info("executing handler: {}", handlerName);
		
		try {
			
			Boolean response = this.execute(request, header, action);
			
			log.info("response: {} from handler: {}", response, handlerName);
			
			if(Objects.isNull(response) || Boolean.FALSE.equals(response)) {
				return false;
			}
			
			if(this.nextHandler == null) {
				return response;
			}
			
			return this.nextHandler.executeServiceFlow(request, header, action);
		}
		catch(Exception ex) {
			log.error("exception occured while executing handler: {} exception: ", handlerName, ex);
			return false;
		}	
	}
	
	public ServiceHandler nextHandler(ServiceHandler nextHandler) {
		this.nextHandler = nextHandler;
		return nextHandler;
	}
	
	private String getHandlerName() {
		return this.getClass().getSimpleName();
	}
}
