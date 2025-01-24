/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import java.util.ArrayList;


/**
 *
 * @author kal bugrara
 */
public class CourseSchedule {

    private CourseCatalog courseCatalog; // A single merged CourseCatalog
    private ArrayList<CourseOffer> schedule; // List of CourseOffers
    private String semester; // Semester name

    // Constructor to initialize CourseSchedule with a merged CourseCatalog
    public CourseSchedule(String semester, CourseCatalog courseCatalog) {
        this.semester = semester;
        this.courseCatalog = courseCatalog;
        this.schedule = new ArrayList<>();
    }

    // Getter for the schedule
    public ArrayList<CourseOffer> getSchedule() {
        return schedule; // Returns the list of CourseOffers
    }

    // Add a new CourseOffer to the schedule
    public CourseOffer newCourseOffer(String courseNumber) {
        Course course = courseCatalog.getCourseByNumber(courseNumber); // Lookup course in the merged catalog
        if (course == null) {
            System.out.println("Error: Course " + courseNumber + " not found in the catalog.");
            return null;
        }
        CourseOffer courseOffer = new CourseOffer(course); // Create new CourseOffer
        schedule.add(courseOffer); // Add to schedule
        return courseOffer;
    }

    // Retrieve a CourseOffer by course number
    public CourseOffer getCourseOfferByNumber(String courseNumber) {
        for (CourseOffer courseOffer : schedule) {
            if (courseOffer.getCourseNumber().equals(courseNumber)) {
                return courseOffer; // Return matching CourseOffer
            }
        }
        return null; // Return null if no match found
    }

    // Getter for semester name
    public String getSemester() {
        return semester;
    }

    // Calculate total revenues for all courses in the schedule
    public int calculateTotalRevenues() {
        int totalRevenue = 0;
        for (CourseOffer courseOffer : schedule) {
            totalRevenue += courseOffer.getTotalCourseRevenues();
        }
        return totalRevenue;
    }

    // Debugging utility: Print the schedule in readable format
    @Override
    public String toString() {
        return "CourseSchedule[Semester=" + semester + ", Schedule=" + schedule + "]";
    }
}