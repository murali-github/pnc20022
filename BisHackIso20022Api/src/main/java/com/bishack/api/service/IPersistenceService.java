package com.bishack.api.service;

import java.util.List;
import com.bishack.api.entity.TxRecord;

public interface IPersistenceService {
	
	List<TxRecord> getAllRecords();
	
	TxRecord saveRecord(TxRecord record);
}
