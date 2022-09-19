package com.PatientInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PatientInfo.entity.Patient;

@Repository
public interface PatientInfoRepository extends JpaRepository<Patient, Long>{
	
}
