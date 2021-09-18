package pe.isil.resource;



import org.springframework.web.bind.annotation.*;
import pe.isil.model.Person;
import pe.isil.service.PersonService;



import java.util.List;

@RequestMapping("/api/persons")
@RestController
public class PersonResource {


    private final PersonService personService;

    public PersonResource(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPerson(){
        return personService.getAll();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person){
            personService.create(person);
            return person;
    }

    @PutMapping("/{id}")
    public Person updatePerson(@RequestBody Person person,@PathVariable Integer id){
            Person currentPerson = personService.findById(id);
            if(currentPerson != null){
                person.setId(id);
                personService.update(person);
            }

            return person;
    }


    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Integer id){
        Person currentPerson = personService.findById(id);
        if (currentPerson != null){
            personService.delete(currentPerson);
        }
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Integer id){
        Person currentPerson = personService.findById(id);
        return  currentPerson;
    }

}
