package com.cuandorindov2.mappers;

import com.cuandorindov2.main.mapper.toDomain.StudentMapper;
import com.cuandorindov2.main.model.Address;
import com.cuandorindov2.main.model.City;
import com.cuandorindov2.main.model.Email;
import com.cuandorindov2.main.model.Establishment;
import com.cuandorindov2.main.model.Student;
import com.cuandorindov2.main.resources.requests.StudentRequest;
import com.cuandorindov2.main.validator.ApiValidator;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ValidationException;
import java.util.Collection;

/**
 * Created by tomas.lingotti on 10/06/17.
 */
public class StudentMapperTest {

    private StudentMapper mapper;
    private ApiValidator apiValidator;
    private static final String EMAIL = "tomas@msn.com";

    @Before
    public void setUp() {
        mapper = new StudentMapper();
        apiValidator = new ApiValidator();
    }

    @Test
    public void shouldConvertRequestToDomainObject() {
        final StudentRequest request = createStudentRequest("Tomas",
                "Francisco", "Lingotti", "Rosario", "2000",
                "247", "Cordoba", EMAIL, null);

        Student st = mapper.map(request);
        Assert.assertThat(st.getEmail().getEmail(), Is.is(EMAIL));
    }

    @Test(expected = ValidationException.class)
    public void testNameIsNull() {
        final StudentRequest request = createStudentRequest(null,
                "Francisco", "Lingotti", "Rosario", "2000",
                "247", "Cordoba", "toamslingotti@msn.com", null);
        apiValidator.validate(request);
    }

    private StudentRequest createStudentRequest(final String name, final String midName,
                                                final String lastName, final String cityName, final String zipCode,
                                                final String addressNumber, final String street, final String emailAddress,
                                                final Collection<Establishment> establishments) {

        final StudentRequest request = new StudentRequest();
        request.setName(name);
        request.setMidName(midName);
        request.setLastName(lastName);
        final Address cordobaStreet = new Address();
        final City rosario = new City();
        rosario.setName(cityName);
        rosario.setCode(zipCode);
        cordobaStreet.setCity(rosario);
        cordobaStreet.setNumber(addressNumber);
        cordobaStreet.setStreet(street);
        request.setAddress(cordobaStreet);
        Email email = new Email();
        email.setEmail(emailAddress);
        request.setEmail(email);
        request.setEstablishments(establishments);
        return request;
    }
}
