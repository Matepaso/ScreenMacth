package br.com.MatePaso.screenMatch;


import br.com.MatePaso.screenMatch.principal.principal;
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
		principal Principal = new principal();
		Principal.exibirMenu();

	}
}
