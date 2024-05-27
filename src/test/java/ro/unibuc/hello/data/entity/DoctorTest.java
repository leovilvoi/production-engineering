package ro.unibuc.hello.data.entity;

import org.junit.jupiter.api.Test;
import ro.unibuc.hello.TestUtils;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    @Test
    void testDoctor() {
        Doctor doctor = TestUtils.buildTestDoctor("1", "Andrei Popescu", "Cardiology", "0711111111", "doctor@example.com", "1");

        assertEquals("1", doctor.getId());
        assertEquals("Andrei Popescu", doctor.getName());
        assertEquals("Cardiology", doctor.getSpecialization());
        assertEquals("0711111111", doctor.getPhoneNumber());
        assertEquals("doctor@example.com", doctor.getEmail());
        assertEquals("1", doctor.getClinicId());
    }

    @Test
    void testToString() {
        Doctor doctor = TestUtils.buildTestDoctor("1", "Andrei Popescu", "Cardiology", "0711111111", "doctor@example.com", "1");

        String expected = "Doctor(id=1, name=Andrei Popescu, specialization=Cardiology, phoneNumber=0711111111, email=doctor@example.com, clinicId=1)";
        assertEquals(expected, doctor.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Doctor doctor1 = TestUtils.buildTestDoctor("1", "Dr. Smith", "Cardiology", "0712345678", "dr.smith@example.com", "1");
        Doctor doctor2 = TestUtils.buildTestDoctor("1", "Dr. Smith", "Cardiology", "0712345678", "dr.smith@example.com", "1");

        assertEquals(doctor1, doctor2);
        assertEquals(doctor1.hashCode(), doctor2.hashCode());
    }

    @Test
    void testNoArgsConstructor() {
        Doctor doctor = new Doctor();
        doctor.setId("1");
        doctor.setName("Dr. Smith");
        doctor.setSpecialization("Cardiology");
        doctor.setPhoneNumber("0712345678");
        doctor.setEmail("dr.smith@example.com");
        doctor.setClinicId("1");

        assertEquals("1", doctor.getId());
        assertEquals("Dr. Smith", doctor.getName());
        assertEquals("Cardiology", doctor.getSpecialization());
        assertEquals("0712345678", doctor.getPhoneNumber());
        assertEquals("dr.smith@example.com", doctor.getEmail());
        assertEquals("1", doctor.getClinicId());
    }

    @Test
    void testAllArgsConstructor() {
        Doctor doctor = new Doctor("1", "Dr. Smith", "Cardiology", "0712345678", "dr.smith@example.com", "1");

        assertEquals("1", doctor.getId());
        assertEquals("Dr. Smith", doctor.getName());
        assertEquals("Cardiology", doctor.getSpecialization());
        assertEquals("0712345678", doctor.getPhoneNumber());
        assertEquals("dr.smith@example.com", doctor.getEmail());
        assertEquals("1", doctor.getClinicId());
    }

    @Test
    void testBuilder() {
        Doctor doctor = Doctor.builder()
                .id("1")
                .name("Dr. Smith")
                .specialization("Cardiology")
                .phoneNumber("0712345678")
                .email("dr.smith@example.com")
                .clinicId("1")
                .build();

        assertEquals("1", doctor.getId());
        assertEquals("Dr. Smith", doctor.getName());
        assertEquals("Cardiology", doctor.getSpecialization());
        assertEquals("0712345678", doctor.getPhoneNumber());
        assertEquals("dr.smith@example.com", doctor.getEmail());
        assertEquals("1", doctor.getClinicId());
    }
}

