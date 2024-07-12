package com.chain.app.handler;

import org.springframework.stereotype.Service;
import com.chain.app.request.ChainRequest;
import com.chain.app.request.HeaderRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ManagementServiceHandler extends ServiceHandler {
	
	@Override
	public boolean execute(ChainRequest request, HeaderRequest header, String action) {
		log.info("ManagementServiceHandler performing {}", action);
		request.setCurrentStatus(getCurrentStatus(action));
		return true;
	}
	
	private String getCurrentStatus(String action) {
		return String.join(SPACE, action, this.getClass().getSimpleName());
	}

}
