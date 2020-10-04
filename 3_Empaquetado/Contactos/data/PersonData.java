package data;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import entities.Person;

public class PersonData {
    List<Person> lis = new ArrayList<Person>();
    int id=0;
    Scanner sdf = new Scanner(System.in);

    public void create(Person person){
        id = id + 1;
        System.out.println("ID:" + id);
        person.setId(id);
        lis.add(person);
    }
    public List<Person> list() {
        return lis;

    }
   
    public Person getid(int id) {
        Iterator<Person> iterator = lis.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void update(int id, String namep, String sexp, int agep) {
        for(Person person : lis){
            if(person.getId() == id) {
                int _list = lis.indexOf(person);
                person.setName(namep);
                person.setSex(sexp);
                person.setAge(agep);
                lis.set(_list, person);
            }
        }
    }

    public void delete(int id) {
        String r = new String();
        Iterator<Person> personIterator = lis.iterator();
        while(personIterator.hasNext()){
            Person personlis = personIterator.next();
            if (personlis.getId() == id){
                personIterator.remove();
            }
        }
    }

}
