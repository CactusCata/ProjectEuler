package fr.cactuscata.projecteuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Helper {

	public static boolean numberIsPrime(long num) {
		for (int i = 2; i <= num / 2; ++i)
			if (num % i == 0) return false;
		return true;
	}

	public static String reverseString(String str) {
		StringBuilder builder = new StringBuilder();
		for (int i = str.length() - 1; i > -1; i--) {
			builder.append(str.charAt(i));
		}
		return builder.toString();
	}

	public static int getNumberOfCharacter(String str, char c) {
		int amount = 0;
		for (char cs : str.toCharArray())
			if (cs == c) amount++;
		return amount;
	}

	public static String addCharacterBefore(char c, int amount, String sentance) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < amount; i++)
			builder.append(c);
		return builder.append(sentance).toString();
	}

	public static BigInteger factoriel(int x) {
		BigInteger f = new BigInteger("1");
		for (int i = 1; i < x + 1; i++) {
			f.multiply(new BigInteger(String.valueOf(i)));
			System.out.println(f);
		}
		return f;
	}

	public static List<Integer> listOfPrimeNumber(int number) {
		List<Integer> primeNumber = new ArrayList<>();
		for (int i = 2; number != 1; i++) {
			while (number % i == 0) {
				primeNumber.add(i);
				number /= i;
			}
		}
		return primeNumber;
	}

}
