/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persona;

import Department.Department;
import java.util.ArrayList;

public class StudentDirectory {

    private Department department; // Declared department as a field
    private ArrayList<StudentProfile> studentlist;

    public StudentDirectory() {
        //department = d;
        studentlist = new ArrayList<>();
    }

    public StudentProfile newStudentProfile(Person p) {
        StudentProfile sp = new StudentProfile(p);
        studentlist.add(sp);
        return sp;
    }

    public StudentProfile findStudent(String id) {
        for (StudentProfile sp : studentlist) {
            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; // Not found after going through the whole list
    }

    public ArrayList<StudentProfile> getStudentList() {
        return studentlist;
    }
    @Override
    public String toString() {
        return "StudentDirectory{" + "studentList=" + studentlist + '}';
    }
}
