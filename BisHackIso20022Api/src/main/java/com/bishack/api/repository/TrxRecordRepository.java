package com.bishack.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bishack.api.entity.TrxRecord;

public interface TrxRecordRepository extends MongoRepository<TrxRecord, String> { 
	List<TrxRecord> findByCreditorName(String creditorName);
	List<TrxRecord> findByCreditorAccount(String creditorAccount);
}