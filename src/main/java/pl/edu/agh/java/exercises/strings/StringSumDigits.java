package pl.edu.agh.java.exercises.strings;

/**
 * Given a string, return the sum of the digits 0-9 that appear in the string, ignoring all other characters. Return 0
 * if there are no digits in the string.
 * Note:
 * Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'.
 * Integer.parseInt(string) converts a string to an int.
 * <p>
 * Dla danego ciągu znaków zwróć sumę cyfr 0-9, które w nim wystąpią. Zwróć 0 jeśli ciąg znaków nie zawiera żadnych cyfr.
 * Warto wiedzieć:
 * Character.isDigit(char) sprawdza czy dany znak jest jednym ze znaków '0', '1', .. '9'.
 * Integer.parseInt(string) konwertuje string to liczby całkowitej.
 *
 * @see http://codingbat.com/prob/p197890
 */
public class StringSumDigits {
    public int sumDigits(String str) {
        int suma=0;
    	for (int i=0;i<str.length();i++) {
        	char l=str.charAt(i);
    		if (Character.isDigit(l)) suma+=Integer.parseInt(Character.toString(l));
        }
    	return suma;
    }
}
