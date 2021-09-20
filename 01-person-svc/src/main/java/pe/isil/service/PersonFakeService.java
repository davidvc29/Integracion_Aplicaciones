package pe.isil.service;


import org.springframework.stereotype.Service;
import pe.isil.model.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonFakeService implements PersonService {

    AtomicInteger id = new AtomicInteger(10);

    List<Person> personList = new ArrayList<>(
            Arrays.asList(
                    new Person(1,"David","Villafane",26),
                    new Person(2,"Yoshi","Villafane",30)
            )
    );

    public List<Person> getAll(){
        return personList;
    }

    public void create(Person person){
        person.setId(id.getAndIncrement());
        personList.add(person);
    }

    public void delete(Person person){
        personList.remove(person);
    }

    public void update(Person person){
        Person currentPerson = findById(person.getId());

        if (currentPerson != null){
            int index = personList.indexOf(currentPerson);
            personList.set(index,person);
        }
    }

    public Person findById(Integer id) {
        return personList.stream()
                .filter(p -> id.equals(p.getId()))
                .findFirst()
                .orElse(null)
                ;

    }


}
