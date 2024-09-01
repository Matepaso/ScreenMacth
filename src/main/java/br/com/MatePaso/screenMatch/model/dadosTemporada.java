package br.com.MatePaso.screenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record dadosTemporada(@JsonAlias("Season") Integer numero,
                             @JsonAlias("Episodes") List<dadosEpisodio> episodios) {
}
