public class Obligatory extends Course{
    double credit;//学分
    public Obligatory(int id, String name,Teacher teacher,int stdnum,double credit){
        this.courseID = id;
        this.name = name;
        this.teacher = teacher;
        this.stdNum = stdnum;
        this.credit = credit;
        this.type = Coursetype.obligatory;
    }
    public void show(){}
}