import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ArrayMixed{

	public static void main(String[] args) {
		// JOIN
		System.out.println("[Test join]");
		System.out.printf("\"%s\" (erwartet: \"%s\")%n%n", join(";", new String[]{"A", "B", "Horst"}), "A;B;Horst");

		// Split
		System.out.println("[Test split]");
		System.out.printf("\"%s\" (erwartet: \"%s\")%n%n", join(", ", split(";", "A;B;Horst")), "A, B, Horst");

		// sortByLength
		System.out.println("[Test sortByLength]");
		String[] sortArr = new String[]{"A", "BBBBB", "AAA", "BBBB"};
		sortByLength(sortArr);
		System.out.printf("\"%s\" (erwartet: \"%s\")%n%n", join(", ", sortArr), "A, AAA, BBBB, BBBBB");

		// sortByOcc
		System.out.println("[Test sortByOcc]");
		String[] sortArrOcc = new String[]{"AC", "AAAAAC", "AAAAAA", "AACCCC", "CC", "CCCA"};
		sortByOcc('C', sortArrOcc);
		System.out.printf("\"%s\" (erwartet: \"%s\")%n%n", join(", ", sortArrOcc), "AAAAAA, AC, AAAAAC, CC, CCCA, AACCCC");


		// sortByOcc
		System.out.println("[Test joinReverse]");
		String res = joinReverse(" ", "Das Wetter ist schön");
		System.out.printf("\"%s\" (erwartet: \"%s\")%n%n", res, "schön ist Wetter Das");
	}

	public static String join(String delim, String[] array) {
		StringBuilder result = new StringBuilder();

		for (String str : array) {
			result.append(str).append(delim);
		}

		return result.substring(0, result.length()-delim.length()).toString();
	}

	public static String[] split(String delim, String str) {
		ArrayList<String> result = new ArrayList<String>();

		int index = str.indexOf(delim);
		while(index != -1) {

			result.add(str.substring(0, index));
			str = str.substring(index+1);
			index = str.indexOf(delim);
		}

		result.add(str);

		String[] r = new String[result.size()];
		r = result.toArray(r);
		return r;
	}

	public static void sortByLength(String[] array) {
		Arrays.sort(array, new Comparator<String>() {
			public int compare(String a, String b) {
				return  a.length() - b.length();
			}
		});
	}

	public static int count(char c, String str) {
		int cnt = 0;

		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c) {
				cnt++;
			}
		}

		return cnt;
	}

	public static void sortByOcc(char c, String[] array) {
		Arrays.sort(array, new Comparator<String>() {
			public int compare(String a, String b) {
				return count(c, a) - count(c, b);
			}
		});
	}

	public static String joinReverse(String c, String str) {
		String[] res = split(c, str);
		for(int i = 0; i < res.length / 2; i++) {
			String temp = res[i];
			res[i] = res[res.length - i - 1];
			res[res.length - i - 1] = temp;
		}

		return join(c, res);
	}

}