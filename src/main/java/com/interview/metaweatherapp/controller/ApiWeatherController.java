package com.interview.metaweatherapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import com.interview.metaweatherapp.services.ApiWeatherService;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("weather")
public class ApiWeatherController {
    @Autowired
    private ApiWeatherService weatherService;
    
    @GetMapping(value = "/temperature", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> weatherForecastAverage(@RequestParam(required = true) final String city) {
        return weatherService.getWeatherByCity(city);
    }
}