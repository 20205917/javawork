import java.util.Vector;

public class Student extends User {
    int studentID;                     //学号
    String Class;                    //班级
    Vector<Integer> courseIDSet;     //选择的课程
    public Student (String name , String pass, int studentID, String Class){
        this.name = name;
        this.pass = pass;
        this.studentID = studentID;
        this.Class= Class;
    }

    public void AddCourse(Course course){

    }
    public void Show() {
        System.out.println(studentID + " " + name + "" + Class);
    }
}