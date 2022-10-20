package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository.FlorRepository;


@SpringBootApplication
public class Application  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private FlorRepository lista;
	
	@Override
	public void run(String... args) throws Exception {
//		Flor flor = new Flor(1,"Margarita", "Spain");
//		lista.save(flor);
	}

}
