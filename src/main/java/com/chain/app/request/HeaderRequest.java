package com.chain.app.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeaderRequest {
	
	@JsonProperty("contentid")
	private String contentId;
	
	@JsonProperty("clientid")
	private String clientId;
	
}
