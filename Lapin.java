public class Lapin {
    private String nom;
    private String typeChocolat ;
    private boolean garni;
    private Coord position;
    private double poids;

    public Lapin(String nom, String typeChocolat, boolean garni, Coord position, double poids) {
        this.nom = nom;
        this.typeChocolat = typeChocolat;
        this.garni = garni;
        this.position = position;
        this.poids = poids;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Lapin{" +
                "nom='" + nom + '\'' +
                ", typeChocolat='" + typeChocolat + '\'' +
                ", garni=" + garni +
                ", position=" + position +
                ", poids=" + poids +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTypeChocolat() {
        return typeChocolat;
    }

    public void setTypeChocolat(String typeChocolat) {
        this.typeChocolat = typeChocolat;
    }

    public boolean isGarni() {
        return garni;
    }

    public void setGarni(boolean garni) {
        this.garni = garni;
    }

    public Coord getPosition() {
        return position;
    }

    public void setPosition(Coord position) {
        this.position = position;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }
}
