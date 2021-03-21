import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {

	static List<String> result = new ArrayList<String>();

	public static void main(String[] args) {
		ArrayList<String> log = new ArrayList<>();

		String s = "|zabi|123||||||||||";
		String s1 = "|zabi|123||||||||||";
		log.add(s);

		List<String> list = new ArrayList<>();

		list = log.stream().filter(x -> x.contains("|123|")).collect(Collectors.toList());

		for (String l : list) {
			String temp[] = l.split("\\|");
			ArrayList<String> lii = new ArrayList<>(Arrays.asList(temp));
			result.addAll(lii);

		}

		for (String ss : result)
			System.out.println(ss);

		System.out.println(result.size());
		
		System.out.println("Value is NUll " + result.get(12).equals(""));
	}

}
