package edu.guc.library.web.rest;

import edu.guc.library.domain.LibraryManager;
import edu.guc.library.repository.LibraryManagerRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private final LibraryManagerRepository libraryManagerRepository;

    public DbSeeder(LibraryManagerRepository libraryManagerRepository) {
        this.libraryManagerRepository = libraryManagerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

            LibraryManager first= new LibraryManager("Salma","Sleem","salma-sleem","abcd",5,"Mohamed");
            libraryManagerRepository.save(first);

    }

}
