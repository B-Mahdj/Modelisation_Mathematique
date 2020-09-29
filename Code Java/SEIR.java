package com.company;

public class SEIR {

    /*---------------------------------------Déclaration des variables---------------------------------------*/
    private int population;
    private double sains;
    private double exposes;
    private double infectes;
    private double retires;
    private double beta;
    private double gamma;
    private double alpha;
    private double v;
    private double mu;

    /*---------------------------------------Déclaration du constructeur---------------------------------------*/
    public SEIR(int P, double taux_infection, double Temps_Infectieux, double natalite, double taux_incubation, double mortalite) {
        this.population = P;
        this.beta = taux_infection;
        this.gamma = 1/Temps_Infectieux;
        this.v = natalite;
        this.alpha = taux_incubation;
        this.mu = mortalite;
        this.sains = P;
        this.exposes = 0;
        this.infectes = 0;
        this.retires = 0;
    }

    /*---------------------------------------Déclaration des méthodes---------------------------------------*/
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

    private double Calculer_Sains () {
        return sains + ((-1*beta*sains*infectes)/population) + v*population - mu*sains;
    }

    private double Calculer_Exposes () {
        return exposes + ((beta*sains*infectes)/population) - alpha*exposes - mu*exposes;
    }

    private double Calculer_Infectes () {
        return infectes + alpha*exposes - gamma*infectes - mu*infectes;
    }

    private double Calculer_Retires () {
        return retires + (gamma*infectes) - mu*retires;
    }

    public void Calcul_Total () {
        double SA = Calculer_Sains();
        double EX = Calculer_Exposes();
        double IN = Calculer_Infectes();
        double RE = Calculer_Retires();
        sains = SA;
        infectes = IN;
        retires = RE;

        //System.out.println("Sains : " + Math.round(sains) + " Infectés : " + Math.round(infectes) + " Retirés : " + Math.round(retires));
        System.out.println("Sains : " + sains + " Exposés : " + exposes + " Infectés : " + infectes + " Retirés : " + retires);
        //System.out.println("----------------------------------------------------------");
    }

}
