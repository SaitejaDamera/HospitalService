package com.DoctorsInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DoctorsInfo.entity.Doctors;

@Repository
public interface DoctorsInfoRepository extends JpaRepository<Doctors, Long> {
	
	Doctors findDoctorsById(Long doctorsId);

}
