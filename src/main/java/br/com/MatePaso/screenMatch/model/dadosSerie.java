package br.com.MatePaso.screenMatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record dadosSerie(@JsonAlias ("Title") String titulo,
                         @JsonAlias ("totalSeasons") Integer totalTemporada,
                         @JsonAlias ("imdbRating")String avaliacao,
                         @JsonProperty ("imdbVotes") String votos) {

}
