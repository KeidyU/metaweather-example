package com.interview.metaweatherapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ConsolidatedWeatherDTO {
    private String weather_state_name;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate applicable_date;

	private float the_temp;
	
	public float getthe_temp() {
		return the_temp;
	}

	public void setthe_temp(float temp) {
		this.the_temp = temp;
    }
    
    public String getweather_state_name() {
		return weather_state_name;
	}

	public void setweather_state_name(String weatherState) {
		this.weather_state_name = weatherState;
	}

	public LocalDate getapplicable_date() {
		return applicable_date;
	}

	public void setapplicable_date(LocalDate date) {
		this.applicable_date = date;
	}
}