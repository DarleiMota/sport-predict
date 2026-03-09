package com.darlei.sportpredict.controller;

import com.darlei.sportpredict.external.football.FootballDataClient;
import com.darlei.sportpredict.external.football.dto.TeamDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@Slf4j
public class TestController {

    @Autowired
    private FootballDataClient footballDataClient;

    @GetMapping("/teams/{competition}")
    public Mono<List<TeamDTO>> getTeams(@PathVariable String competition) {
        log.info("Requisicao GET /api/test/teams/{}", competition);
        
        return footballDataClient.getTeamsByCompetition(competition);
    }

    @GetMapping("/team/{id}")
    public Mono<TeamDTO> getTeam(@PathVariable Long id) {
        log.info("Requisicao GET /api/test/team/{}", id);
        
        return footballDataClient.getTeamById(id);
    }
}
