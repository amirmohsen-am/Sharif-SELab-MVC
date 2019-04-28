package selab.mvc.models.entities;

import selab.mvc.models.DataSet;
import selab.mvc.models.Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Student implements Model {
    private String name;
    private String studentNo;
    private String courses = "";
    private LinkedList<Integer> points = new LinkedList<Integer>();


    @Override
    public String getPrimaryKey() {
        return this.studentNo;
    }

    public void setName(String value) { this.name = value; }
    public String getName() { return this.name; }

    public void setStudentNo(String value) {
        if (!validateStudentNo(value))
            throw new IllegalArgumentException("The format is not correct");

        this.studentNo = value;
    }
    public String getStudentNo() { return this.studentNo; }

    public float getAverage() {

        int sum = 0;
        if (points.isEmpty())
            return 0;
        else {
            for (int i = 0; i < points.size(); i++) {
                sum += points.get(i);
            }
            // TODO: Calculate and return the average of the points
            return sum/points.size();
        }
    }


    public String getCourses() {
        return courses;
    }

    /**
     *
     * @param studentNo Student number to be checeked
     * @return true, if the format of the student number is correct
     */
    private boolean validateStudentNo(String studentNo) {
        Pattern pattern = Pattern.compile("^[8-9]\\d{7}$");
        return pattern.matcher(studentNo).find();
    }

    public void addCourse(String course) {
        courses = courses.concat(course);
        courses = courses.concat(",");

    }

    public void addPoints(Integer point) {
       points.add(point);

    }
}
