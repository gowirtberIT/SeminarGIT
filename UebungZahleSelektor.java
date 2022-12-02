public abstract class UebungZahleSelektor implements ZahlenSelektor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ZahlenSelektor.findeErsteN(zahl -> true, 10);
		ZahlenSelektor.findeErsteN(zahl -> zahl % 7 == 0, 10);

	}

}
