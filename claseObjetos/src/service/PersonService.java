package service;

import dao.PersonDAO;
import model.Person;

public class PersonService {

    private PersonDAO personDAO;
    public void createPerson(Person person){
        personDAO.create(person);
    }

    public PersonService(PersonDAO personDAO){
        this.personDAO = personDAO;
    }

    public Person getByCedula(String cedula){
        return personDAO.getByCedula(cedula);
    }

    public void updatePerson(Person person){
        personDAO.update(person);
    }

    public void delete(String cedula){
        personDAO.delete(cedula);
    }
}
