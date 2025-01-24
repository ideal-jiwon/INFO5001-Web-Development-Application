/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseSchedule;

import CourseCatalog.Course;

public class SeatAssignment {
    private float grade; // Letter grade mappings: A=4.0, A-=3.7, B+=3.3, B=3.0, etc.
    private Seat seat;
    private boolean like; // true means the student liked the course; false means they didn’t
    private CourseLoad courseload;

    public SeatAssignment(CourseLoad cl, Seat s) {
        seat = s;
        courseload = cl;
    }
     
    public boolean getLike() {
        return like;
    }

    public void setLike(boolean like) { // Changed return type to void
        this.like = like;
    }
    
    public void assignSeatToStudent(CourseLoad cl) {
        courseload = cl;
    }
    
    public int getCreditHours() {
        return seat.getCourseCredits();
    }
    
    public Seat getSeat() {
        return seat;
    }
    
    public CourseOffer getCourseOffer() {
        return seat.getCourseOffer();
    }
    
    public Course getAssociatedCourse() {
        return getCourseOffer().getSubjectCourse();
    }
    
    public void setGrade(float grade) {
        this.grade = grade;
    }
    
    public float getGrade() {
        return grade;
    }
    
    public float getCourseStudentScore() { // Updated method name for consistency
        return getCreditHours() * grade;
    }
}
