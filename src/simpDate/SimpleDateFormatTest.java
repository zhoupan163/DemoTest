package simpDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cgb1912
 */

/**
 * simpleDateForMat线程不安全 单线程不安全 加了threadlocal就可以了
 */
public class SimpleDateFormatTest {
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    //private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(Date date) throws ParseException {
        //synchronized(sdf){
         //   return sdf.format(date);
        //}
        //return sdf.format(date);
        return threadLocal.get().format(date);
    }

    public static Date parse(String strDate) throws ParseException, ParseException {
        //synchronized(sdf){
         //   return sdf.parse(strDate);
        //}
        //return sdf.parse(strDate);
        return threadLocal.get().parse(strDate);
    }

    public static void main(String[] args) throws InterruptedException, ParseException {

        //System.out.println(sdf.format(new Date()));
        ExecutorService service = Executors.newFixedThreadPool(3);

            for (int i = 0; i < 20; i++) {
                service.execute(() -> {
                    for (int j = 0; j < 10; j++) {
                        try {
                            System.out.println(parse("2018-01-02 09:45:59"));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            // 等待上述的线程执行完
            service.shutdown();
            service.awaitTermination(1, TimeUnit.DAYS);
        }

    }
