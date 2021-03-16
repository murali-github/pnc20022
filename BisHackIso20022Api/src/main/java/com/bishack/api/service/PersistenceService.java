package com.bishack.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishack.api.entity.TxRecord;
import com.bishack.api.repository.TxRecordRepository;

@Service
public class PersistenceService implements IPersistenceService {
	
	@Autowired
	private TxRecordRepository recordRepository;
	
	@Override
	public List<TxRecord> getAllRecords() {		
		return recordRepository.findAll();
	}
	
	@Override
	@Transactional
	public TxRecord saveRecord(TxRecord record) {		
		TxRecord savedRecord = recordRepository.save(record);
		return savedRecord;
	}

}
