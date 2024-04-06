package com.bibliotheque;

import com.bibliotheque.model.Document;
import com.bibliotheque.repository.CategoryRepository;
import com.bibliotheque.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class BibliothequeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BibliothequeApplication.class, args);
	}

	@Autowired
	private DocumentRepository documentRepository;
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
//		Document document = new Document();
//		document.setNom("monjoh");
//		document.setCategorie("history");
//		document.setTitre("la chevre de ma mere");
//		document.setQuantite(25);
//		document.setDate_depot(new Date(2004, Calendar.JULY,27));
//		documentRepository.save(document);


	}
}
