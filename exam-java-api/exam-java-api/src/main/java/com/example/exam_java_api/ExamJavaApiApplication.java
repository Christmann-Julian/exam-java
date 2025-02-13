package com.example.exam_java_api;

import com.example.exam_java_api.model.Quote;
import com.example.exam_java_api.repository.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExamJavaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamJavaApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(QuoteRepository repository) {
		return args -> {
			if (repository.count() == 0) {
				repository.save(new Quote("'Le succès, c'est d'aller d'échec en échec sans perdre son enthousiasme.' Winston Churchill"));
				repository.save(new Quote("'La seule limite à notre épanouissement de demain, ce sont nos doutes d’aujourd’hui.' Franklin Delano Roosevelt"));
				repository.save(new Quote("'Croyez en vous et en tout ce que vous êtes.' Christian Larson"));
				repository.save(new Quote("'Il faut toujours viser la lune car même en cas d’échec on atterrit dans les étoiles.' Oscar Wilde"));
				repository.save(new Quote("'La vie, c'est comme une bicyclette, il faut avancer pour ne pas perdre l'équilibre.' Albert Einstein"));
				repository.save(new Quote("'Fais de ta vie un rêve et d’un rêve une réalité.' Antoine de Saint-Exupéry"));
				repository.save(new Quote("'Ce qui ne tue pas rend plus fort.' Nietzsche"));
				repository.save(new Quote("'J’ai appris que le courage n’est pas l’absence de peur, mais la capacité de la vaincre.' Nelson Mandela"));
				repository.save(new Quote("'Je préfère l'avenir au passé, car c'est là que j'ai décidé de vivre le restant de mes jours.' Victor Hugo"));
				repository.save(new Quote("'Votre temps est limité, ne le gâchez pas en menant une existence qui n'est pas la vôtre.' Steve Jobs"));
			}else{
				System.out.println("La base de données contient déjà des citations");
			}
		};
	}
}
