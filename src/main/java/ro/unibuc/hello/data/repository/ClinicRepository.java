package ro.unibuc.hello.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ro.unibuc.hello.data.entity.Clinic;

import java.util.*;

@Repository
public interface ClinicRepository extends MongoRepository<Clinic, String> {
    List<Clinic> findByName(String name);
    List<Clinic> findByAdress(String adress);
}