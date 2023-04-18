package com.rest.rest.controller;

import jakarta.ws.rs.Path;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@Path("/bootcampers")
public class BootCampersController {

    @GetMapping("/bootcampers")
    public String getBootCampers() {
        return "BootCampers";
    }
}
