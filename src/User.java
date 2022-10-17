import java.util.Scanner;

public class User {
    String name; //用户名
    String pass = "12345";//密码
    public User (String name,String pass) {//给属性进行初始化的构造方法
        this.name = name;
        this.pass = pass;
    }
        public User() {};

    public void Show ( ) {//显示用户信息
        System.out.println ( "用尸名:"+name);
    }
    public Boolean login (String pass){//管理员登录方法
        return (pass.equals (this.pass) );
    }

    public void SetPassword() { //修改用户密码
        Scanner sc = new Scanner (System.in) ;
        while (true){
            System.out.print ("请输入新密码（ 6位）: ") ;
            String xpass1=sc.next();
            System. out.print("请再次输入密码（ 6位〉");
            String xpass2=sc.next();
            if(xpass1.equals (xpass2 )&&xpass1.length ( )==6){
                this.pass=xpass1;
                break ;
            }
        }
    }


}

