import java.util.HashMap;
import java.util.Vector;

public class Elective extends Course{
    int maxnum;                         //最大选课人数
    HashMap<Integer,Student> students = new HashMap<>();          //已选学员
    public Elective(int id, String name, Teacher teacher, int stdNum, int maxNum){
        this.courseID = id;
        this.name = name;
        this.teacher = teacher;
        this.stdNum = stdNum;
        this.maxnum = maxNum;
        this.type = Coursetype.elective;
    }
    public Elective(){}
    public void show(){}
    public boolean addStudent(Student student){             //添加学生
        return true;
    }
}
