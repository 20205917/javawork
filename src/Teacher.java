import java.util.Vector;

enum EnumPosition{
    Professor("教授",1),
    AssociateProfessor("副教授",2),
    Lecturer("讲师",3);
    private final String name;
    private final int level;
    EnumPosition(String name,int level){
        this.name = name;
        this.level = level;
    }
    public String getname(){ return name;}
    public int    getLevel(){ return level;}
}//教授、副教授、讲师


public class Teacher extends User {
    int workId;                     //工号
    EnumPosition position;          //职位:
    Vector<Integer> courseIDSet = new Vector<>();    //教授的课程
    public Teacher (String name ,int id, EnumPosition position){
        this.name   = name;

        this.workId = id;
        this.position = position;
    }
    public Teacher (String name , String pass , int id, EnumPosition position){
        this.name   = name;
        this.pass   = pass;
        this.workId = id;
        this.position = position;
    }

    public void Show () {   System.out.println (workId+""+name);    }
}
