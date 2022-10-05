import java.util.HashMap;
import java.util.Vector;

public class AllUser {
    public User  controller;                    //管理员
    public HashMap<Integer,Student> studentSet;   //学生合集
    public HashMap<Integer,Teacher> teacherSet; //教师合集

    public Student getStudent(int studentID){
        return studentSet.get(studentID);
    }
    public Teacher getTeacher(int teacherID){
        return teacherSet.get(teacherID);
    }

}
