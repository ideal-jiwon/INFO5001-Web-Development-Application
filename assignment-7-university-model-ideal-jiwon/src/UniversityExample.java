/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import College.College;
import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import CourseSchedule.SeatAssignment;
import Department.Department;
import Persona.Faculty.FacultyDirectory;
import Persona.Person;
import Persona.PersonDirectory;
import Persona.StudentDirectory;
import Persona.StudentProfile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UniversityExample {

    public static void main(String[] args) {
        College neuCollege = new College("Northeastern University");
        if (neuCollege != null) {
            System.out.println("Debug: College object created successfully.");
        } else {
            System.out.println("Error: College object creation failed.");
        }

        Department msisDepartment = neuCollege.addDepartment("MSIS");
        Department msdaDepartment = neuCollege.addDepartment("MSDA");
        
        if (msisDepartment != null) {
            System.out.println("Debug: MSIS Department created successfully.");
        } else {
            System.out.println("Error: MSIS Department creation failed.");
        }

        if (msdaDepartment != null) {
            System.out.println("Debug: MSDA Department created successfully.");
        } else {
            System.out.println("Error: MSDA Department creation failed.");
        }

        // 3. Add courses to each department
        CourseCatalog coursecatalog1 = msisDepartment.getCourseCatalog();
        coursecatalog1.newCourse("INFO6250", "Pipling", 4);
        coursecatalog1.newCourse("INFO7150", "API", 4);
        coursecatalog1.newCourse("CSYE6205", "C#", 4);
        coursecatalog1.newCourse("CSYE6202", "C++", 4);
        coursecatalog1.newCourse("DAMG6500", "Data Management", 4);

        System.out.println("Debug: MSIS Department Courses:");
        System.out.println(coursecatalog1.getCourseList());

        CourseCatalog coursecatalog2 = msdaDepartment.getCourseCatalog();
        coursecatalog2.newCourse("CSYE6011", "Software Application", 4);
        coursecatalog2.newCourse("DAMG1234", "Data Mining & Analytics", 4);
        coursecatalog2.newCourse("DAMG126", "Big Data Warehousing", 4);
        coursecatalog2.newCourse("DAMG879", "Python Fundamentals", 4);
        coursecatalog2.newCourse("DAMG9000", "R-Analytics", 4);

        System.out.println("Debug: MSDA Department Courses:");
        System.out.println(coursecatalog2.getCourseList());



        // 4. Add faculty to PersonDirectory and FacultyDirectory
        PersonDirectory personDirectory = neuCollege.getPersonDirectory();
        FacultyDirectory facultyDirectory = neuCollege.getFacultyDirectory();

        Person person1 = personDirectory.addPerson("Stellar", "1");
        Person person2 = personDirectory.addPerson("Emma", "2");
        Person person3 = personDirectory.addPerson("Chrishell", "3");
        Person person4 = personDirectory.addPerson("Maya", "4");
        Person person5 = personDirectory.addPerson("Mary", "5");

        // Debug: Print all persons in the person directory
        System.out.println("Debug: All Persons in Person Directory:");
        System.out.println(personDirectory.getPersonList());

        facultyDirectory.newFacultyProfile(person1);
        facultyDirectory.newFacultyProfile(person2);
        facultyDirectory.newFacultyProfile(person3);
        facultyDirectory.newFacultyProfile(person4);
        facultyDirectory.newFacultyProfile(person5);

        // Debug: Print all faculty profiles
        System.out.println("Debug: All Faculty Profiles:");
        System.out.println(facultyDirectory.getFacultyList());
    
        // 5. Add 20 students to the shared StudentDirectory in neuCollege
        //StudentDirectory msDaDirectory = new StudentDirectory(msdaDepartment);
        //StudentDirectory msIsDirectory = new StudentDirectory(msisDepartment);
        StudentDirectory studentDirectory = neuCollege.getStudentDirectory();
        
        studentDirectory.newStudentProfile(personDirectory.addPerson("Aria", "student1"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Boa", "student2"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Layla", "student3"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Eddy", "student4"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Maria", "student5"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Loya", "student6"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Watt", "student7"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Nelson", "student8"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Marie", "student9"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Zian", "student10"));

        studentDirectory.newStudentProfile(personDirectory.addPerson("Mazin", "MSDA1"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Sam", "MSDA2"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Alex", "MSDA3"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Cathy", "MSDA4"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Robert", "MSDA5"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Melinda", "MSDA6"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Melisa", "MSDA7"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Debbie", "MSDA8"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Peter", "MSDA9"));
        studentDirectory.newStudentProfile(personDirectory.addPerson("Archil", "MSDA10"));
        
        // Debug: Print all student profiles
        System.out.println("Debug: All Student Profiles in Student Directory:");
        System.out.println(studentDirectory.getStudentList());
        
         // 6. Create course schedules for Fall 2024 for each department
         // Merge coursecatalog2 into coursecatalog1
        // Create a list of catalogs
        CourseCatalog mergedCatalog = new CourseCatalog(null);
        mergedCatalog.mergeCatalog(msisDepartment.getCourseCatalog());
        mergedCatalog.mergeCatalog(msdaDepartment.getCourseCatalog());
        CourseSchedule fall2024_Schedule = new CourseSchedule("Fall2024",mergedCatalog);
        for (Course course : mergedCatalog.getCourseList()) {
            fall2024_Schedule.newCourseOffer(course.getCOurseNumber());
}
        // Debug: Print the schedule
        System.out.println("Debug: Course Schedule for Fall 2024:");
        System.out.println(fall2024_Schedule);

        // 7. Generate course offerings for each course in both departments

        // Generate course offerings for all courses in the merged catalog
        List<CourseOffer> courseOffers = new ArrayList<>();
        System.out.println("Generating course offerings for Fall 2024...");
        for (Course course : mergedCatalog.getCourseList()) {
            System.out.println("Processing course: " + course.getCOurseNumber() + " - " + course.getCOursename());
            CourseOffer courseOffer = fall2024_Schedule.newCourseOffer(course.getCOurseNumber());
            if (courseOffer != null) { // Ensure course offering was created successfully
                courseOffer.generatSeats(15); // Assign 15 seats to each course offering
                courseOffers.add(courseOffer);
                System.out.println("Generated course offering with 15 seats for: " + course.getCOurseNumber());
            } else {
                System.out.println("Error: Could not create course offering for: " + course.getCOurseNumber());
    }
}

        // Debug: Print all course offerings
        System.out.println("Debug: All course offerings for Fall 2024:");
        for (CourseOffer courseOffer : courseOffers) {
                System.out.println(courseOffer);
}      

        // 8. Assign faculty to each course offering
        fall2024_Schedule.getCourseOfferByNumber("INFO6250").AssignAsTeacher(facultyDirectory.findTeachingFaculty("Stellar"));
        fall2024_Schedule.getCourseOfferByNumber("INFO7150").AssignAsTeacher(facultyDirectory.findTeachingFaculty("Emma"));
        fall2024_Schedule.getCourseOfferByNumber("CSYE6205").AssignAsTeacher(facultyDirectory.findTeachingFaculty("Chrishell"));
        fall2024_Schedule.getCourseOfferByNumber("CSYE6202").AssignAsTeacher(facultyDirectory.findTeachingFaculty("Maya"));
        fall2024_Schedule.getCourseOfferByNumber("DAMG6500").AssignAsTeacher(facultyDirectory.findTeachingFaculty("Mary"));

        fall2024_Schedule.getCourseOfferByNumber("CSYE6011").AssignAsTeacher(facultyDirectory.findTeachingFaculty("Mazin"));
        fall2024_Schedule.getCourseOfferByNumber("DAMG1234").AssignAsTeacher(facultyDirectory.findTeachingFaculty("Sam"));
        fall2024_Schedule.getCourseOfferByNumber("DAMG126").AssignAsTeacher(facultyDirectory.findTeachingFaculty("Alex"));
        fall2024_Schedule.getCourseOfferByNumber("DAMG879").AssignAsTeacher(facultyDirectory.findTeachingFaculty("Cathy"));
        fall2024_Schedule.getCourseOfferByNumber("DAMG9000").AssignAsTeacher(facultyDirectory.findTeachingFaculty("Robert"));

        // Debug: Print all course offerings with assigned faculty
        System.out.println("Debug: Course offerings with assigned faculty:");
        for (CourseOffer courseOffer : fall2024_Schedule.getSchedule()) {
            System.out.println(courseOffer); // Ensure CourseOffer.toString() includes faculty information
}
    }
}