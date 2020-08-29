# metaweather-example

This is SprinBoot project that response the temperature in 
Celsius and Farenheit of a city given the City's name.

After running the springboot project you can get the response
Using the following url:

<http://localhost:8080/weather/temperature?city=${cityName}>

Additional, it is returning the name of the weather state and
the applicable date for this estimated weather.

The weather is getting from metaWeather API: 

<https://www.metaweather.com/api/location/search/?query=${city}>

and for a specific woeid:

<https://www.metaweather.com/api/location/${woeid}/>


