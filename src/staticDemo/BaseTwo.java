package staticDemo;

import java.util.Random;

/**
 * @author zhoupan
 */
public class BaseTwo extends BaseOne{
    static int a=0;
    public BaseTwo() {
        System.out.println("BaseTwo构造器");
    }
    {
        System.out.println("BaseTwo初始化块");
        System.out.println();
    }
    static {
        System.out.println("BaseTwo静态初始化块");
    }
    public  static void main(String[] args){
        BaseTwo BaseTwo=new BaseTwo();
        BaseOne baseOne=new BaseOne();
        BaseOne.a=2;
        System.out.println(BaseOne.a);
        //给static final修饰会导致 变量无法被更改
        // BaseOne.b=3;
        System.out.println(BaseOne.b);
        System.out.println(a);

    }
}
