package br.com.MatePaso.screenMatch.principal;

import br.com.MatePaso.screenMatch.Service.ConsumoAPI;
import br.com.MatePaso.screenMatch.Service.converterDados;
import br.com.MatePaso.screenMatch.model.dadosSerie;
import br.com.MatePaso.screenMatch.model.dadosTemporada;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI API = new ConsumoAPI();
    private converterDados conversor = new converterDados();

    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=ff6c69cd";

    public void exibirMenu(){
        System.out.println("Digite o nome da série para pesquisa");
        var nomeSerie = leitura.nextLine();
        var json = API.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        dadosSerie dados = conversor.obterDados(json, dadosSerie.class);

        System.out.println(dados);

        List<dadosTemporada> temporadas = new ArrayList<>();
		for(int i = 1; i<=dados.totalTemporada(); i++){
			json = API.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + "&season=" + i + API_KEY) ;
			dadosTemporada DadosTemp = conversor.obterDados(json, dadosTemporada.class);
			temporadas.add(DadosTemp);
		}
		temporadas.forEach(System.out::println);

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
        //olá

//        List<String> nomes = Arrays.asList("Maria", "Vitor", "Rafa", "Ana", "Gabriel", "Viny", "Isa");
//
//        nomes.stream()
//                .sorted()
//                .limit(3)
//                .filter(n -> n.startsWith("I"))
//                .map(n -> n.toUpperCase())
//                .forEach(System.out::println);
    }
}
