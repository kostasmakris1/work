package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class General {

	/** Method to return the age of an underaged person in String
	 *
	 * @return
	 */
	public static String getUnderAgedPlayerDate () {

		int i = new Random().nextInt(17);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -i);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(cal.getTime()) ;
	}
}
