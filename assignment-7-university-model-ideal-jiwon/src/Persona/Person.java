/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

/**
 *
 * @author kal bugrara
 */
public class Person {

    String personName;
    String id;
    
    public Person (String pn, String id){
        this.personName = pn;
        this.id = id;
    }
    public String getPersonName() {
        return personName;
    }

    public String getPersonId(){
        return id;
    }

        public boolean isMatch(String id){
        if(getPersonId().equals(id)) return true;
        return false;
    }
    @Override
    public String toString() {
    return "Person[ID=" + id + ", Name=" + personName + "]";
}
  
}
