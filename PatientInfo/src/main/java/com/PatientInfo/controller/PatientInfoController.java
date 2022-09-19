package com.PatientInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PatientInfo.entity.Patient;
import com.PatientInfo.service.PatientInfoService;

@RestController
@RequestMapping("/PatientInfo")
public class PatientInfoController {
	
	@Autowired
	private PatientInfoService patientInfoServices;
	
	@PostMapping("/create")
	public ResponseEntity createPatientInfo(@RequestBody Patient patient) {
		patientInfoServices.createPatientInfo(patient);
		return new ResponseEntity(HttpStatus.OK);		
	}
	
	@GetMapping("/getPatient/{patientId}")
	public ResponseEntity<Patient> getPatientById(@PathVariable(value="patientId") Long id) {
		return new ResponseEntity(patientInfoServices.getPatientById(id), HttpStatus.OK);		
	}
	
	@GetMapping("/getAllPatientsInfo")
	public ResponseEntity<List<Patient>> getAllPatientsInfo() {
		return new ResponseEntity(patientInfoServices.getAllPatientsInfo(), HttpStatus.OK);
		
	}

}
