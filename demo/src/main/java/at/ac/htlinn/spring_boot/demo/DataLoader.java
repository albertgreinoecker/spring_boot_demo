package at.ac.htlinn.spring_boot.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final PersonRepository repo;

    public DataLoader(PersonRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {

        // optional: Datenbank vorher leeren
        repo.deleteAll();

        repo.save(new Person("Alice", 30));
        repo.save(new Person("Bob", 25));
        repo.save(new Person("Charlie", 40));
    }
}
