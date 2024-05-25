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
}