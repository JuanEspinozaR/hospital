package com.je.hospital;

import com.je.hospital.entity.Doctor;
import com.je.hospital.repository.DoctorRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

import java.util.List;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DoctorControllerTest {
    @LocalServerPort
    private Integer port;

    static MySQLContainer<?> mysqlDb = new MySQLContainer<>(
            "mysql"
    );

    @BeforeAll
    static void beforeAll() {
        mysqlDb.start();
        System.out.println("Mysql db container up");
    }

    @AfterAll
    static void afterAll() {
        mysqlDb.stop();
        System.out.println("Mysql db container stopped");
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysqlDb::getJdbcUrl);
        registry.add("spring.datasource.username", mysqlDb::getUsername);
        registry.add("spring.datasource.password", mysqlDb::getPassword);
    }

    @Autowired
    DoctorRepository doctorRepository;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost:" + port;
        //doctorRepository.deleteAll();
    }

    @Test
    void shouldGetAllCustomers() {
        List<Doctor> doctors = List.of(
                new Doctor(null, "Juan", "Espinoza", "Fco. I. Madero", "Nice doctor", 124.21),
                new Doctor(null, "Miguel", "Landeros", "Torreón, Coahuila", "Helpfuly and kindly", 87.112)
        );

        doctorRepository.saveAll(doctors);

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("hospital/v1/api/doctor")
                .then()
                .statusCode(200)
                .body(".", hasSize(2));
    }
}
