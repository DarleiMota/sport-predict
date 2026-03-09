package com.darlei.sportpredict.external.football.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TeamDTO {
    
    private Long id;
    
    private String name;
    
    private String shortName;
    
    private String tla;
    
    private String crest;
    
    private String address;
    
    private String website;
    
    private String email;
    
    private String phone;
    
    private Integer founded;
    
    private String clubColors;
    
    private String venue;
    
    @JsonProperty("lastUpdated")
    private String lastUpdated;
}
