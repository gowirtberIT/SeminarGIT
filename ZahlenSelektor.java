import java.util.Arrays;

@FunctionalInterface

public interface ZahlenSelektor {
	
	public boolean pruefe(int zahl);
	
	public static int[] findeErsteN(ZahlenSelektor selektor, int n) {
		if (n < 0 || selektor == null){
		throw new IllegalArgumentException(
		"Selektor darf nicht null und n nicht <0 sein.");
		}
		int[] ergebnis = new int[n];
		int index = 0;
		for (int i = 1; i <= 1000000 && index < n; i++){
		if (selektor.pruefe(i)){
		ergebnis[index++] = i;
		}
		}
		if (index < ergebnis.length){
		ergebnis = Arrays.copyOf(ergebnis, index);
		}
		return ergebnis;
	}
}


