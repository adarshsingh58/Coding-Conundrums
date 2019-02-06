import java.util.HashMap;
import java.util.Map;

public class Test {

	protected void hello(Number n) {
		System.out.println("Super hello");
	}

}

class child extends Test {
	public void hello(Number n) {
		System.out.println("Super hello");
	}
	
}
