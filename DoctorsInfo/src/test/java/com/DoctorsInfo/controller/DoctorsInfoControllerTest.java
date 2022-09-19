package com.DoctorsInfo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.junit.platform.runner.JUnitPlatform;

import com.DoctorsInfo.entity.Doctors;
import com.DoctorsInfo.service.DoctorsInfoService;
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class DoctorsInfoControllerTest {
	
	@InjectMocks
	DoctorsInfoController doctorsInfoController;
	
	@Mock
	DoctorsInfoService doctorsInfoService;
	
	@Mock
	RestTemplate restTemplate;
	
	@Test
	public void testCreateDoctors() {
		
		Doctors doctor = new Doctors(Long.valueOf(1), "sai", Long.valueOf(22), "Male", "Orthopedic");
		Mockito.doNothing().when(doctorsInfoService)
			   .createDoctorsInfo(doctor);
		
		//when(restTemplate.getForObject(anyString(), eq(Doctors.class))).thenReturn(null);
		
		ResponseEntity responseEntity= doctorsInfoController.createDoctorsInfo(doctor);
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void testGetDoctorsById() {
		Doctors doctor = new Doctors(Long.valueOf(1), "sai", Long.valueOf(22), "Male", "Orthopedic");
		when(doctorsInfoService.getDoctorsById(Long.valueOf(1))).thenReturn(doctor);
		ResponseEntity<Doctors> responseEntity = doctorsInfoController.getDoctorsById(Long.valueOf(1));
		
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		Assert.assertEquals("sai", responseEntity.getBody().getName());
		Assert.assertEquals("Orthopedic", responseEntity.getBody().getSpecialistField());
	}

	@Test
	public void testGetAllDoctorsInfo() {
		
		List<Doctors> doctors = new ArrayList<>();
		Doctors doctor1 = new Doctors(Long.valueOf(1), "sai", Long.valueOf(22), "Male", "Orthopedic");
		Doctors doctor2 = new Doctors(Long.valueOf(2), "saiTeja", Long.valueOf(24), "Male", "Surgeon");
		
		doctors.add(doctor1);
		doctors.add(doctor2);
		
		when(doctorsInfoService.getAllDoctorsInfo()).thenReturn(doctors);
		ResponseEntity<List<Doctors>> responseEntity = doctorsInfoController.getAllDoctorsInfo();
		
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		
		Assert.assertEquals(2, responseEntity.getBody().size());
		Assert.assertEquals("sai", responseEntity.getBody().get(0).getName());
		Assert.assertEquals("Orthopedic", responseEntity.getBody().get(0).getSpecialistField());
		
		Assert.assertEquals("saiTeja", responseEntity.getBody().get(1).getName());
		Assert.assertEquals("Surgeon", responseEntity.getBody().get(1).getSpecialistField());
	}


}
