import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {
	
		String input1="aaaabbbb";
		String input2="ab";
		
		boolean hasSameC = hasSameChar(input1,input2);
		System.out.println(hasSameC);
	}

	private static boolean hasSameChar(String input1, String input2) {
		Map<Character,Integer> map=new HashMap<>();
		
		for(char c:input1.toCharArray()) {
			if(!map.containsKey(c)) {
				map.put(c, 1);
			}
		}
		
		for(char c:input2.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, -1);
			}else {
				return false;
			}
		}
		for(Map.Entry<Character, Integer> e:map.entrySet()) {
			if(e.getValue()!=-1) {
				return false;
			}
		}
		return true;
	}
	
	
}