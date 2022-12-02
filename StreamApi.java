import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StreamApi {

	public static void main(String[] args) {
	
//		String lorem = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
//		var lst = Arrays.asList(lorem.split(" "));
//		
//		lst.stream()
//		  .filter(s -> s.length() > 6)
//		  .forEach(s -> System.out.println(s));
//		
//		long n = lst.stream()
//			.filter(s -> s.length() > 6)
//			.distinct()
//			.count();
//			System.out.println(n);
//			
//		OptionalDouble avg = lst.stream()
//			.mapToInt(s -> s.length())
//			.average();
//		System.out.println(avg.getAsDouble());
//		
//		var zahlen = new ArrayList<Integer>();
//		for (int i=1; i<10; i++)
//			zahlen.add(i);
//		
//		zahlen.stream().map(i -> i*i).forEach(System.out::println);
//		
//		Optional<Integer> summe = zahlen.stream().reduce((i1,i2) -> i1+i2);
//		System.out.println(summe.get());
//		Optional<Integer> summe1 = zahlen.stream().reduce((i1,i2) -> i1*i2);
//		System.out.println(summe1.get());
		
//		Stream.iterate(BigInteger.ONE, i -> i.multiply(BigInteger.TWO))
//				.limit(1000)
//				.forEach(System.out::println);
		
//		Stream.generate(new Supplier() {
//			BigInteger vor1 = BigInteger.ZERO, vor2 = BigInteger.ONE;
//			@Override
//			public Object get() {
//				BigInteger zahl = vor1.add(vor2);
//				vor1 = vor2;
//				vor2 = zahl;
//				return zahl;
//				}
//			}).limit(100).forEach(System.out::println);	
//		
		final class Paar<T> {
			private final T erste, zweite;
			private Paar(T erste, T zweite) {
				this.erste = erste;
				this.zweite = zweite;
			}
			public T getErste() {
				return erste;
			}
			public T getZweite() {
					return zweite;	
			}
		}
	}
	private static void fibonacciLambda() {
		Stream.iterate(new Paar<BigInteger>(ZERO, ONE),
				p -> new Paar<>(p.getZweite(), p.getErste().add(p.getZweite())))
					.map(Paar::getErste)
					.limit(100)
					.forEach(System.out::println);
			
			
		
		{
			
		}
		
		
//		IntStream.rangeClosed(0, 1000000)
//			.filter(i -> i % 3 == 0)
//			.forEach(System.out::println);

		
	}

}
