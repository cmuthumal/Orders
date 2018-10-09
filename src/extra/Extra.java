/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package extra;

import com.toedter.calendar.JCalendar;
import java.awt.Dimension;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author CM <2222cm@gmail.com>
 */
public class Extra {

    public boolean limitedTo(int number, int limit) {
        int count = 0;
        boolean b = false;
        while (number > 0) {
            number = (number / 10);
            count++;
        }
        if (count == limit) {
            b = true;
        }
        return b;
    }

    public boolean validateDate(String date) throws NullPointerException {
        if (!date.equals("")) {
            Pattern pattern = Pattern.compile("[1,2][0,1,2,9][0-9]{2}[-][0,1][0-9][-][0,1,2,3][0-9]");
            Matcher matcher = pattern.matcher(date);

            boolean b = false;

            if (matcher.find()) {
                b = true;
            } else {
                b = false;
            }
            return b;
        } else {
            return false;
        }
    }

    public void setCalendar(JCalendar calendar) {
        Dimension size = new Dimension(375, 255);
        calendar.setPreferredSize(size);
        calendar.setWeekOfYearVisible(false);
        calendar.setTodayButtonVisible(true);
    }

    public boolean validateText(String text) {
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(text);
        return m.find();
    }
}
