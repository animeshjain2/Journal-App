package com.example.journalApp.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Current {
    
        public int temperature;

        @JsonProperty("weather_descriptions")
        public ArrayList<String> weather_descriptions;
        public int feelslike;

    }
