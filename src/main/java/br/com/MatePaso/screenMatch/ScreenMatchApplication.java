package br.com.MatePaso.screenMatch;

import br.com.MatePaso.screenMatch.Service.ConsumoAPI;
import br.com.MatePaso.screenMatch.Service.converterDados;
import br.com.MatePaso.screenMatch.model.dadosSerie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenMatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		ConsumoAPI API = new ConsumoAPI();

		var json = API.obterDados("https://www.omdbapi.com/?t=supernatural&apikey=ff6c69cd");

		System.out.println(json);

		converterDados conversor = new converterDados();

		dadosSerie dados = conversor.obterDados(json, dadosSerie.class);

		System.out.println(dados);
	}
}
