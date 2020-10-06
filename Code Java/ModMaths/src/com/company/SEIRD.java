package com.company;

public class SEIRD {

    /*---------------------------------------Declaration des variables---------------------------------------*/
    private int population;
    private double sains;
    private double exposes;   //contamines pas infectieux
    private double infectes;
    private double retires;   //gueris non contaminables
    private double morts;     //morts de la maladie

    private double beta;      //taux d'infection (en 1 jour)
    private double gamma;     //taux de guerison (en 1 jour)
    private double alpha;     //taux d'incubation (en 1 jour)
    private double v;         //taux de natalite (en 1 jour)
    private double mu;        //taux de mortalite non dû à la maladie (en 1 jour)
    private double mortalite; //taux de mortalite de la maladie

    /*---------------------------------------Declaration du constructeur---------------------------------------*/

    public SEIRD (int P, double R0, double Temps_Infectieux, double natalite, double temps_incubation, double mortalite, double mortalite_virus) {
        this.population = P;

        this.beta = R0*(1/Temps_Infectieux);
        this.gamma = 1/Temps_Infectieux;
        this.v = natalite;
        this.alpha = 1/temps_incubation;
        this.mu = mortalite;
        this.mortalite = mortalite_virus;

        this.sains = P;
        this.exposes = 0;
        this.infectes = 0;
        this.retires = 0;
        this.morts = 0;
    }

    /*---------------------------------------Declaration des methodes---------------------------------------*/
    public boolean Modifier_Populations (double Sains, double Exposes, double Infectes, double Retires, double Morts) {
        if (Sains + Exposes + Infectes + Retires + morts != population) {
            System.out.println("mauvais paramètres : veuillez les modifier.");
            return false;
        }
        else {
            this.sains = Sains;
            this.exposes = Exposes;
            this.infectes = Infectes;
            this.retires = Retires;
            this.morts = Morts;
            return true;
        }

    }

    private double Calculer_Sains () {  //calcule l'evolution de la population saine sur une journee
        return sains + ((-1*beta*sains*infectes)/population) + v*population - mu*sains;
    }

    private double Calculer_Exposes () {  //calcule l'evolution de la population exposee sur une journee
        return exposes + ((beta*sains*infectes)/population) - alpha*exposes - mu*exposes;
    }

    private double Calculer_Infectes () {   //calcule l'evolution de la population infectee sur une journee
        return infectes + alpha*exposes - gamma*infectes - mortalite*infectes - mu*infectes;
    }

    private double Calculer_Retires () {   //calcule l'evolution de la population retiree sur une journee
        return retires + (gamma*infectes) - mu*retires;
    }

    private double Calculer_Morts () {      //calcule l'evolution de la population morte sur une journee
        return morts + (mortalite*infectes);
    }

    public void Calcul_Total () {    //calcule l'evolution de la population generale sur une journee
        double SA = Calculer_Sains();
        double EX = Calculer_Exposes();
        double IN = Calculer_Infectes();
        double RE = Calculer_Retires();
        double MO = Calculer_Morts();
        sains = SA;
        exposes = EX;
        infectes = IN;
        retires = RE;
        morts = MO;
    }

    public String toString() {
        String S = "Sains : " + sains + " Exposes : " + exposes + " Infectes : " + infectes + " Retires : " + retires + " Morts : " + morts;
        return S;
    }
}
