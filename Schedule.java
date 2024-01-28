import java.util.ArrayList;
public class Schedule {
    Course[][] schedule = new Course[5][5];
    ArrayList<Student> students;
    ArrayList<Course> courses;
    ArrayList<Course> coursesTwice = new ArrayList<Course>();

    public Schedule(ArrayList<Student> students, ArrayList<Course> courses) {
        this.students = students;
        this.courses = courses;
    }

    public void findConflicts() {
        for (Course c : courses) {
            for (Course c2 : courses) {
                if (c.getInstructor().equals(c2.getInstructor())) {
                    c.addConflictCourse(c2);
                }
            }
            
        }
    }

    public void populateSchedule() {

        schedule[0][0] = courses.get(0);

        for (Course c : courses) {
            if (c.getTwice()) {
                coursesTwice.add(c);
            }
        }

        for (Course c : courses) {
            for (int i = 0; i < schedule.length; i++) {
                if (c.noConflicts(schedule[i])) {
                    for (int j = 0; j < schedule[0].length; j++) {
                        if (schedule[i][j] == null && !containsCourse(c, schedule)) {
                            schedule[i][j] = c;
                        }
                    }
                }
            }
        }

        for (Course c : coursesTwice) {
            for (int i = 0; i < schedule.length; i++) {
                if (c.noConflicts(schedule[i])) {
                    for (int j = 0; j < schedule[0].length; j++) {
                        // This overwritten method checks just the row instead of the whole 2d array
                        if (schedule[i][j] == null && !containsCourse(c, schedule[i])) {
                            schedule[i][j] = c;
                        }
                    }
                }
            }
        }
    }

    public boolean containsCourse(Course course, Course[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == course) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsCourse(Course course, Course[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == course) {
                return true;
            }
        }
        return false;
    }

    public Course[][] getSchedule() {
        return schedule;
    }

}
