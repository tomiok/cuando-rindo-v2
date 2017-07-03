package com.cuandorindov2.resources.controllers.student;

import com.cuandorindov2.main.model.Student;
import com.cuandorindov2.main.resources.crud.domain.StudentController;
import com.cuandorindov2.resources.utils.JsonConverterUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by tomaslingotti on 7/1/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class StudentControllerTest {

    private static final String BASE_URL_GET_ALL = "/student/get-all";
    private MockMvc mvcMocked;
   private JsonConverterUtil<Student> converter;
   private Student student;

   private static final String BASE_URL_SAVE = "/student/save";
   private static final String CONTENT_TYPE = "application/json";

   private static final String PATH = "/Users/tomaslingotti/development/cuando-rindo-v2/src/test/resources/student/studentRequest.json";

   @Mock
   private StudentController studentController;

   @Before
   public void setUp() {
        mvcMocked = MockMvcBuilders.standaloneSetup(studentController).build();
        converter = new JsonConverterUtil<>();
        student = converter.convert(PATH, Student.class);
    }

   @Test
   public void shouldReturnBarRequest() throws Exception{
       mvcMocked.perform(post(BASE_URL_SAVE).contentType(CONTENT_TYPE))
               .andExpect(status().isBadRequest());
   }

   @Test
   public void shouldReturnIsCreated() throws Exception {
       mvcMocked.perform(post(BASE_URL_SAVE)
               .content(converter.toJsonString(student))
               .contentType(CONTENT_TYPE))
               .andExpect(status().isCreated());
   }

   @Test
   public void shouldReturnStatusOk() throws Exception {
       mvcMocked.perform(get(BASE_URL_GET_ALL)
       .contentType(CONTENT_TYPE)).andExpect(status().isOk());

   }

}
