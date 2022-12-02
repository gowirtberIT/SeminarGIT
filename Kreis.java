
public class Kreis implements Geometrie {
  private double radius;

  public Kreis(Double radius) {
    setRadius(radius);
  }
  
  // getter/setter für radius
  public double getRadius() {
    return radius;
  }
  public void setRadius(double radius) {
    if(radius<=0)
      throw new IllegalArgumentException(
          "Der Radius muss größer 0 sein!");
    this.radius = radius;
  }
  @Override
  public int compareTo(Geometrie other) {
	  double flaecheThis = this.berechneFlaeche();
	  double flaecheOther = other.berechneFlaeche();
	  	if(flaecheThis == flaecheOther)
	  		return 0;
	  	else if(flaecheThis > flaecheOther)
	  		return 1;
	  	else
	  		return -1;
  }
   
  @Override
  public double berechneUmfang() {
    return 2 * radius * Math.PI;
  }

  @Override
  public double berechneFlaeche() {
    return radius * radius * Math.PI ;
  }
}
