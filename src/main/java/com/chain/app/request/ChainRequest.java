package com.chain.app.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChainRequest {
	private Integer id;
	private String name;
	private String currentStatus;
}
