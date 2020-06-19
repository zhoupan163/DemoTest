package staticDemo;
import static java.lang.Math.max;

/**
 * @author zhoupan
 */
public class Singleton {
    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }


}

class Test{
    public Integer a;
    public String name;

    public Test(int i, String abc) {
        this.a=a;
        this.name=name;    }


    public static void main(String[] args) {
        //private对象不允许跨class访问
        //Singleton s1 = new Singleton();
        //Singleton s2 = new Singleton();
        //System.out.println(s1 == s2);
        Singleton s3 = Singleton.getInstance();
        Singleton s4 = Singleton.getInstance();
        System.out.println(s3 == s4);
        String s5=new String("abc");
        String s6=new String("abc");
        String s7="abc";
        String s8="abc";
        String s9=new String(s7);
        String s10=s5;
        //string里重写了tostring方法
        System.out.println(s5);
        System.out.println("字符串比较");
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s7==s8);
        System.out.println(s9==s7);
        System.out.println(s5==s10);


        Test test1=new Test(1,"abc");
        Test test2=new Test(1,"abc");

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test1==test2);

        int a=max(1,2);
        System.out.println(a);


    }
}
