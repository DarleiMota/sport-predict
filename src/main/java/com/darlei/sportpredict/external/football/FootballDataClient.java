package com.darlei.sportpredict.external.football;

import com.darlei.sportpredict.external.football.dto.TeamDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class FootballDataClient {

    @Autowired
    private WebClient webClient;

    /**
     Busca todos os times de uma competicao
     Exemplo: /competitions/PL/teams
     */
    public Mono<List<TeamDTO>> getTeamsByCompetition(String competitionCode) {
        log.info("Buscando times da competicao: {}", competitionCode);
        
        return webClient.get()
                .uri("/competitions/{code}/teams", competitionCode)
                .retrieve()
                .bodyToMono(TeamsResponse.class)
                .map(TeamsResponse::getTeams)
                .doOnSuccess(teams -> log.info("Encontrados {} times", teams.size()))
                .doOnError(error -> log.error("Erro ao buscar times: {}", error.getMessage()));
    }

    /**
     * Busca time especifico por ID
     */
    public Mono<TeamDTO> getTeamById(Long teamId) {
        log.info("Buscando time ID: {}", teamId);
        
        return webClient.get()
                .uri("/teams/{id}", teamId)
                .retrieve()
                .bodyToMono(TeamDTO.class)
                .doOnSuccess(team -> log.info("Time encontrado: {}", team.getName()))
                .doOnError(error -> log.error("Erro ao buscar time {}: {}", teamId, error.getMessage()));
    }

    // Classe auxiliar para mapear resposta da API
    private static class TeamsResponse {
        private List<TeamDTO> teams;

        public List<TeamDTO> getTeams() {
            return teams;
        }

        public void setTeams(List<TeamDTO> teams) {
            this.teams = teams;
        }
    }
}
