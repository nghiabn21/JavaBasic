package learn.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private static Matcher matcher = null;
	private static Pattern pattern = null;

	/**
	 * This method check format of date value.
	 *
	 * @param String date.
	 * @return boolean
	 */
	public static boolean isDate(String date) {
		pattern = Pattern.compile(Constant.DATE_PATTERN);
		matcher = pattern.matcher(date);
		return matcher.matches();
	}

	/**
	 * This method check format of "position" attribute.
	 *
	 * @param String position.
	 * @return boolean
	 */
	public static boolean isPosition(String position) {
		pattern = Pattern.compile(Constant.POSITION_PATTERN);
		matcher = pattern.matcher(position);
		return matcher.matches();
	}
}