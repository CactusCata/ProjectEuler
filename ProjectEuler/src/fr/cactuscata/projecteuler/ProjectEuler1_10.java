package fr.cactuscata.projecteuler;

import java.util.ArrayList;
import java.util.List;

public class ProjectEuler1_10 {

	public static void main(String[] args) {
		problem1();
	}

	/**
	 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	 * 
	 * Find the sum of all the primes below two million.
	 */
	private static void problem10() {

		long sum = 0;

		for (int i = 2; i < 2 * Math.pow(10, 6); i++) {
			if (Helper.numberIsPrime(i)) {
				sum += i;
				System.out.println(i);
			}
		}

		System.out.println(sum);

	}

	/**
	 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
	 * which, a2 + b2 = c2
	 * 
	 * For example, 32 + 42 = 9 + 16 = 25 = 52.
	 * 
	 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	 * Find the product abc.
	 * 
	 */
	private static void problem9() {

		int max = 10000;

		for (int a = 1; a < max; a++) {
			for (int b = a; b < max; b++) {
				int calcul = a * a + b * b;	
				for (int c = 1; c < max; c++) {
					if (calcul == c * c && a + b + c == 1000) {
						System.out.println(a * b * c);
					}
				}
			}
		}
	}

	/**
	 * The four adjacent digits in the 1000-digit number that have the greatest
	 * product are 9 × 9 × 8 × 9 = 5832. *
	 * 
	 * Find the thirteen adjacent digits in the 1000-digit number that have the
	 * greatest product. What is the value of this product?
	 * 
	 */
	private static void problem8() {

		long max = 0;

		String number = "73167176531330624919225119674426574742355349194934" + "96983520312774506326239578318016984801869478851843" + "85861560789112949495459501737958331952853208805511" + "12540698747158523863050715693290963295227443043557" + "66896648950445244523161731856403098711121722383113" + "62229893423380308135336276614282806444486645238749" + "30358907296290491560440772390713810515859307960866" + "70172427121883998797908792274921901699720888093776" + "65727333001053367881220235421809751254540594752243" + "52584907711670556013604839586446706324415722155397" + "53697817977846174064955149290862569321978468622482" + "83972241375657056057490261407972968652414535100474" + "82166370484403199890008895243450658541227588666881" + "16427171479924442928230863465674813919123162824586" + "17866458359124566529476545682848912883142607690042" + "24219022671055626321111109370544217506941658960408" + "07198403850962455444362981230987879927244284909188" + "84580156166097919133875499200524063689912560717606" + "05886116467109405077541002256983155200055935729725" + "71636269561882670428252483600823257530420752963450";

		for (int i = 0; i < number.length() - 13; i++) {
			long sum = 1;
			for (int j = i; j < i + 13; j++) {
				sum *= Integer.valueOf(String.valueOf(number.charAt(j)));
			}
			if (sum > max) max = sum;
		}

		System.out.println(max);

	}

	/**
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can
	 * see that the 6th prime is 13.
	 * 
	 * What is the 10 001st prime number?
	 * 
	 */
	private static void problem7() {

		int count = 0;
		long wanted = 0;

		for (long i = 2; count < 10001; i++) {
			if (Helper.numberIsPrime(i)) {
				count++;
				wanted = i;
			}
		}

		System.out.println(wanted);

	}

	/**
	 * The sum of the squares of the first ten natural numbers is, 12 + 22 + ...
	 * + 102 = 385
	 * 
	 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... +
	 * 10)2 = 552 = 3025
	 * 
	 * Hence the difference between the sum of the squares of the first ten
	 * natural numbers and the square of the sum is 3025 - 385 = 2640.
	 * 
	 * Find the difference between the sum of the squares of the first one
	 * hundred natural numbers and the square of the sum.
	 * 
	 */
	private static void problem6() {

		final int max = 100;
		int sumSquare = 0;
		int squareSum = 0;

		for (int i = 1; i < max + 1; i++) {
			sumSquare += Math.pow(i, 2);
			squareSum += i;
		}

		squareSum = (int) Math.pow(squareSum, 2);

		System.out.println(squareSum - sumSquare);

	}

	/**
	 * 2520 is the smallest number that can be divided by each of the numbers
	 * from 1 to 10 without any remainder.
	 * 
	 * What is the smallest positive number that is evenly divisible by all of
	 * the numbers from 1 to 20?
	 * 
	 */
	private static void problem5() {

		for (long i = 1; true; i++) {
			boolean done = true;

			for (int j = 1; j < 20; j++) {
				if (i % j != 0) {
					done = false;
					break;
				}
			}

			if (done) {
				System.out.println(i);
				break;
			}

		}

	}

	/**
	 * A palindromic number reads the same both ways. The largest palindrome
	 * made from the product of two 2-digit numbers is 9009 = 91 × 99.
	 * 
	 * Find the largest palindrome made from the product of two 3-digit numbers.
	 * 
	 */
	private static void problem4() {

		final int maxLenght = 999;
		int best = 0;

		for (int x = maxLenght; x > 100; x--) {
			for (int y = maxLenght; y > 100; y--) {
				String compact = String.valueOf(x * y);
				if (compact.length() % 2 == 0) {
					String firstPart = compact.substring(0, compact.length() / 2);
					String secondPart = Helper.reverseString(
							compact.substring(compact.length() / 2, compact.length()));
					if (firstPart.equals(secondPart) && best < x * y) best = x * y;
				}
			}
		}

		System.out.println(best);

	}

	/**
	 * 
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 * 
	 * What is the largest prime factor of the number 600851475143 ?
	 * 
	 */
	private static void problem3() {

		final long start = 600851475143L;
		long wanted = start;
		List<Long> factors = new ArrayList<>();

		for (long i = 2; i < wanted; i++) {
			if (wanted % i == 0 && Helper.numberIsPrime(i)) {
				factors.add(i);
				wanted /= i;
			}
		}

		long sum = 1;
		for (long l : factors)
			sum *= l;

		System.out.println(factors);
		System.out.println((float) start / sum);

	}

	/**
	 * 
	 * 
	 * Each new term in the Fibonacci sequence is generated by adding the
	 * previous two terms. By starting with 1 and 2, the first 10 terms will be:
	 * 
	 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
	 * 
	 * By considering the terms in the Fibonacci sequence whose values do not
	 * exceed four million, find the sum of the even-valued terms.
	 * 
	 */
	private static void problem2() {

		int sum = 0;
		int old1 = 2;
		int old2 = 1;

		while (old2 + old1 < 4 * Math.pow(10, 6)) {
			int res = old1 + old2;
			old2 = old1;
			old1 = res;
			if (res % 2 == 0) sum += res;

		}
		System.out.printf("answer: %d", sum + 2);
	}

	/**
	 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
	 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
	 * 
	 * Find the sum of all the multiples of 3 or 5 below 1000.
	 */
	private static void problem1() {

		int sum = 0;

		for (int i = 1; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) sum += i;
		}

		System.out.println(sum);

	}

}
