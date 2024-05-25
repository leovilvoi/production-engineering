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
}
