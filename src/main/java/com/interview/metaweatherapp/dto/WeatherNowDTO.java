package com.interview.metaweatherapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class WeatherNowDTO {
    private String cityName;
    private float fahrenheit_temp;
    private float celsius_temp;  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate applicable_date;
    
    private String weather_state_name;

    public WeatherNowDTO() {
        this.cityName = "";
  		this.celsius_temp = 0;
		this.fahrenheit_temp = 0;
        this.applicable_date = LocalDate.parse("2000-01-01");
        this.weather_state_name = "";
	}

    public String getcityName() {
		return cityName;
	}

	public void setcityName(String cityName) {
		this.cityName = cityName;
    }
    
    public float getcelsius_temp() {
		return celsius_temp;
	}

    public void setcelsius_temp(float temp) {
        this.celsius_temp = temp;
        float f = ((temp * 9) / 5) + 32;
        setfahrenheit_temp(f);  
    }

    public float getfahrenheit_temp() {
		return fahrenheit_temp;
    }

    public void setfahrenheit_temp(float temp) {
        this.fahrenheit_temp = temp;  
    }

    public LocalDate getapplicable_date() {
		return applicable_date;
	}

	public void setapplicable_date(LocalDate date) {
		this.applicable_date = date;
    }
    
    public String getweather_state_name() {
		return weather_state_name;
	}

	public void setweather_state_name(String weatherState) {
		this.weather_state_name = weatherState;
	}
}