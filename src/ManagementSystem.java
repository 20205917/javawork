import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;


public class ManagementSystem {
    static final File COURSEPATH  = new File("course.txt");                //路径
    static final File TEACHERPATH = new File("teacher.txt");               //路径
    static final File STUDENTPATH = new File("student.txt");               //路径
    AllUser users = new AllUser();                                                       //用户集合
    HashMap<Integer,Course> courseSet = new HashMap<>();                                   //课程集合
    Menu menu;
    User user = new User();
    public ManagementSystem(){
    }
    public boolean run(){
        int selection = 1;
        Vector<Course> courses = new Vector<>(courseSet.values());
        Vector<Student> students = new Vector<>(users.studentSet.values());
        Vector<Teacher> teachers = new Vector<>(users.teacherSet.values());
        while (true)
        {
            switch (selection){
                case 0->{return true;}                                                                             //退出
                case 1->selection = mainLogin();                                                                //登录主界面
                case 2->selection = 5+menu.UserMainMenu();                                                      //管理员主菜单
                case 3->selection = 24+menu.TeacherMainMenu(user);                                              //教师主菜单
                case 4->selection = 27+menu.StudentMainMenu(user);                                               //学生界面
                //管理员主菜单
                case 5->selection = 1;                                                                          //回退登录主界面
                case 6->selection = 9+menu.UserCourseMenu(courses);                                             //管理员主菜单---课程管理菜单
                case 7->selection = 14+menu.UserTeacherMenu(teachers);                                          //管理员主菜单---教师管理界面
                case 8->selection = 19+menu.UserStudentMenu(students);                                          //管理员主菜单---学生管理界面
                //管理员主菜单---课程管理菜单
                case 9->selection = 2;                                                                          //0.返回管理员主菜单
                case 10->selection = 9+menu.UserCourseMenu(Course.sortCourseID(courses));                       //1.按照课程编号排序
                case 11->selection = 9+menu.UserCourseMenu(Course.sortCourseStdNum(courses));                   //2.按照选课人数排序
                case 12->selection = 6;                                                                         //3，4.增加减少课程

                //管理员主菜单---教师管理界面
                case 14->selection = 2;                                                                         //0.返回主菜单
                case 15->{selection = 7;}                                                                //1，2，3，4.增删改教师

                //管理员主菜单---学生管理界面
                case 19->selection = 2;                                                                         //0.返回管理员主菜单
                case 20->selection = 8;                                                                //1，2，3。增删改学生


                //教师主菜单
                case 24->selection = 1;                                                                         //0.回退登录主界面
                case 25->{TeacherCheckOutCourse();selection = 24;}                                              //1.查看任课课程
                case 26->{alterPassword(user); selection = 24;}                                                 //2.修改登录密码


                //学生主菜单
                case 27->selection = 1;                                                                         //0.回退登录主界面
                case 28->{StudentCourseSelect(user);selection = 27;}                                            //1.查看所选课程                 //2.选修课选课
                case 29->{alterPassword(user); selection = 27;}                                                 //2.修改登录密码
                default -> {return false;}
            }
        }
    }
    //登录系统
    int mainLogin(){
        int selection;
        selection = menu.MainMenu();
        if (selection == 0) return 0;
        switch (selection){
            case 1-> user = controllerLogin();
            case 2-> user = teacherLogin();
            case 3-> user = studentLogin();
        }
        if(user == null) return 1;
        else if(user.getClass() == User.class) return 2;
        else if(user.getClass() == Teacher.class) return 3;
        else if(user.getClass() == Student.class) return 4;
        return 0;
    }
    //管理员登录
    User controllerLogin(){
        String  pass;
        System.out.println("请输入管理员密码:");
        Scanner sc = new Scanner(System.in);
        pass = sc.next();
        if(!users.controller.pass.equals(pass)){               //密码错误
            System.out.println("密码错误");
            sc.nextLine();
        }
        else {                                                      //登陆成功
            System.out.println("登录成功");
            return users.controller;
        }
        //登录失败
        System.out.println("输入 1 继续，输入任意其他返回");
        if("1".equals(sc.next()))
            return controllerLogin();
        else
            return null;
    }
    //教师登录
    User teacherLogin() {
        int id;
        String pass;
        System.out.println ("请输入工号:");
        Scanner sc=new Scanner (System.in);
        id = Menu.readInt("[0-9{8}");
        System.out.println ("请输入密码:");
        pass = sc.next();
        if(!users.teacherSet.containsKey(id))                         //账号错误
        {
            System.out.println("账号不存在");
            sc.nextLine();
        }
        else if(!users.teacherSet.get(id).pass.equals(pass)){               //密码错误
            System.out.println("密码错误");
            sc.nextLine();
        }
        else {
            System.out.println("登录成功");
            return users.teacherSet.get(id);
        }
        //登录失败
        System.out.println("输入 1 继续，输入任意其他返回");
        if("1".equals(sc.next()))
            return teacherLogin();
        else
            return null;
    }
    //学生登录
    User studentLogin() {
        int id;
        String pass;
        System.out.println ("请输入学号:");
        Scanner sc=new Scanner (System.in);
        id = Menu.readInt("[0-9{8}");
        System.out.println ("请输入密码:");
        pass = sc.next();
        if(!users.studentSet.containsKey(id))                         //账号错误
        {
            System.out.println("账号不存在");
            sc.nextLine();
        }
        else if(!users.studentSet.get(id).pass.equals(pass)){               //密码错误
            System.out.println("密码错误");
            sc.nextLine();
        }
        else {                                                      //登陆成功
            System.out.println("登录成功");
            return users.studentSet.get(id);
        }
        //登录失败
        System.out.println("输入 1 继续，输入任意其他返回");
        if("1".equals(sc.next()))
            return studentLogin();
        else
            return null;
    }
    //修改登录密码
    boolean alterPassword(@NotNull User me){
        Scanner sc = new Scanner(System.in);
        String str1 = me.pass,str2 = null;
        while (!str1.equals(str2)){
            System.out.println("输入0返回");
            System.out.print("请输入新密码：");
            str1 = sc.next();
            if(str1.equals("0")) return false;
            System.out.print("请确认新密码：");
            str2 = sc.next();
            if(str2.equals("0")) return false;
        }
        me.pass = str1;
        System.out.println("修改成功");
        while (!sc.next().equals("0"));
        return true;
    }
    //课程增减
    boolean alterCourse(){
        int courseID;                           //课程编号
        String name;                            //课程名
        Coursetype type = Coursetype.other;     //课程类型
        Teacher teacher;                        //授课老师
        Scanner sc = new Scanner(System.in);
        System.out.print("\n课程编号");
        courseID = sc.nextInt();
        if(courseSet.containsKey(courseID))
        {
            System.out.println("\n编号重复");
            return false;
        }
        System.out.print("\n课程名:");
        name = sc.next();
        System.out.print("\n");
        return true;
    }
    //教师课程查看
    void TeacherCheckOutCourse(){
        if(user.getClass() != Teacher.class) return;
        Teacher teacher = (Teacher) user;
        Scanner scanner = new Scanner(System.in);
        for (int x :teacher.courseIDSet){
            courseSet.get(x).Show();
        }
        while (true){
            int courseID;
            System.out.println("输入0返回");
            System.out.println("输入编号查询课程详情");
            courseID = scanner.nextInt();
            if(courseID == 0) return;
            if(!teacher.courseIDSet.contains(courseID)){
                System.out.println("不是您所教授的课程的课程号");
                continue;
            }
            Course course = courseSet.get(courseID);
            course.Show();
            if(course.type == Coursetype.obligatory)  //必修课
                for(Student student : users.studentSet.values()){
                    student.Show();
                }
            else if(course.type == Coursetype.elective) {//选修课
                for (Student student : ((Elective)course).students.values()){
                    student.Show();
                }
            }
        }
    }
    //学生选课

    //学生选课菜单
    void StudentCourseSelect(@NotNull User user){
        //已选课程
        if(user.getClass() != Student.class) return;
        Student student  = (Student)user;
        System.out.println("\t 已选课程");
        for(int courseID : student.courseIDSet){
            if(courseSet.get(courseID).getClass() == Elective.class) {
                ((Elective) courseSet.get(courseID)).show();
            }
        }
        HashMap<Integer,Course> electiveSet = new HashMap<>();
        //未选课程
        System.out.println("\t 未选课程");
        for (Course course : courseSet.values()){
            if(course.getClass() == Elective.class) {
                Elective elective = (Elective) course;
                if(elective.students.containsKey(student.studentID))
                {elective.show();electiveSet.put(elective.courseID,elective);}
            }
        }
        int courseID;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("输入0返回");
            System.out.println("输入编号进行选课");
            courseID = sc.nextInt();
            if (courseID == 0) return;
            if (!electiveSet.containsKey(courseID) || ((Elective)electiveSet.get(courseID)).addStudent(student))
                System.out.println("无法选择改课号");
            else System.out.println("选课成功");
        }
    }
    //读取文件
    void Load() throws IOException {
        Scanner reader;
        Coursetype type;
        String name;                          //用户名
        String pass;                          //密码
        int Id;                               //工号
        EnumPosition position;                //职位:
        String  Class;                        //班级
        int teacherID;                       //授课老师
        int stdNum;                          //选课人数
        //教师信息录入
        reader = new Scanner(new FileInputStream(TEACHERPATH));
        while (reader.hasNext()){
            name = reader.next();
            pass = reader.next();
            Id = reader.nextInt();
            position = switch (reader.next()){
                case "教授":
                    yield EnumPosition.Professor;
                case "副教授":
                    yield EnumPosition.AssociateProfessor;
                default://讲师
                    yield EnumPosition.Lecturer;
            };
            users.teacherSet.put(Id,new Teacher(name,pass,Id,position));
        }
        //学生信息录入
        reader = new Scanner(new FileInputStream(STUDENTPATH));
        while (reader.hasNext()){
            name = reader.next();
            pass = reader.next();
            Id = reader.nextInt();
            Class = reader.next();
            users.studentSet.put(Id,new Student(name,pass,Id,Class));
        }
        //课程信息录入
        reader = new Scanner(new FileInputStream(COURSEPATH));
        while (reader.hasNext()){
            Course  course;
            type = switch (reader.next()){
                case "必修":yield Coursetype.obligatory;
                case "选修":yield Coursetype.elective;
                default:yield Coursetype.other;
            };
            Id = reader.nextInt();
            name = reader.next();
            teacherID = reader.nextInt();
            stdNum = reader.nextInt();
            System.out.println(name);
            //必修课登记
            if(type == Coursetype.obligatory) {
                course = new Obligatory(Id, name, users.teacherSet.get(teacherID), stdNum, reader.nextDouble());
                for (Student student : users.studentSet.values()) student.courseIDSet.add(Id);
            }
            //选修课及选课学生信息录入
            else {
                course = new Elective(Id, name, users.teacherSet.get(teacherID), stdNum, reader.nextInt());
                for (int i = 0;i<((Elective)course).stdNum;i++){
                    Student student = users.studentSet.get(reader.nextInt());
                    student.courseIDSet.add(Id);
                    ((Elective) course).students.put(student.studentID,student);
                }
            }
            users.teacherSet.get(teacherID).courseIDSet.add(Id);
            courseSet.put(Id,course);
        }
        menu = new Menu(courseSet);
    }
}
