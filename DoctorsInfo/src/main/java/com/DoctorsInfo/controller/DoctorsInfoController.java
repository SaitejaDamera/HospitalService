package com.DoctorsInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.DoctorsInfo.entity.Doctors;
import com.DoctorsInfo.service.DoctorsInfoService;

@RestController
@RequestMapping("/doctorsInfo")
@CrossOrigin
public class DoctorsInfoController {
	
	@Autowired
	private DoctorsInfoService doctorsInfoService;
	
	@PostMapping("/create")
	public ResponseEntity createDoctorsInfo(@RequestBody Doctors doctors) {
		doctorsInfoService.createDoctorsInfo(doctors);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/getdoctors/{doctorsId}")
	public ResponseEntity<Doctors> getDoctorsById(@PathVariable(value="doctorsId") Long id){
		return new ResponseEntity(doctorsInfoService.getDoctorsById(id), HttpStatus.OK);	
	}
	
	@GetMapping("/getAllDoctorsInfo")
	public ResponseEntity<List<Doctors>> getAllDoctorsInfo(){
		return new ResponseEntity(doctorsInfoService.getAllDoctorsInfo(), HttpStatus.OK);
		
	}

}
