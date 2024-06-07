import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ESIGPaques {

    public static final String[] TAB_CAT_CHOC = {"au lait", "blanc", "noir", "matcha"};
    public static void main(String[] args) {




        ArrayList<Lapin> liste = lireDonnees_Q1_v1("RabbitData.txt");


        for ( Lapin rabbit : liste )
        {
            System.out.println(rabbit);
        }

        System.out.println("Question 2");
        //afficherPoidsMoyens_Q2(liste);
        System.out.println();

        System.out.println("Question 3");
        //Lapin lePlusLourd = lapinLePlusLourd_Q3a(liste);
        //afficherInfoPlusLourd_Q3b(lePlusLourd);
        System.out.println();


        System.out.println("Question 4");

        //liste.get(0).afficherDistanceAvecLesAutres_Q4a(liste);

        //afficherToutesLesDistances_Q4b(liste);
        System.out.println();

    }

    public static ArrayList<Lapin> lireDonnees_Q1_v1( String nomFichier)
    {
        ArrayList<Lapin> liste = new ArrayList<>();
        try {
            Scanner scFile = new Scanner(new File(nomFichier));
            while (scFile.hasNextLine())
            {
                Scanner scLine = new Scanner(scFile.nextLine());

                String nom = scLine.next();


                String typeChocolat = TAB_CAT_CHOC[scLine.nextInt() - 1];
                boolean garni = scLine.next().equals("oui");
                int x = scLine.nextInt();
                int y = scLine.nextInt();
                double poids = scLine.nextInt()/1000.0;

                liste.add(new Lapin(nom, typeChocolat, garni, x, y, poids));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return liste;
    }

    private static void afficherPoidsMoyens_Q2(ArrayList<Lapin> liste)
    {
        HashMap<String, Double> poidsTotal = new HashMap<>();
        HashMap<String, Integer> nbTypeChocolat = new HashMap<>();

        for (int pos = 0; pos < TAB_CAT_CHOC.length; pos++) {
            poidsTotal.put(TAB_CAT_CHOC[pos], 0.0);
            nbTypeChocolat.put(TAB_CAT_CHOC[pos], 0);
        }
        for (Lapin lap: liste) {
            String typeLap = lap.getTypeChocolat();
            double poidsactu = poidsTotal.get(typeLap);
            poidsactu += lap.getPoids();
            poidsTotal.put(typeLap, poidsactu);
            int nbTypeChoc = nbTypeChocolat.get(typeLap);
            nbTypeChocolat.put(typeLap, nbTypeChoc+1);
        }
        for (String typeChocolate : poidsTotal.keySet()) {
            if (nbTypeChocolat.get(typeChocolate) == 0){
                System.out.println("Aucun chocolat de type " + typeChocolate);
            }else {
                double moyenne = poidsTotal.get(typeChocolate) / nbTypeChocolat.get(typeChocolate);
                System.out.println("Moyenne des type " + typeChocolate + " " + moyenne*1000);
            }
        }
    }

    private static Lapin lapinLePlusLourd_Q3a(ArrayList<Lapin> liste) {
        double poidsMax = 0;
        Lapin lapMax = null;
        for (Lapin lap : liste) {
            if (lap.getPoids() > poidsMax) {
                poidsMax = lap.getPoids();
                lapMax = lap;
            }
        }
//        System.out.println(lapMax);
        return lapMax;
    }

    private static void afficherInfoPlusLourd_Q3b(Lapin lePlusLourd)
    {
        System.out.println("Le lapin le plus lourd pèse "+(lePlusLourd.getPoids() * 1000)+" grammes.");
        System.out.println("Il s'appelle "+lePlusLourd.getNom()+" et vous le trouverez en position "+lePlusLourd.getPosition());
    }

    private static void afficherToutesLesDistances_Q4b(ArrayList<Lapin> liste)
    {
        for ( Lapin lap : liste )
        {
            lap.afficherDistanceAvecLesAutres_Q4a(liste);
        }
        System.out.println("---------------------------------CE QUI N'ETAIT PAS DEMANDE----------------------");
        for (int posLapin = 0; posLapin < liste.size()-1; posLapin++ )
        {
            for (int posAutreLapin = posLapin+1; posAutreLapin < liste.size(); posAutreLapin++)
            {
                System.out.println(liste.get(posLapin).getNom()+" - "+liste.get(posAutreLapin).getNom()+" : "+liste.get(posLapin).distanceAvec(liste.get(posAutreLapin)));
            }
        }
    }
}
