package com.bishack.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishack.api.entity.TrxRecord;
import com.bishack.api.repository.TrxRecordRepository;

@Service
public class PersistenceService implements IPersistenceService {
	
	@Autowired
	private TrxRecordRepository recordRepository;
	
	@Override
	public List<TrxRecord> getAllRecords() {		
		return recordRepository.findAll();
	}
	
	@Override
	@Transactional
	public TrxRecord saveRecord(TrxRecord record) {		
		TrxRecord savedRecord = recordRepository.save(record);
		return savedRecord;
	}

}
