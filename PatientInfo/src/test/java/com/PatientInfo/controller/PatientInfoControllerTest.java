package com.PatientInfo.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.PatientInfo.entity.Patient;
import com.PatientInfo.service.PatientInfoService;



@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class PatientInfoControllerTest {

	@InjectMocks
	PatientInfoController patientInfoController;
	
	@Mock
	PatientInfoService patientInfoService;
	
	@Mock
	RestTemplate restTemplate;
	
	@Test
	public void testCreatePatient() {
		
		Patient patient = new Patient(Long.valueOf(1), "sai", "Sathi", new Date());
		Mockito.doNothing().when(patientInfoService)
			   .createPatientInfo(patient);
		
		ResponseEntity responseEntity= patientInfoController.createPatientInfo(patient);
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void testGetPatientById() {
		Patient patient = new Patient(Long.valueOf(1), "sai", "Sathi", new Date());
		when(patientInfoService.getPatientById(Long.valueOf(1))).thenReturn(patient);
		ResponseEntity<Patient> responseEntity = patientInfoController.getPatientById(Long.valueOf(1));
		
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Assert.assertEquals("sai", responseEntity.getBody().getName());
		Assert.assertEquals("Sathi", responseEntity.getBody().getVisitedDoctor());
	}

	@Test
	public void testGetAllPatientsInfo() {
		
		List<Patient> patient = new ArrayList<>();
		Patient patient1 = new Patient(Long.valueOf(1), "sai", "Sathi", new Date());
		Patient patient2 = new Patient(Long.valueOf(2), "Pushu", "Anusha", new Date());
		
		patient.add(patient1);
		patient.add(patient2);
		
		when(patientInfoService.getAllPatientsInfo()).thenReturn(patient);
		ResponseEntity<List<Patient>> responseEntity = patientInfoController.getAllPatientsInfo();
		
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
		Assert.assertEquals(2, responseEntity.getBody().size());
		Assert.assertEquals("sai", responseEntity.getBody().get(0).getName());
		Assert.assertEquals("Sathi", responseEntity.getBody().get(0).getVisitedDoctor());
		
		Assert.assertEquals("Pushu", responseEntity.getBody().get(1).getName());
		Assert.assertEquals("Anusha", responseEntity.getBody().get(1).getVisitedDoctor());
	}

	

}
