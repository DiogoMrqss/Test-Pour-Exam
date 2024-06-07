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
}
