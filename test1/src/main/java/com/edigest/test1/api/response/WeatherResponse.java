package com.edigest.test1.api.response;

//import org.apache.catalina.connector.Request;

//import javax.xml.stream.Location;
import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Getter;
//import lombok.Setter;
import org.apache.catalina.connector.Request;

import javax.xml.stream.Location;
import java.util.List;

//@Getter
//@Setter
public class WeatherResponse {

    private Current current;

    public Current getCurrent() {
        return current;
    }
    public class Current{

        private int temperature;
        @JsonProperty("weather_description")
        private List<String> weatherDescription;

        private int feelslike;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public List<String> getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(List<String> weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public int getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(int feelslike) {
        this.feelslike = feelslike;
    }
}


}


