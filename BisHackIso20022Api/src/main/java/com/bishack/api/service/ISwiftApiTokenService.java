package com.bishack.api.service;

import com.bishack.api.dto.SwiftTokenDto;

public interface ISwiftApiTokenService {
	SwiftTokenDto getSwiftPrevalAuthToken();
	
	SwiftTokenDto getSwiftComplianceAuthToken();

}
