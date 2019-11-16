package cn.imcompany.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static java.time.temporal.ChronoUnit.HOURS;

/**
 * Created by tomyli on 2019-09-23.
 * Github: https://github.com/peng051410
 */
public class DateStudy {

    public static void main(String[] args) {

        final LocalDateTime now = LocalDateTime.now();
        System.out.println(now.truncatedTo(HOURS).equals(LocalDateTime.now().truncatedTo(HOURS)));

        System.out.println(checkDateStrValid("2019-02-30"));
        Integer aIntegerObj = new Integer("1");
    }

    private static boolean checkDateStrValid(String mydate) {
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try {
            final Date parse = format.parse(mydate);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
