package com.PatientInfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.PatientInfo.entity.Patient;
import com.PatientInfo.repository.PatientInfoRepository;

@Service
@ComponentScan
@ConfigurationProperties
public class PatientInfoService {
	
	@Autowired
	private PatientInfoRepository patientInfoRepository;

	public void createPatientInfo(Patient patient) {
		// TODO Auto-generated method stub
		patientInfoRepository.save(patient);
		
	}

	public Object getPatientById(Long id) {
		// TODO Auto-generated method stub
		return patientInfoRepository.findById(id).get();
	}

	public List<Patient> getAllPatientsInfo() {
		// TODO Auto-generated method stub
		return patientInfoRepository.findAll();
	}

}
