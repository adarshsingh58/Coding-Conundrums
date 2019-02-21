import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {
	private static List<Kingdom> allies = new ArrayList<>();
	private static List<String> inputList = new ArrayList<>();

	public static void main(String[] args) {
		printOutput();

		provideInput();
		for (String s : inputList) {
			String[] message = s.split(", ");
			messageFromShanTo(Kingdom.valueOf(message[0]), message[1]);
		}
		printOutput();
	}

	private static void provideInput() {
		System.out.println("Enter Number of inputs");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println("Input Messages to kingdoms from King Shan:");
		scanner.nextLine();
		for (int i = 0; i < n; i++) {
			inputList.add(scanner.nextLine());
		}
		scanner.close();
	}

	private static void printOutput() {
		System.out.println("Who is the ruler of Southeros?");
		if (allies.size() >= (Kingdom.values().length/2)) {
			System.out.println("King Shan");
		} else {
			System.out.println("None");
		}
		System.out.println("Allies of Ruler?");
		StringBuilder builder=new StringBuilder();
		if (allies.size() >= (Kingdom.values().length/2)) {
			for (Kingdom k : allies) {
				builder.append(k.name() + ", ");
			}
			System.out.print(builder.substring(0, builder.length()-2).toString());
		} else {
			System.out.println("None");
		}
	}

	public static void messageFromShanTo(Kingdom kingdom, String message) {
		if (isRightSecretMessage(kingdom.getEmblem().toLowerCase(), message.toLowerCase())) {
			allies.add(kingdom);
		}
	}

	private static boolean isRightSecretMessage(String emblem, String message) {
		Map<Character, Integer> wordMap = new HashMap<>();
		for (char c : message.toCharArray()) {
			if (wordMap.containsKey(c)) {
				wordMap.put(c, wordMap.get(c) + 1);
			} else {
				wordMap.put(c, 1);
			}
		}

		for (char c : emblem.toCharArray()) {
			if (!wordMap.containsKey(c)) {
				return false;
			} else {
				wordMap.put(c, wordMap.get(c) - 1);
				if (wordMap.get(c) == 0) {
					wordMap.remove(c);
				}
			}
		}
		return true;
	}

}

enum Kingdom {
	Air("Owl"), Land("Panda"), Ice("Mammoth"), Water("Octopus"), Fire("Dragon"), Space("Gorilla");

	private String emblem;

	private Kingdom() {
	}

	Kingdom(String emblem) {
		this.emblem = emblem;
	}

	public String getEmblem() {
		return emblem;
	}

}
