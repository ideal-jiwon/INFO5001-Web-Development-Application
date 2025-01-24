/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import CourseSchedule.CourseLoad;
import CourseSchedule.SeatAssignment;
import Persona.EmploymentHistory.EmploymentHistroy;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class StudentProfile {

    Person person;
    Transcript transcript;
    EmploymentHistroy employmenthistory;

    public StudentProfile(Person p) {
        this.person = p; //initialization 
        transcript = new Transcript(this);
        employmenthistory = new EmploymentHistroy();
    }
    public Person getPerson() {
        return person;
    }
    public String getPersonName() {
        return person.personName;
    }
    public String getPersonId() {
        return person.getPersonId();
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String semester) {
        return transcript.newCourseLoad(semester);
    }

    public ArrayList<SeatAssignment> getCourseList() {

        return transcript.getCourseList();

    }
    @Override
    public String toString() {
        return "StudentProfile[Person=" + person.toString() + "]";
    }
}
