/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class PersonDirectory {
    
    ArrayList<Person> personlist ;
      
    public PersonDirectory (){
        
        personlist = new ArrayList<>();

    }
    public Person addPerson(String pn, String id) {

        Person pd = new Person(pn, id);
        personlist.add(pd);
        return pd;
    }
    public ArrayList<Person> getPersonList() {
        return personlist;
    }

    public Person findPerson(String id) {

        for (Person p : personlist) {

            if (p.isMatch(id)) {
                return p;
            }
        }
            return null; //not found after going through the whole list
         }
    
}
