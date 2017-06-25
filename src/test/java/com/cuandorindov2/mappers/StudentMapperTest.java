package com.cuandorindov2.mappers;

import com.cuandorindov2.main.model.Address;
import com.cuandorindov2.main.model.City;
import com.cuandorindov2.main.model.Email;
import com.cuandorindov2.main.resources.requests.StudentRequest;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by tomas.lingotti on 10/06/17.
 */
public class StudentMapperTest {

    @Before
    public void setUp() {

    }

    @Test
    public void testRequestConvertion() {
        final StudentRequest request = new StudentRequest();
        request.setName("tomas");
        request.setMidName("francisco");
        request.setLastName("Lingotti");
        final Address cordobaStreet = new Address();
        City rosario = new City();
        rosario.setName("Rosario");
        rosario.setCode("2000");
        cordobaStreet.setCity(rosario);
        cordobaStreet.setNumber("247");
        cordobaStreet.setStreet("Cordoba");
        request.setAddress(cordobaStreet);
        Email email = new Email();
        email.setEmail("tomas@msn.com");
        request.setEmail(email);

        request.setEstablishments(null);
    }
}
