package com.interview.metaweatherapp.dto;

import java.util.List;

public class CityWeatherDTO {
	
	private Integer woeid;
	
	private String timezone;

	private String location_type;

	private String title;

	private String latt_long;


    private List<ConsolidatedWeatherDTO> consolidated_weather;

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getlatt_long(){
		return latt_long;
	}

	public void setlatt_long(String ll) {
		this.latt_long = ll;
	}
	
	public Integer getWoeid() {
		return woeid;
	}

	public void setWoeid(Integer woeid) {
		this.woeid = woeid;
	}

	public void setlocation_type(String location_type) {
		this.location_type = location_type;
	}
	
    public String getlocation_type() {
		return location_type;
	}

	public void settimezone(String timezone) {
		this.timezone = timezone;
	}
	
	public String gettimezone() {
		return timezone;
	}
    
    public List<ConsolidatedWeatherDTO> getconsolidated_weather() {
		return consolidated_weather;
	}

	public void setconsolidated_weather(List<ConsolidatedWeatherDTO> cwl) {
		this.consolidated_weather = cwl;
	}
}