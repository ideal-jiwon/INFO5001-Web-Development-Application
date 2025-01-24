/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package College;

import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import Department.Department;
import Persona.Faculty.FacultyDirectory;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author kal bugrara
 */
public class College {
    
    String collegeName;
    private List<Department> departments;
    PersonDirectory personDirectory;
    FacultyDirectory facultyDirectory;
    StudentDirectory studentDirectory;
    
    public College(){
        departments = new ArrayList<>();
    }

    public College(String collegeName){
        this.collegeName = collegeName;
        departments = new ArrayList<>();
        personDirectory = new PersonDirectory();
        facultyDirectory = new FacultyDirectory(null);
        studentDirectory = new StudentDirectory();
    }
    
    public List<Department> getDepartments() {
        return departments;
    }
    public Department addDepartment(String dn){
        Department department = new Department(dn);//dn for department name
        departments.add(department);
        return department;
    }
    public PersonDirectory getPersonDirectory(){
        return personDirectory;
    }
    public FacultyDirectory getFacultyDirectory(){
        return facultyDirectory;
    }
    public StudentDirectory getStudentDirectory(){
        return studentDirectory;
    }
    public CourseSchedule createCollegeCourseSchedule(String semester) {
    CourseSchedule collegeSchedule = new CourseSchedule(semester, null); // Unified schedule

    for (Department department : getDepartments()) { // Get all departments in the college
        CourseSchedule departmentSchedule = department.getCourseSchedule(semester);

        if (departmentSchedule != null) {
            // Merge courses from department schedule into college schedule
            for (CourseOffer courseOffer : departmentSchedule.getSchedule()) {
                if (collegeSchedule.getCourseOfferByNumber(courseOffer.getCourseNumber()) == null) {
                    collegeSchedule.newCourseOffer(courseOffer.getCourseNumber());
                }
            }
        }
    }

    return collegeSchedule; // Return the consolidated schedule
}

}
