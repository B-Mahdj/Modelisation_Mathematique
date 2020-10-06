package com.company;

public class SEIR {

    /*---------------------------------------Declaration des variables---------------------------------------*/
    private int population;
    private double sains;
    private double exposes;   //contamines pas infectieux
    private double infectes;
    private double retires;   //gueris non contaminables

    private double beta;      //taux d'infection (en 1 jour)
    private double gamma;     //taux de guerison (en 1 jour)
    private double alpha;     //taux d'incubation (en 1 jour)
    private double v;         //taux de natalite (en 1 jour)
    private double mu;        //taux de mortalite non dû à la maladie (en 1 jour)

    /*---------------------------------------Declaration du constructeur---------------------------------------*/
    public SEIR(int P, double R0, double Temps_Infectieux, double natalite, double temps_incubation, double mortalite) {
        this.population = P;

        this.beta = R0*(1/Temps_Infectieux);
        this.gamma = 1/Temps_Infectieux;
        this.v = natalite;
        this.alpha = 1/temps_incubation;
        this.mu = mortalite;

        this.sains = P;
        this.exposes = 0;
        this.infectes = 0;
        this.retires = 0;
    }

    /*---------------------------------------Declaration des methodes---------------------------------------*/
    public boolean Modifier_Populations (double Sains, double Exposes, double Infectes, double Retires) {
        if (Sains + Exposes + Infectes + Retires != population) {
            System.out.println("mauvais paramètres : veuillez les modifier.");
            return false;
        }
        else {
            this.sains = Sains;
            this.exposes = Exposes;
            this.infectes = Infectes;
            this.retires = Retires;
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
        return infectes + alpha*exposes - gamma*infectes - mu*infectes;
    }

    private double Calculer_Retires () {   //calcule l'evolution de la population retiree sur une journee
        return retires + (gamma*infectes) - mu*retires;
    }

    public void Calcul_Total () {       //calcule l'evolution de la population generale sur une journee
        double SA = Calculer_Sains();
        double EX = Calculer_Exposes();
        double IN = Calculer_Infectes();
        double RE = Calculer_Retires();
        sains = SA;
        exposes = EX;
        infectes = IN;
        retires = RE;
    }

    public String toString() {
        String S = "Sains : " + sains + " Exposes : " + exposes + " Infectes : " + infectes + " Retires : " + retires;
        return S;
    }

}
