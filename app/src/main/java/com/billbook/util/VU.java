package com.billbook.util;

import android.widget.EditText;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VU {
	public static final String MOBILE_PATTERN = "[0-9]{10}";
	public static final String PHONE_PATTERN="[0-9]{11}";
	public static final String LAND_LINE_PATTERN = "[0-9]{11}";
	public static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
	public static Pattern pattern;
	public static Matcher matcher;
	public static final String PANCARD_PATTERN = "[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}";
	public static final String CIN_PATTERN = "[a-zA-Z]{1}[0-9]{5}[a-zA-Z]{2}[0-9]{4}[a-zA-Z]{3}[0-9]{6}"; //U72200KL2002PTC123456
	public static final String VEHICLE_NO_PATTERN = "[A-Z]{2}[ -][0-9]{1,2}(?: [A-Z])?(?: [A-Z]*)?[0-9]{4}";
	public static final String WEBSITE_URL = "^(http://|https://)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$";

	public static boolean isEmpty(EditText editText)
	{
		// TODO method to check edit text is fill or no
		// return true when edit text is empty
		return editText.getText().toString().trim().equals("");
	}

	public static boolean isDotOnly(EditText editText)
	{
		// TODO method to check edit text is fill or no
		if(editText.getText().toString().trim().equals(""))
		{
			return true;
		}
		if (editText.getText().toString().charAt(0) == '.')
		{
			return true;
		}

		return editText.getText().toString().length() == 1
				&& editText.getText().toString().charAt(0) == '.';
	}


	public static boolean isEmailId(EditText editText) {
		// method to check edit text is fill or no
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(editText.getText().toString().trim());
		return !matcher.matches();

	}

	public static boolean isPanCardNo(EditText editText) {
		// method to check edit text is fill or no
		pattern = Pattern.compile(PANCARD_PATTERN);
		matcher = pattern.matcher(editText.getText().toString().trim());
		return !matcher.matches();

	}
	public static boolean isCinNo(EditText editText) {
		// method to check edit text is fill or no
		pattern = Pattern.compile(CIN_PATTERN);
		matcher = pattern.matcher(editText.getText().toString().trim());
		return !matcher.matches();

	}

	public static boolean isConfirPassWord(EditText edtPassword,
                                           EditText edtConfirPassword) {
		return edtPassword.getText().toString().trim()
				.equals(edtConfirPassword.getText().toString().trim());
	}



	public static boolean isContactNo(EditText editText)
	{
		if (editText.getText().toString().length() != 0
				&& editText.getText().toString().length() != 10) {
			return true;
		}
		return editText.getText().toString().length() > 10;
	}

	public static boolean isWebsite(EditText editText){

			try {
				new URL(editText.getText().toString().trim()).toURI();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return true;
			}
	}
}
