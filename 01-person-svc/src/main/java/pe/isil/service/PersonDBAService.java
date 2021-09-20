package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Person;
import pe.isil.repository.PersonRepository;

import java.util.List;

@Service
public class PersonDBAService implements PersonService{

    private final PersonRepository personRepository;

    public PersonDBAService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public void create(Person person) {
        personRepository.save(person);
    }

    @Override
    public void delete(Person person) {
        personRepository.delete(person);
    }

    @Override
    public void update(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person findById(Integer id) {
        return personRepository
                .findById(id)
                .orElseGet(null);

    }
}
