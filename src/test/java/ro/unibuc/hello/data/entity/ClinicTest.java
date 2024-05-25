package ro.unibuc.hello.data.entity;

import org.junit.jupiter.api.Test;
import ro.unibuc.hello.TestUtils;

import static org.junit.jupiter.api.Assertions.*;

public class ClinicTest{

    @Test
    void testClinic(){
        Clinic clinic = new Clinic("1", "MediCare", "Strada Unirii", "0712312312");

        assertEquals("1", clinic.getId());
        assertEquals("MediCare", clinic.getName());
        assertEquals("Strada Unirii", clinic.getAddress());
        assertEquals("0712312312", clinic.getPhoneNumber());
    }

    @Test
    void testToString(){
        Clinic clinic = TestUtils.buildTestClinic("1", "MediCare", "Strada Unirii", "0712312312");

        String expected = "Clinic(id=1, name=MediCare, address=Strada Unirii, phoneNumber=0712312312)";
        assertEquals(expected, clinic.toString());
    }
}