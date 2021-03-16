package com.bishack.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bishack.api.entity.TxRecord;

public interface TxRecordRepository extends MongoRepository<TxRecord, String> { 
	List<TxRecord> findByCreditorName(String creditorName);
	List<TxRecord> findByCreditorAccount(String creditorAccount);
}