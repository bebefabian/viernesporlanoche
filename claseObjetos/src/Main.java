import dao.impl.PersonDAOImplementation;
import model.Person;
import service.PersonService;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //Creando persona
        PersonService personService = new PersonService(new PersonDAOImplementation());
        Person person = new Person();
        person.nombre = "Kaht";
        person.apellido = "pontier";
        person.edad = 21;
        person.cedula = "40222343504";
        personService.createPerson(person);

        //Obtener Persona
        String cedula = "40222343504";
        Person personaFromDB = personService.getByCedula(cedula);
        System.out.println("Persona from DB");
        System.out.println("persona nombre: " + personaFromDB.nombre);

        //Update persona
        personaFromDB.nombre = "Katherine";
        personService.updatePerson(personaFromDB);

        //Delete persona
        personService.delete(cedula);
    }
}
