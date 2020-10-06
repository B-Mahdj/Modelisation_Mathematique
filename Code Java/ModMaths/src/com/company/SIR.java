
package com.company;

import java.io.IOException;

public class SIR {

    /*---------------------------------------Declaration des variables---------------------------------------*/
    private int population;
    private double sains;
    private double infectes;
    private double retires;   //gueris non contaminables
    private double beta;      //taux d'infection (en 1 jour)
    private double gamma;     //taux de guerison (en 1 jour)

    /*---------------------------------------Declaration du constructeur---------------------------------------*/
    public SIR(int P, double R0, double Temps_Infectieux) {
        this.population = P;
        this.beta = R0*(1/Temps_Infectieux);
        this.gamma = 1/Temps_Infectieux;
        this.sains = P;
        this.infectes = 0;
        this.retires = 0;
    }

    /*---------------------------------------Declaration des methodes---------------------------------------*/
    public boolean Modifier_Populations (double Sains, double Infectes, double Retires) {


        if (Sains + Infectes + Retires != population) {        // si la population que l'utilisateur met ne respecte pas la population qu'il a mis precedemment

            System.out.println("mauvais paramètres : veuillez les modifier.");
            return false;
        }


        else {              // si la population que l'utilisateur met respecte la population qu'il a mis precedemment
            this.sains = Sains;
            this.infectes = Infectes;
            this.retires = Retires;
            return true;
        }

    }

    private double Calculer_Sains () {  //calcule l'evolution de la population saine sur une journee
        return sains + ((-1*beta*sains*infectes)/population);
    }

    private double Calculer_Infectes () { //calcule l'evolution de la population infectee sur une journee
        return infectes + ((beta*sains*infectes)/population) - gamma*infectes;
    }

    private double Calculer_Retires () {   //calcule l'evolution de la population retiree sur une journee
        return retires + (gamma*infectes);
    }

    public void Calcul_Total () {     //calcule l'evolution de la population generale sur une journee
        double SA = Calculer_Sains();
        double IN = Calculer_Infectes();
        double RE = Calculer_Retires();
        sains = SA;
        infectes = IN;
        retires = RE;
    }

    public String toString() {
        String S = "Sains : " + sains + " Infectes : " + infectes + " Retires : " + retires;
        return S;
    }
}
