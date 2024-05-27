package ro.unibuc.hello.data.entity;

import org.junit.jupiter.api.Test;
import ro.unibuc.hello.TestUtils;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    @Test
    void testPatient() {
        Date dob = new Date();
        Patient patient = TestUtils.buildTestPatient("1", "Lucian Iliescu", "Craiovei", "0722222222", dob, "1");

        assertEquals("1", patient.getId());
        assertEquals("Lucian Iliescu", patient.getName());
        assertEquals("Craiovei", patient.getAddress());
        assertEquals("0722222222", patient.getPhoneNumber());
        assertEquals(dob, patient.getDoB());
        assertEquals("1", patient.getClinicId());
    }

    @Test
    void testToString() {
        Date dob = new Date();
        Patient patient = TestUtils.buildTestPatient("1", "Lucian Iliescu", "Craiovei", "0722222222", dob, "1");

        String expected = "Patient(id=1, name=Lucian Iliescu, address=Craiovei, phoneNumber=0722222222, DoB=" + dob.toString() + ", clinicId=1)";
        assertEquals(expected, patient.toString());
    }

    @Test
    void testEqualsAndHashCode() {
        Date dob = new Date();
        Patient patient1 = TestUtils.buildTestPatient("1", "John Doe", "123 Main St", "0712345678", dob, "1");
        Patient patient2 = TestUtils.buildTestPatient("1", "John Doe", "123 Main St", "0712345678", dob, "1");

        assertEquals(patient1, patient2);
        assertEquals(patient1.hashCode(), patient2.hashCode());
    }

    @Test
    void testNoArgsConstructor() {
        Patient patient = new Patient();
        Date dob = new Date();
        patient.setId("1");
        patient.setName("John Doe");
        patient.setAddress("123 Main St");
        patient.setPhoneNumber("0712345678");
        patient.setDoB(dob);
        patient.setClinicId("1");

        assertEquals("1", patient.getId());
        assertEquals("John Doe", patient.getName());
        assertEquals("123 Main St", patient.getAddress());
        assertEquals("0712345678", patient.getPhoneNumber());
        assertEquals(dob, patient.getDoB());
        assertEquals("1", patient.getClinicId());
    }

    @Test
    void testAllArgsConstructor() {
        Date dob = new Date();
        Patient patient = new Patient("1", "John Doe", "123 Main St", "0712345678", dob, "1");

        assertEquals("1", patient.getId());
        assertEquals("John Doe", patient.getName());
        assertEquals("123 Main St", patient.getAddress());
        assertEquals("0712345678", patient.getPhoneNumber());
        assertEquals(dob, patient.getDoB());
        assertEquals("1", patient.getClinicId());
    }

    @Test
    void testBuilder() {
        Date dob = new Date();
        Patient patient = Patient.builder()
                .id("1")
                .name("John Doe")
                .address("123 Main St")
                .phoneNumber("0712345678")
                .DoB(dob)
                .clinicId("1")
                .build();

        assertEquals("1", patient.getId());
        assertEquals("John Doe", patient.getName());
        assertEquals("123 Main St", patient.getAddress());
        assertEquals("0712345678", patient.getPhoneNumber());
        assertEquals(dob, patient.getDoB());
        assertEquals("1", patient.getClinicId());
    }
}