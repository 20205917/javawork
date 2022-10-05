import java.util.Comparator;
import java.util.Vector;

enum Coursetype{   //枚举类型
    obligatory("必修"),
    elective("选修"),
    other("其他");
    private final String name;
    Coursetype(String str){
        this.name = str;
    }
    public String getname(){
        return name;
    }

}
public class Course{
    int courseID;                                 //课程编号
    String name;                            //课程名
    Coursetype type = Coursetype.other;     //课程类型
    Teacher teacher;                        //授课老师
    int stdNum;                            //选课人数


    public Course(int courseID, String name, Teacher teacher, int stdNum){
        this.courseID = courseID;
        this.name = name;
        this.teacher = teacher;
        this.stdNum = stdNum;
    }
    public Course(){}
    //课程简介
    public void Show(){     //显示课程信息
        System.out.println(courseID +" | "+name+" | "+teacher.name+teacher.position + " | " +stdNum +"人");
    }

    //按编号排序
    public static Vector<Course> sortCourseID(Vector<Course> courses)
    {
        courses.sort(new CmpCourseID());
        return courses;
    }
    //按上课人数排序
    public static Vector<Course> sortCourseStdNum(Vector<Course> courses)
    {
        courses.sort(new CmpCourseStdNum());
        return courses;
    }

}

class CmpCourseStdNum implements Comparator<Course> {
    @Override
    public int compare(Course o1,Course o2){
        return o1.stdNum-o2.stdNum;
    }
}
class CmpCourseID implements Comparator<Course> {
    @Override
    public int compare(Course o1,Course o2){
        return o1.stdNum-o2.stdNum;
    }
}