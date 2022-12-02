import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.stream.Stream;

	
    
    
    public class Paar<T>{
        private final T erste, zweite;
        private Paar(T erste, T zweite){
            this.erste = erste;
            this.zweite = zweite;
        }

        public T getErste() {
            return erste;
        }

        public T getZweite() {
            return zweite;
        }
        
        private static void fibonacciLambda() {
            Stream.iterate(new Paar<BigInteger>(ZERO, ONE), 
                    p -> new Paar<>(p.getZweite(), p.getErste().add(p.getZweite())))
            .map(Paar::getErste)
            .limit(100)
            .forEach(System.out::println);

        }
  public static void main(String[] args) {
		// TODO Auto-generated method stub

	 		
  		fibonacciLambda();
    }
  }
