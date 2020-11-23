package be.heh.epm;

import be.heh.epm.domain.*;
import be.heh.epm.application.ports.in.*;
import be.heh.epm.application.ports.out.*;
import be.heh.epm.application.services.*;

import static org.assertj.core.api.Assertions.*;

import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.springframework.http.HttpHeaders;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestAPI {

	@Autowired
    private MockMvc mvc;
    
    @Test
    public void createEmployeeAPI() throws Exception 
    {
        EmployeeSalariedValidating postEmployee = new EmployeeSalariedValidating(1, "toto", "rue de Mons", "toto@gmail.com",1500);
        mvc.perform( post("/employees/salaried")
            .content(asJsonString(postEmployee))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .andExpect(status().isCreated())
            .andExpect(header().string(HttpHeaders.LOCATION,"http://localhost:8080/employees/salaried/1")));
    }     
}