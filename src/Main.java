import javax.swing.text.Position;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException {

    }
}
//黄雄苓 10 讲师
//周士杰 11 副教授
//李伯君 12 教授
//100 语文 10 45
//101 英语 11 70
//102 数学 12 20
//103 物理 10 57


//Vector<Course> courses = new Vector<>();
//        HashMap<Integer,Teacher> teacherSet = new HashMap<>(); //教师合集
//        String teacherName;                      //老师名字
//        int teacherID;                         //授课老师
//        EnumPosition    position;               //职位
//        int id;                                 //课程编号
//        String name;                            //课程名
//        int stdNum = 0;                        //选课人数
//        Scanner sc = new Scanner(System.in);
//        for(int i = 0;i<3;i++){
//            teacherName = sc.next();
//            teacherID = sc.nextInt();
//            position = switch (sc.next()){
//                case "教授":
//                    yield EnumPosition.Professor;
//                case "副教授":
//                    yield EnumPosition.AssociateProfessor;
//                default:
//                    yield EnumPosition.Lecturer;
//            };
//            teacherSet.put(teacherID,new Teacher(teacherName,teacherID,position));
//        }
//
//        for(int i = 0;i<4;i++){
//            id = sc.nextInt();
//            name = sc.next();
//            teacherID = sc.nextInt();
//            stdNum = sc.nextInt();
//            courses.add(new Course(id,name,teacherSet.get(teacherID),stdNum));
//        }
//        Course.sortCourseStdNum(courses);
//        for (Course c : courses) c.Show();
//
//        System.out.println("输入查询老师");
//        teacherID = sc.nextInt();
//        for (Course c : courses)
//            if(c.teacher ==  teacherSet.get(teacherID)){
//                c.Show();
//            }