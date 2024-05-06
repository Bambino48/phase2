import java.time.LocalDateTime;
import java.util.ArrayList;

public class Salaire {


    public static void main(String[] args) {
        Personnel p = new Personnel();
        p.ajouterEmploye(new Employer.Commerciale.Vendeur("Kouassi", "Business", 45, LocalDateTime.now(), 30000));
        p.ajouterEmploye(new Employer.Commerciale.Representant("Balo", "Vendtout", 25, LocalDateTime.now(), 20000));
        p.ajouterEmploye(new Employer.Producteur("Yves", "Bosseur", 28, LocalDateTime.now(), 1000));
        p.ajouterEmploye(new Employer.Manutentionnaire("Mélanie", "Stocketout", 32, LocalDateTime.now(), 45));
        p.ajouterEmploye(new Employer.Producteur.ProducteurRisque("Eman", "Flippe", 28, LocalDateTime.now(), 1000));
        p.ajouterEmploye(new Employer.Manutentionnaire.ManutentionnaireRisque("Cris", "Abordage", 30, LocalDateTime.now(), 45));

        p.afficherSalaires();
        System.out.println("Le salaire moyen dans l'entreprise est de " + p.salaireMoyen() + " francs.");
    }

    //----------------------------------------------------------------------------------------------------------------------
// Creation de la classe Employer
    abstract static class Employer {
        // Declaration des variables
        private String nom;
        private String prenom;
        private int age;
        private LocalDateTime dateEntrerService;

        // Constructeur par defaut
        public Employer() {
        }

        // Constructeur avec parametre
        public Employer(String nom, String prenom, int age, LocalDateTime dateEntrerService) {
            this.nom = nom;
            this.prenom = prenom;
            this.age = age;
            this.dateEntrerService = dateEntrerService;
        }

        // Les accesseurs et les mutateurs
        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public LocalDateTime getDateEntrerService() {
            return dateEntrerService;
        }

        public void setDateEntrerService(LocalDateTime dateEntrerService) {
            this.dateEntrerService = dateEntrerService;
        }

        // La methode permettant d'afficher le nom et le prenom de l'employer
        public String afficherNomPrenom() {
            return getNom() + " " + getPrenom();
        }

        // La methode permettant le calcul de salaire
        abstract double calculerSalaire();

//-------------------------------Classes heritieres-----------------------------------------

        // Creation de la classe Commerciale heritant de la classe employer
        public static class Commerciale extends Employer {

            // Declaration de la variable
            private double chiffreAffaire;

            public Commerciale(String nom, String prenom, int age, LocalDateTime dateEntrerService, double chiffreAffaire) {
                super(nom, prenom, age, dateEntrerService);
                this.chiffreAffaire = chiffreAffaire;
            }

            public double chiffreAffaire() {
                return chiffreAffaire;
            }

            public double getChiffreAffaire() {
                return chiffreAffaire;
            }

            public void setChiffreAffaire(double chiffreAffaire) {
                this.chiffreAffaire = chiffreAffaire;
            }

            /**
             * @return
             */
            @Override
            double calculerSalaire() {

                return 0;
            }

            // Creation de la classe representant heritant de la classe commerciale
            public static class Representant extends Commerciale {

                private static final double POURCENTAGE_REPRESENTANT = 0.20;
                private final double BONUS_REPRESENTANT = 800.0;

                public Representant(String nom, String prenom, int age, LocalDateTime dateEntrerService, double chiffreAffaire) {
                    super(nom, prenom, age, dateEntrerService, chiffreAffaire);
                }

                /**
                 * @return
                 */
                @Override
                double calculerSalaire() {
                    return ((POURCENTAGE_REPRESENTANT * getChiffreAffaire()) + BONUS_REPRESENTANT);
                }

                /**
                 * @return
                 */
                @Override
                public String afficherNomPrenom() {
                    return ("Le représentant : " + super.afficherNomPrenom());
                }
            }

            // Creation de la classe representant heritant de la classe commerciale
            public static class Vendeur extends Commerciale {

                private static final double POURCENTAGE_VENDEUR = 0.20;
                private final double BONUS_VENDEUR = 400.0;

                public Vendeur(String nom, String prenom, int age, LocalDateTime dateEntrerService, double chiffreAffaire) {
                    super(nom, prenom, age, dateEntrerService, chiffreAffaire);
                }

                /**
                 * @return
                 */
                @Override
                double calculerSalaire() {
                    return ((POURCENTAGE_VENDEUR * getChiffreAffaire()) + BONUS_VENDEUR);
                }

                /**
                 * @return
                 */
                @Override
                public String afficherNomPrenom() {
                    return ("Le vendeur : " + super.afficherNomPrenom());
                }
            }
        }

        // Creation de la classe Producteur heritant de la classe employer
        public static class Producteur extends Employer {

            private static double nombreUnites = 0;
            private static final double COEFFICIENT_UNITE = 5;

            public Producteur(String nom, String prenom, int age, LocalDateTime dateEntrerService, double nombreUnites) {
                super(nom, prenom, age, dateEntrerService);
                this.nombreUnites = nombreUnites;
            }

            /**
             * @return
             */
            @Override
            double calculerSalaire() {
                return (nombreUnites * COEFFICIENT_UNITE);
            }

            /**
             * @return
             */
            @Override
            public String afficherNomPrenom() {
                return ("Le producteur : " + super.afficherNomPrenom());
            }

            // Creation de la classe ProducteurRisque heritant de producteur et implementant PRIME
            public static class ProducteurRisque extends Producteur implements PrimeDeRisque {

                public ProducteurRisque(String nom, String prenom, int age, LocalDateTime dateEntrerService, double nombreUnites) {
                    super(nom, prenom, age, dateEntrerService, nombreUnites);
                }

                /**
                 * @return
                 */
                @Override
                double calculerSalaire() {
                    return ((nombreUnites * COEFFICIENT_UNITE) + PRIME);
                }


            }
        }

        // Creation de la classe Manutentionnaire heritant de la classe Employer
        public static class Manutentionnaire extends Employer {
            public final double nombreHeure;
            public final double COEFFICIENT = 65;

            public Manutentionnaire(String nom, String prenom, int age, LocalDateTime dateEntrerService, double nombreHeure) {
                super(nom, prenom, age, dateEntrerService);
                this.nombreHeure = nombreHeure;
            }

            /**
             * @return
             */
            @Override
            double calculerSalaire() {
                return (nombreHeure * COEFFICIENT);
            }

            /**
             * @return
             */
            @Override
            public String afficherNomPrenom() {
                return ("le manutentionnaire " + super.afficherNomPrenom());
            }

            // Creation de la classe manutentionRisque heritant de la classe  Manutention et implementant PrimeDeRisque
            public static class ManutentionnaireRisque extends Manutentionnaire implements PrimeDeRisque {

                public ManutentionnaireRisque(String nom, String prenom, int age, LocalDateTime dateEntrerService, double nombreHeure) {
                    super(nom, prenom, age, dateEntrerService, nombreHeure);
                }

                /**
                 * @return
                 */
                @Override
                double calculerSalaire() {
                    return ((nombreHeure * COEFFICIENT) + PRIME);
                }


            }

        }

        interface PrimeDeRisque {
            double PRIME = 200;
        }

    }

    static class Personnel {
        final static int MAX_EMPLOYE = 100;
        private int nbreEmployes;
        private final ArrayList<Employer> collectionEmployes;

        public Personnel() {
            collectionEmployes = new ArrayList<Employer>();
            nbreEmployes = 0;
        }

        public void ajouterEmploye(Employer emp) {
            if (collectionEmployes.size() < MAX_EMPLOYE) {
                collectionEmployes.add(emp);
                nbreEmployes++;
            } else {
                System.out.println("Désolé, nombre max d'employés atteint !");
            }

        }

        public void afficherSalaires() {
            // Parcours tout les employés et affiche le salaire de chacun
            for (Employer employe : collectionEmployes) {
                System.out.println(employe.afficherNomPrenom() + " gagne " + employe.calculerSalaire() + " francs.");
            }
        }

        public double salaireMoyen() {
            double somSalaire = 0;
            // Parcours tout les employés et on additionne leurq salaires moyen
            for (Employer employe : collectionEmployes) {
                somSalaire += employe.calculerSalaire();
            }

            return (collectionEmployes.size() > 0 ? somSalaire / collectionEmployes.size() : 0);

        }



    }
}

