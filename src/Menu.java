import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Menu {
    HashMap<Integer,Course> courseSet;

    public Menu(HashMap<Integer,Course> courses){
        this.courseSet = courses;

    }
    //主界面
    int MainMenu(){
        clear();
        System.out.println("/t 0.退出");
        System.out.println("/t 1.管理员");
        System.out.println("/t 2.教师");
        System.out.println("/t 3.学生");
        System.out.println("请选择编号");
        return readInt("[0-3]");
    }

    //管理员主菜单
    int UserMainMenu(){
        clear();
        System.out.println("/t 0.退出");
        System.out.println("/t 1.显示课程清单");
        System.out.println("/t 2.显示学生列表");
        System.out.println("/t 3.显示教师列表");
        System.out.println("/t 请输入功能号");
        return readInt("[0-3]");
    }

    //课程管理菜单
    int UserCourseMenu(Vector<Course> courses){
        clear();
        for (Course course : courses) course.Show();                //输出所有课程信息
        System.out.println("/t 0.退出");
        System.out.println("/t 1.按照课程编号排序");
        System.out.println("/t 2.按照选课人数排序");
        System.out.println("/t 3.添加课程");
        System.out.println("/t 4.删除课程");
        System.out.println("/t 请输入功能号");
        return readInt("[0-4]");
    }

    //学生管理菜单
    int UserStudentMenu(Vector<Student> students){
        clear();
        for(Student student : students) student.Show();             //输出所有学生信息
        System.out.println("/t 0.退出");
        System.out.println("/t 1.添加学生");
        System.out.println("/t 2.删除学生");
        System.out.println("/t 3.重置学生密码");
        System.out.println("/t 请输入功能号");
        return readInt("[0-3]");
    }

    //教师管理菜单
    int UserTeacherMenu(Vector<Teacher> teachers){
        clear();
        for (Teacher teacher : teachers) teacher.Show();            //输出所有教师信息
        System.out.println("/t 0.退出");
        System.out.println("/t 1.添加教师");
        System.out.println("/t 2.删除教师");
        System.out.println("/t 3.重置教师密码");
        System.out.println("/t 4.更改教师职位");
        System.out.println("/t 请输入功能号");
        return readInt("[0-4]");
    }

    //学生主菜单
    int StudentMainMenu(User S){
        clear();
        if(S.getClass() == Student.class)
        System.out.println("欢迎登录"+"  "+S.name+ " "+ ((Student)S).studentID);
        System.out.println();
        System.out.println("/t 0.退出");
        System.out.println("/t 1.查看所选课程");
        System.out.println("/t 2.选修课选课");
        System.out.println("/t 3.修改登录密码");
        System.out.println("/t 请输入功能号");
        return readInt("[0-3]");
    }
    //学生选课菜单
    void StudentCourseSelectMenu(Vector<Course> courses,Student student){
        //未选课程
        System.out.println("\t 未选课程");
        for (Course course : courses){
            if(course.getClass() == Elective.class) {
                Elective elective = (Elective) course;
                if(elective.studentSet.contains(student.studentID))
                    elective.show();
            }
        }
        //已选课程
        System.out.println("\t 已选课程");
        for(int courseID : student.courseIDSet){
            if(courses.get(courseID).getClass() == Elective.class) {
                ((Elective) courses.get(courseID)).show();
            }
        }
        System.out.println("\t 请输课程编号选课");
    }

    //教师主菜单
    int TeacherMainMenu(User T){
        clear();
        if (T.getClass() == Teacher.class)
            System.out.println("欢迎登录"+"  "+T.name+ " "+ ((Teacher)T).workId);
        System.out.println();
        System.out.println("/t 0.退出");
        System.out.println("/t 1.查看任课课程");
        System.out.println("/t 2.修改登录密码");
        System.out.println("/t 请输入功能号");
        return readInt("[0-2]");
    }


    public static void clear(){
        for (int i = 0;i<20;i++)System.out.println();
    }
    //获取输入数字错误检查 RExpression正则表达式 worn错误提示语
    public static int readInt(String RExpression){
        Scanner sc = new Scanner(System.in);
        String textIn;
        while (true) {
            textIn =sc.next();
            if (textIn.matches(RExpression))
                break;
            System.out.println("输入错误请重新输入");
        }
        return Integer.parseInt(textIn);
    }
}
