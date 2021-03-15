package com.bishack.api.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bishack.config.AppProperties;

import de.flapdoodle.embed.mongo.MongoDumpExecutable;
import de.flapdoodle.embed.mongo.MongoRestoreExecutable;

@Controller
public class ApiCmnController {

	@Autowired
	private AppProperties appProperties;

	//@Autowired
	private MongoDumpExecutable mongoDBDumper;

	//@Autowired
	private MongoRestoreExecutable mongoDbrestorer;

	@GetMapping(path = "/dumpMongoDB")
	@ResponseBody
	public ResponseEntity<String> dumpMongoDB() {

		File tempDirectory = new File(appProperties.getMongodbDumpLoc());
		tempDirectory.delete();
		tempDirectory.mkdir();
		try {
			mongoDBDumper.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	@GetMapping(path = "/restoreMongoDB")
	@ResponseBody
	public ResponseEntity<String> restoreMongoDB() {

		try {
			mongoDbrestorer.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

}
