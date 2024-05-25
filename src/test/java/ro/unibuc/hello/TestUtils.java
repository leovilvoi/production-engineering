package ro.unibuc.hello;

import ro.unibuc.hello.data.entity.*;
import java.util.Date;

public class TestUtils {
    
    public static Clinic buildTestClinic(String id, String name, String adress, String phoneNumber){
        return Clinic.builder()
                .id(id)
                .name(name)
                .address(adress)
                .phoneNumber(phoneNumber)
                .build();
    }

    public static Doctor buildTestDoctor(String id, String name, String specialization, String phoneNumber, String email, String clinicId){
        return Doctor.builder()
                .id(id)
                .name(name)
                .specialization(specialization)
                .phoneNumber(phoneNumber)
                .email(email)
                .clinicId(clinicId)
                .build();
    }

    public static Patient buildTestPatient(String id, String name, String address, String phoneNumber, Date dob, String clinicId){
        return Patient.builder()
                .id(id)
                .name(name)
                .address(address)
                .phoneNumber(phoneNumber)
                .DoB(dob)
                .clinicId(clinicId)
                .build();
    }

    public static Appointment buildTestAppointment(String id, String doctorId, String patientId, Date appointmentDate, String description){
        return Appointment.builder()
                .id(id)
                .doctorId(doctorId)
                .patientId(patientId)
                .appointmentDate(appointmentDate)
                .description(description)
                .build();
    }
}
