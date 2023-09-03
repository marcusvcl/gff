package br.com.fiap.gff;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fiap.gff.application.web.config.MongoMigration;
import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class GffApplication implements ApplicationRunner {

	private final MongoMigration migration;

	public static void main(String[] args) {
		SpringApplication.run(GffApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		migration.Start();
	}

}
