

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

public class debugTest {

        // Define ANSI color codes
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) {
        College neuCollege = new College("Northeastern University");
        //Debug Test 
        System.out.println(RED + "1. if college has been added----------------");
        if (neuCollege != null) {
            System.out.println(RED + "Debug: College object created successfully.");
        } else {
            System.out.println(RED + "Error: College object creation failed.");
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
        System.out.println(CYAN+ "------------------------------------------------------");
        System.out.println(CYAN + "Debug: MSIS Department Courses:");
        System.out.println(coursecatalog1.getCourseList());

        CourseCatalog coursecatalog2 = msdaDepartment.getCourseCatalog();
        coursecatalog2.newCourse("CSYE6011", "Software Application", 4);
        coursecatalog2.newCourse("DAMG1234", "Data Mining & Analytics", 4);
        coursecatalog2.newCourse("DAMG126", "Big Data Warehousing", 4);
        coursecatalog2.newCourse("DAMG879", "Python Fundamentals", 4);
        coursecatalog2.newCourse("DAMG9000", "R-Analytics", 4);
        System.out.println(PURPLE + "------------------------------------------------------");
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
        System.out.println(GREEN + "------------------------------------------------------");
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
        System.out.println(YELLOW + "------------------------------------------------------");
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
        System.out.println(GREEN + "------------------------------------------------------");
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
        System.out.println(RED + "------------------------------------------------------");
        System.out.println("Debug: All course offerings for Fall 2024:");
        for (CourseOffer courseOffer : courseOffers) {
                System.out.println(courseOffer);
}      

        // 8. Assign faculty to each course offering
        fall2024_Schedule.getCourseOfferByNumber("INFO6250").AssignAsTeacher(facultyDirectory.findTeachingFaculty("1"));
        fall2024_Schedule.getCourseOfferByNumber("INFO7150").AssignAsTeacher(facultyDirectory.findTeachingFaculty("2"));
        fall2024_Schedule.getCourseOfferByNumber("CSYE6205").AssignAsTeacher(facultyDirectory.findTeachingFaculty("3"));
        fall2024_Schedule.getCourseOfferByNumber("CSYE6202").AssignAsTeacher(facultyDirectory.findTeachingFaculty("4"));
        fall2024_Schedule.getCourseOfferByNumber("DAMG6500").AssignAsTeacher(facultyDirectory.findTeachingFaculty("2"));

        fall2024_Schedule.getCourseOfferByNumber("CSYE6011").AssignAsTeacher(facultyDirectory.findTeachingFaculty("5"));
        fall2024_Schedule.getCourseOfferByNumber("DAMG1234").AssignAsTeacher(facultyDirectory.findTeachingFaculty("2"));
        fall2024_Schedule.getCourseOfferByNumber("DAMG126").AssignAsTeacher(facultyDirectory.findTeachingFaculty("1"));
        fall2024_Schedule.getCourseOfferByNumber("DAMG879").AssignAsTeacher(facultyDirectory.findTeachingFaculty("3"));
        fall2024_Schedule.getCourseOfferByNumber("DAMG9000").AssignAsTeacher(facultyDirectory.findTeachingFaculty("4"));

        // Debug: Print all course offerings with assigned faculty
        System.out.println(YELLOW + "------------------------------------------------------");
        System.out.println("Debug: Course offerings with assigned faculty:");
        for (CourseOffer courseOffer : fall2024_Schedule.getSchedule()) {
            System.out.println(courseOffer); 
}

        // 9. Randomly register each student for 1 or 2 courses from the merged schedule
        List<StudentProfile> allStudents = studentDirectory.getStudentList(); // Use the shared StudentDirectory
        Random random = new Random();

        System.out.println(GREEN + "------------------------------------------------------");
        System.out.println("Randomly registering students for Fall 2024 courses : ");

        for (StudentProfile student : allStudents) {
            CourseLoad courseload = student.newCourseLoad("fall2024"); // Create a new course load for the semester
            int numberOfCourses = random.nextInt(2) + 1; // Randomly decide between 1 or 2 courses

            // Randomly assign courses
            for (int i = 0; i < numberOfCourses; i++) {
                CourseOffer randomCourse = courseOffers.get(random.nextInt(courseOffers.size())); // Select a random course offering
             randomCourse.assignEmptySeat(courseload); // Assign a seat in the course
         }

            // Debug: Print student and assigned courses
            System.out.println("Student: " + student.getPerson().getPersonName() + " (" + student.getPerson().getPersonId() + ")");
            for (SeatAssignment sa : courseload.getSeatAssignments()) {
             Course course = sa.getSeat().getCourseOffer().getCourse();
                System.out.println("\tCourse: " + course.getCOurseNumber() + " - " + course.getCOursename());
    }
        }
            // 10. Assign random grades to each student's course assignments
            assignRandomGradesToAllStudents(allStudents);
    }
            // Method to assign random grades to each student's courses
            public static void assignRandomGradesToAllStudents(List<StudentProfile> allStudents) {
            Random random = new Random();
            System.out.println(BLUE + "------------------------------------------------------");
            System.out.println("Assigning random grades to all students");

            for (StudentProfile student : allStudents) {
            System.out.println("Student: " + student.getPerson().getPersonName() + " (" + student.getPerson().getPersonId() + ")");
                for (SeatAssignment seatAssignment : student.getTranscript().getCourseList()) {
                    // Generate a random grade between 0.0 and 4.0
                    float grade = 0.0f + random.nextFloat() * (4.0f - 0.0f);
                    seatAssignment.setGrade(grade);

                    // Debug: Print course and assigned grade
                    Course course = seatAssignment.getSeat().getCourseOffer().getCourse();
                    System.out.printf("\tCourse: %s - %s | Grade: %.2f%n", course.getCOurseNumber(), course.getCOursename(), grade);
        }
    }
}
    }

