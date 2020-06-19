package staticDemo;

public class BaseOne {
    static int a=1;
    static final  int b=1;
    public BaseOne() {
        System.out.println("BaseOne构造器");
    }
    {
        System.out.println("BaseOne初始化块");
        System.out.println();
    }
    static {
        System.out.println("BaseOne静态初始化块");
    }
    public  static void main(String[] args){
        BaseOne baseOne=new BaseOne();

    }
}
