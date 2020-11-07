package com.swissre;

/**
 * StringCalc class to add the digits in the given string and other utility methods
 * 
 * @author Deva
 * 
 *
 */
public class StringCalc {
	
	private static final String DELIM_COMMA = ",";
	private static final String DELIM_SPACE = " ";
	
	/**
	 * Method to add the numbers in given string based on different delimiters
	 * 
	 * @param input string with delimiters
	 * @return 	addition of digits in given input
	 */
	public static String addNumbers(String input){
		
		//If input is null or empty return 0
		if(isNullOrEmpty(input)) return "0";
		
		String[] numbers = split(input);
		int res = 0;
		for(String num : numbers) {
			try {
				int val = 0;
				if(!isNullOrEmpty(num)) {
					val = isNum(num);
					if(isNegative(val)) 
						throw new NegativeNumbersNotSupportedException("input is negative number");
					else if(!isBigNum(val)) 
						res = res + val;
				}
			}
			catch(NegativeNumbersNotSupportedException | NotANumberException e) {
				return "One of the " + e.getMessage();
			}
		}
		return res + "";
	}
	
	/**
	 * Method to split the given input based on delimiters comma and space
	 * 
	 * @param	input string that needs to be split
	 * @return	string array based on delimiters
	 */
	public static String[] split(String input) {
		if(input.contains(DELIM_COMMA)) 
			return input.split(DELIM_COMMA);
		else 
			return input.split(DELIM_SPACE);
	}
	
	/**
	 * Method to check if given input is null or empty string
	 * 
	 * @param	input string to be checked for null or empty 
	 * @return	boolean based on input string
	 */
	public static boolean isNullOrEmpty(String input) {
		return null == input || input.trim().length() == 0;
	}
	
	/**
	 * Method to check if given input is negative
	 * 
	 * @param	the	integer number that need to be checked
	 * @return	boolean value based on given input
	 */
	public static boolean isNegative(int num) {
		return num < 0;
	}
	
	/**
	 * Method to check if given input is greater than 100
	 * 
	 * @param	the integer number that need to be checked
	 * @return 	boolean value based on given input
	 */
	public static boolean isBigNum(int num) {
		return num > 100;
	}
	

	/**
	 * Method to convert string to integer
	 * 
	 * @param	input string needs to be converted to integer
	 * @return 	integer value
	 * @throws	NotANumberException 
	 */
	public static int isNum(String num) throws NotANumberException {
		try {
			return (Integer.parseInt(num.trim()));
		}
		catch(NumberFormatException e) {
			throw new NotANumberException("input is not a number");
		}
	}

}
