package academy.tochkavhoda.thread.task13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {
    private final String pattern;
    ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal;

    public Formatter() {
        pattern = "yyyy-MM-dd-HH-mm-ss-SS";
        simpleDateFormatThreadLocal = new ThreadLocal<>();
    }

    public void format(Date date) {
        simpleDateFormatThreadLocal.set(new SimpleDateFormat(pattern));
        System.out.println(simpleDateFormatThreadLocal.get().format(date));
    }

    public void formatAllLocals(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.out.println(simpleDateFormat.format(date));
    }
}
