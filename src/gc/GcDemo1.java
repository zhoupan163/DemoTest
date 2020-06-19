package gc;

/**
 * @author cgb2002 zhoupan
 */
public class GcDemo1 {
    public static void main(String[] args){
        int a=1;
        System.gc();
        System.out.println(a);

    }
}
