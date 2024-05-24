package ro.unibuc.hello.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ro.unibuc.hello.data.entity.Patient;

import java.util.*;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    List<Patient> findByName(String name);
    List<Patient> findByClinicId(String clinicId);
}