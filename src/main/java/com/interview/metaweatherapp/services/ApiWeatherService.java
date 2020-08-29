package com.interview.metaweatherapp.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

import com.interview.metaweatherapp.dto.CityWeatherDTO;
import com.interview.metaweatherapp.dto.ConsolidatedWeatherDTO;
import com.interview.metaweatherapp.dto.WeatherNowDTO;
import com.interview.metaweatherapp.dto.WoeidMapDTO;

@Service
public class ApiWeatherService {
    private final String URI1 = "https://www.metaweather.com/api/location/search/";
    private final String URI2 = "https://www.metaweather.com/api/location/";

    private final RestTemplate restTemplate;

    public ApiWeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public ResponseEntity<?> getWeatherByCity(String city) {
        WeatherNowDTO result = new WeatherNowDTO();
        try {
            WoeidMapDTO[] woeids;
            ResponseEntity<WoeidMapDTO[]> response = this.restTemplate.getForEntity(this.url1(city), WoeidMapDTO[].class);

            woeids = response.getBody();
            
            if(woeids.length > 0){
                Integer first = woeids[0].getWoeid();
                CityWeatherDTO cityWeather = this.restTemplate.getForObject(this.url2(first), CityWeatherDTO.class);
                List<ConsolidatedWeatherDTO> consolidatedWeatherWeekly = cityWeather.getconsolidated_weather();
                // printWeatherWeekly(consolidatedWeatherWeekly);
                result = getWeatherNow(consolidatedWeatherWeekly, cityWeather.getTitle());
            }

        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(new Json(e.getResponseBodyAsString()), e.getStatusCode());
        }
    
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private  WeatherNowDTO getWeatherNow(List<ConsolidatedWeatherDTO> list, String city) {
        WeatherNowDTO result = new WeatherNowDTO();
        if(list.size() > 0 ){
            ConsolidatedWeatherDTO c = list.get(0);
            result.setcityName(city);
            result.setcelsius_temp(c.getthe_temp());
            result.setapplicable_date(c.getapplicable_date());
            result.setweather_state_name(c.getweather_state_name());
        }

        return result;
    }

    private void printWeatherWeekly(List<ConsolidatedWeatherDTO> list) {
        for (ConsolidatedWeatherDTO item : list) {
            System.out.println(item.getthe_temp());
            System.out.println(item.getapplicable_date());
        }
    }

    private String url1(String city) {
        String apiQuery = String.format(URI1.concat("?query=%s"), city);
        // System.out.println(apiQuery);
        return apiQuery;
    }

    private String url2(Integer woeid) {
        String apiQuery = String.format(URI2.concat("%s/"), woeid);
        // System.out.println(apiQuery);
        return apiQuery;
    }
}
