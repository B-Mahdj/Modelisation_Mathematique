
package com.company;

public class SIR {

    /*---------------------------------------Déclaration des variables---------------------------------------*/
    private int population;
    private double sains;
    private double infectes;
    private double retires;
    private double beta;
    private double gamma;

    /*---------------------------------------Déclaration du constructeur---------------------------------------*/
    public SIR(int P, double B, double Temps_Infectieux) {
        this.population = P;
        this.beta = B;
        this.gamma = 1/Temps_Infectieux;
        this.sains = P;
        this.infectes = 0;
        this.retires = 0;
    }

    /*---------------------------------------Déclaration des méthodes---------------------------------------*/
    public boolean Modifier_Populations (double Sains, double Infectes, double Retires) {
        if (Sains + Infectes + Retires != population) {
            System.out.println("mauvais paramètres : veuillez les modifier.");
            return false;
        }
        else {
            this.sains = Sains;
            this.infectes = Infectes;
            this.retires = Retires;
            return true;
        }

    }

    private double Calculer_Sains () {
        return sains + ((-1*beta*sains*infectes)/population);
    }

    private double Calculer_Infectes () {
        return infectes + ((beta*sains*infectes)/population) - gamma*infectes;
    }

    private double Calculer_Retires () {
        return retires + (gamma*infectes);
    }

    public void Calcul_Total () {
        double SA = Calculer_Sains();
        double IN = Calculer_Infectes();
        double RE = Calculer_Retires();
        sains = SA;
        infectes = IN;
        retires = RE;

        //System.out.println("Sains : " + Math.round(sains) + " Infectés : " + Math.round(infectes) + " Retirés : " + Math.round(retires));
        System.out.println("Sains : " + sains + " Infectés : " + infectes + " Retirés : " + retires);
        //System.out.println("----------------------------------------------------------");
    }
}
