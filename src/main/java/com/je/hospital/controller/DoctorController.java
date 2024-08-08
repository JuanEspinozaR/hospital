package com.je.hospital.controller;

import com.je.hospital.entity.Doctor;
import com.je.hospital.service.impl.DoctorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/api/doctor")
public class DoctorController {
    @Autowired
    DoctorServiceImpl doctorServiceImpl;

    @Operation(summary = "Delete doctor", description = "Delete doctor information by id")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Doctor info has been deleted",
                            content = @Content
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Doctor not found",
                            content = @Content
                    ),
                    @ApiResponse(responseCode = "500",
                            description = "Something went wrong",
                            content = @Content)
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity delete(Long id) {
        doctorServiceImpl.delete(id);
        return ResponseEntity.ok().build();
    }

    @Tag(name = "getInfo", description = "Defined methods to get info from database")
    @Operation(
            summary = "Get a doctor by id",
            description = "This method provide information about an specific doctor")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Doctor found in the database, response the doctor info",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = Doctor.class))}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Doctor not found",
                            content = {@Content}
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findById(@Parameter(description = "Doctor id search") @PathVariable long id) {
        Doctor doctor = doctorServiceImpl.findById(id);
        return ResponseEntity.ok(doctor);
    }

    @Tag(name = "getInfo", description = "Defined methods to get info from database")
    @Operation(summary = "Get all doctors info",
            description = "Get all doctors info from database without a filter")
    @GetMapping
    public ResponseEntity<List<Doctor>> findAll() {
        List<Doctor> doctors = doctorServiceImpl.search();
        return ResponseEntity.ok(doctors);
    }

    @Operation(summary = "Save doctor on database",
            description = "Save doctor on database and return the doctor info with the id generated")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Doctor was created",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = Doctor.class))}
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Something went wrong",
                            content = {@Content}
                    )
            }
    )
    @PostMapping
    public ResponseEntity<Doctor> save(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorServiceImpl.insert(doctor));
    }

    @Operation(summary = "Modify doctor info", description = "This method allow to modify Doctor info base on the id ")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Doctor info was updated",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = Doctor.class))}
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Doctor not found",
                            content = {@Content}
                    )
            }
    )
    @PutMapping
    public ResponseEntity<Doctor> update(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorServiceImpl.update(doctor));
    }
}
