package dao;

import model.Person;

public interface PersonDAO {
     void create(Person Person);
     Person getByCedula(String cedula);

     void update(Person person);

     void delete(String cedula);
}
