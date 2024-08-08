package com.je.hospital.service.impl;

import com.je.hospital.entity.Doctor;
import com.je.hospital.repository.DoctorRepository;
import com.je.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public int delete(Long id) {
        doctorRepository.deleteById(1L);
        return 0;
    }

    @Override
    public Doctor update(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor insert(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> search() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        return doctor.get();
    }
}
