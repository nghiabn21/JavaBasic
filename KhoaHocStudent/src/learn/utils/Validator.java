package learn.utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private static Set<String> ids = new HashSet<String>();

	public static boolean isPhone(String phone) {
		Pattern pa = Pattern.compile("^\\d{10}$"); // biên dịch phone đã cho và trả về thể hiện của patten
		Matcher ma = pa.matcher(phone); // tạo một đối sánh phù hợp với đầu vào đã cho với pattern
		return ma.matches(); // kiểm tra xem phone có phù hợp vs cấu hình hay k và trả về true or false
	}

	public static boolean isCourseId(String id) {
		Pattern pa = Pattern.compile("[A-Z]{2}\\d{3}"); // bắt đầu là 2 chữ in hoa theo sau là 3 chữ số
		Matcher ma = pa.matcher(id);
		return ma.matches();
	}

	public static boolean isExisted(String id) {
		if (!ids.contains(id)) {
			ids.add(id);
			return true;
		} else {
			return false;
		}

	}

	public static boolean isStudentId(String id) {
		Pattern pa = Pattern.compile("^\\d{6}$"); // 6 chữ số
		Matcher ma = pa.matcher(id);
		return ma.matches();
	}

	public static Set<String> getIds() {
		return ids;
	}

	public static double isCredit(String credit) {
		double doCredit = 0d;
		try {
			doCredit = Double.parseDouble(credit);
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
		return doCredit;
	}

	public static int isEnrollment(String enrollment) {
		int intEnrollment = 0;
		try {
			intEnrollment = Integer.parseInt(enrollment);
		} catch (NumberFormatException exception) {
			throw new NumberFormatException();
		}
		return intEnrollment;
	}

}
