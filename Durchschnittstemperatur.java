import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Durchschnittstemperatur {

	public static void main(String[] args) throws IOException {
		
//		if (args.length != 1) {
//			System.err.println("Bitte übergeben Sie einen Dateinamen");
//            System.exit(1);
//		}
		String dateiname = "C:\\Users\\HaraldGottfried\\eclipse-workspace\\SeminarJava\\src\\temperaturdaten.csv";
		findeHeissestenMonat(dateiname);
		findeHeissestesJahr(dateiname);
        findeHeissestesJahrUndMonat(dateiname);

	}
private static void findeHeissestenMonat(String dateiname) throws IOException {
	try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
		reader
				.lines()
				.flatMapToDouble(line -> Arrays.stream(line.split("\\s+"))
				.skip(1)
				.mapToDouble(Double::parseDouble))
				.reduce(Math::max)
				.ifPresent(t -> System.out.println("Der heißeste Monat der letzten 50 Jahre hatte " + t + " Grad."));
	}
}
	
	private static void findeHeissestesJahr(String dateiname) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
			reader
			.lines()
			.mapToDouble(line -> Arrays.stream(line.split("\\s+"))
					.skip(1)
					.mapToDouble(Double::parseDouble)
					.average()
					.getAsDouble())
			.reduce(Math::max)
			.ifPresent(t -> System.out.println("Das heißeste Jahr der letzten 50 Jahre hatte im Schnitt " + t + " Grad."));
		}			
	}
	
	private static void findeHeissestesJahrUndMonat(String dateiname) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(dateiname))) {
			erzeugeMonatswertStream(reader)
				.reduce((x,y) -> x.getTemperatur() > y.getTemperatur() ? x : y)
				.ifPresent(t -> System.out.println("Der heißeste Monat der letzten 50 Jahre war " + t.getMonat() + "/" + t.getJahr() + " mit " + t.getTemperatur() + " Grad."));
	}
	
}
	private static Stream<Monatswert> erzeugeMonatswertStream (final BufferedReader reader) {
		return reader.lines()
				.flatMap(zeile -> parseZeile(zeile));
	}
private static Stream<Monatswert> parseZeile(String zeile) throws NumberFormatException {
	String [] spalten = zeile.split("\\s+");
	int jahr = Integer.parseInt(spalten[0]);
	return IntStream
			.rangeClosed(1, 12).mapToObj(i -> new Monatswert(i, jahr,Double.parseDouble(spalten[i])));
}
private static class Monatswert {

    private final int monat;
    private final int jahr;
    private final double temperatur;

    public Monatswert(int monat, int jahr, double temperatur) {
        this.monat = monat;
        this.jahr = jahr;
        this.temperatur = temperatur;
    }

    public int getMonat() {
        return monat;
    }

    public int getJahr() {
        return jahr;
    }

    public double getTemperatur() {
        return temperatur;
    }
}
}
