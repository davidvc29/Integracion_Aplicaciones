package pe.isil.loader;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pe.isil.model.Person;
import pe.isil.repository.PersonRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Configuration
public class PersonLoader implements CommandLineRunner {
    private final PersonRepository personRepository;

    public PersonLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void run(String... args) throws Exception{
        List<Person> personList = new ArrayList<>(
                Arrays.asList(
                        new Person(1,"David","Villafane",26),
                        new Person(2,"Yoshi","Villafane",30)
                )
        );

        personRepository.saveAll(personList);
        log.info("Se cargaron los datos");
    }
}
