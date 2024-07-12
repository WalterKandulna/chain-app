package com.chain.app.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.chain.app.handler.ServiceHandler;
import com.chain.app.request.ChainRequest;
import com.chain.app.request.HeaderRequest;
import com.chain.app.service.helper.ServiceHelper;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ChainingAppController {
	
	@Autowired private ObjectMapper mapper;
	
	@Autowired private ServiceHelper serviceHelper;
	
	@PostMapping(value = "/getResponse")
	public ResponseEntity<Object> getData(@RequestBody ChainRequest request, @RequestHeader Map<String, Object> headers) {
		
		HeaderRequest headerRequest = mapper.convertValue(headers, HeaderRequest.class);
		
		ServiceHandler serviceHandler = serviceHelper.getServiceHandler();
		
		Boolean responseStatus = serviceHandler.executeServiceFlow(request, headerRequest, request.getCurrentStatus());
		
		return ResponseEntity.ok(responseStatus);
		
	}

}
