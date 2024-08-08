package com.je.hospital.service;

import com.je.hospital.entity.Doctor;

import java.util.List;

public interface DoctorService {
    public int delete(Long id);

    public Doctor update(Doctor doctor);

    public Doctor insert(Doctor doctor);

    public List<Doctor> search();

    public Doctor findById(Long id);

}
