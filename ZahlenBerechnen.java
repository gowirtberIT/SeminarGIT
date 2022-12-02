import java.util.function.IntUnaryOperator;

public class ZahlenBerechnen {

	public static void main(String[] args) {
		
		ZahlenBerechnen.berechne(new int[] {1,2,3}, i -> 2*i);
		ZahlenBerechnen.berechne(new int[] {1,2,3}, i -> i*i);
		ZahlenBerechnen.berechne(new int[] {-1,2,-3}, Math::abs);
		ZahlenBerechnen.berechne(new int[] {13, 17,94, 166}, i -> {
			int letzteZiffer = i % 10;
			if (letzteZiffer < 0){
			letzteZiffer += 10;
			}
			if (letzteZiffer < 5){
			return i - letzteZiffer;
			} else {
			return i + (10 - letzteZiffer);
			}});
		
	}
	
	public static int[] 
			berechne(int[] eingabe, IntUnaryOperator rechenvorschrift) {
		if ( eingabe == null || rechenvorschrift == null) throw new IllegalArgumentException("Keine null-Werte erlaubt");
		int[] ausgabe = new int[eingabe.length];
		for (int i = 0; i < eingabe.length; i++) {
			ausgabe[i] = rechenvorschrift.applyAsInt(eingabe[i]);
		}
		return ausgabe;
	}

}
