/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Department;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import Degree.Degree;
import Employer.EmployerDirectory;
import Persona.Faculty.FacultyDirectory;
import Persona.PersonDirectory;
import Persona.StudentProfile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Department {

    private String name;
    private CourseCatalog courseCatalog;
    private PersonDirectory personDirectory;
    private FacultyDirectory facultyDirectory;
    private EmployerDirectory employerDirectory;
    private Degree degree;

    private HashMap<String, CourseSchedule> masterCourseCatalog; // Master catalog by semester
    private List<CourseCatalog> additionalCatalogs; // To support multiple catalogs

    public Department(String name) {
        this.name = name;
        this.masterCourseCatalog = new HashMap<>();
        this.courseCatalog = new CourseCatalog(this);
        this.personDirectory = new PersonDirectory();
        this.facultyDirectory = new FacultyDirectory(null);
        this.degree = new Degree("MSIS");
        this.additionalCatalogs = new ArrayList<>(); // Initialize additional catalogs list
    }

    // Add a secondary course catalog
    public void addAdditionalCatalog(CourseCatalog catalog) {
        additionalCatalogs.add(catalog);
    }

    // Combine all catalogs (main and additional)
    private List<CourseCatalog> getAllCatalogs() {
        List<CourseCatalog> allCatalogs = new ArrayList<>();
        allCatalogs.add(courseCatalog);
        allCatalogs.addAll(additionalCatalogs);
        return allCatalogs;
    }

    public void addCoreCourse(Course course) {
        degree.addCoreCourse(course);
    }

    public void addElectiveCourse(Course course) {
        degree.addElectiveCourse(course);
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public FacultyDirectory getFacultyDirectory() {
        return facultyDirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {
        // Use merge (main + additional) when creating a new schedule
        CourseCatalog mergedCatalog = mergeAllCatalogs();
        CourseSchedule cs = new CourseSchedule(semester, mergedCatalog);
        masterCourseCatalog.put(semester, cs);
        return cs;
    }
    private CourseCatalog mergeAllCatalogs() {
        CourseCatalog mergedCatalog = new CourseCatalog(this);
        mergedCatalog.mergeCatalog(courseCatalog);
        for (CourseCatalog additionalCatalog : additionalCatalogs) {
            mergedCatalog.mergeCatalog(additionalCatalog);
        }
        return mergedCatalog;
    }

    public CourseSchedule getCourseSchedule(String semester) {
        return masterCourseCatalog.get(semester);
    }

    public CourseCatalog getCourseCatalog() {
        return courseCatalog;
    }

    public Course newCourse(String number, String name, int credits) {
        return courseCatalog.newCourse(number, name, credits);
    }

    public int calculateRevenuesBySemester(String semester) {
        CourseSchedule courseSchedule = masterCourseCatalog.get(semester);
        return (courseSchedule != null) ? courseSchedule.calculateTotalRevenues() : 0;
    }

    // Update RegisterForAClass to use the college's StudentDirectory
    public void registerForAClass(String studentId, String courseNumber, String semester, StudentProfile studentProfile) {
        if (studentProfile == null) {
            System.out.println("Student not found in the Student Directory.");
            return;
        }

        CourseLoad courseLoad = studentProfile.getCurrentCourseLoad();
        if (courseLoad == null) {
            courseLoad = studentProfile.newCourseLoad(semester);
        }

        CourseSchedule courseSchedule = masterCourseCatalog.get(semester);
        if (courseSchedule != null) {
            CourseOffer courseOffer = courseSchedule.getCourseOfferByNumber(courseNumber);
            if (courseOffer != null) {
                courseOffer.assignEmptySeat(courseLoad);
            } else {
                System.out.println("Courses are not found in the semester " + semester);
            }
        } else {
            System.out.println("Courses are not found in the semester " + semester);
        }
    }
}
