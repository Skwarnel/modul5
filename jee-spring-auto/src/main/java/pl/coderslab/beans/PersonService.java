package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonService {

    private PersonRepository personRepository;

    @Autowired //nowszy niż, 4 coś tam dla jednego komponentu ta adnotacja nie jest potrzebna
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonRepository getPersonRepo() {
        return personRepository;
    }
}
