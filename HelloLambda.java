import java.util.Arrays;
import java.util.List;

public class HelloLambda {

	public static void main(String[] args) {
		String[] msg = {"Java" , "macht" , "Spaß!"};
		List<String > lst = Arrays.asList(msg);
		lst.forEach(s -> System.out.print(s.toLowerCase() + " "));
	}

}
