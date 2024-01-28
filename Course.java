import java.util.ArrayList;
public class Course {
    int id;
    String presenter;
    String name;
    int interest = 0;
    boolean twice = false;
    ArrayList<Student> interestedStudents = new ArrayList<Student>();
    ArrayList<Course> conflictCourses = new ArrayList<Course>();

    public Course(String name, int id, String presenter) {
        this.name = name;
        this.id = id;
        this.presenter = presenter;
        
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getInterest() {
        return interest;
    }

    public ArrayList<Student> getInterestedStudents() {
        return interestedStudents;
    }

    public String getInstructor() {
        return presenter;
    }

    public boolean getTwice() {
        return twice;
    }

    public ArrayList<Course> getConflicts() {
        return conflictCourses;
    }

    public boolean noConflicts(Course[] courses) {
        ArrayList<Course> coursesList = new ArrayList<Course>();
        for (Course c : courses) {
            coursesList.add(c);
        }
        for (Course c : coursesList) {
            if (conflictCourses.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public void addInterest(Student student) {
        interest++;
        interestedStudents.add(student);
    }

    public void setInterest(int num) {
        interest = num;
    }

    public void addConflictCourse(Course conflict) {
        conflictCourses.add(conflict);
    }

    public void setTwice(boolean b) {
        twice = b;
    }

    public String toString() {
        return Integer.toString(id);
    }
    
}
