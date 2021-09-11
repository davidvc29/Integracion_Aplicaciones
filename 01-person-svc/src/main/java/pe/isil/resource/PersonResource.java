package pe.isil.resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.isil.model.Person;

@RequestMapping("/api/persons")
@RestController
public class PersonResource {
    @GetMapping
    public Person getPerson(){
        return new Person("David","Villafane",27);
    }
}
