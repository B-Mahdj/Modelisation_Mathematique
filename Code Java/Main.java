package com.company;

public class Main {

    public static void main(String[] args) {


        // TESTER AVEC D'AUTRES PARAMETRES

	    SIR test = new SIR(65309421 , 0.08, 14);
	    if (test.Modifier_Populations(64798590, 415405, 95426)==true) {
            for (int i = 0; i < 7; i++) {
                test.Calcul_Total();
            }
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------");

	    SEIR test2 = new SEIR(15, 0.5, 10, 0.00, 0.2, 0.00);
	    if (test2.Modifier_Populations(13, 0, 2,0)==true) {
            for (int i = 0; i < 50; i++) {
                test2.Calcul_Total();
            }
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------");
    }
}
