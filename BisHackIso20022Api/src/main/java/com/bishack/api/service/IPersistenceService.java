package com.bishack.api.service;

import java.util.List;
import com.bishack.api.entity.TrxRecord;

public interface IPersistenceService {
	
	List<TrxRecord> getAllRecords();
	
	TrxRecord saveRecord(TrxRecord record);
}
