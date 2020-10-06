package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {


        // TESTER AVEC D'AUTRES PARAMETRES

	    SIR test_SIR = new SIR(65309421 , 1.8, 14);
	    if (test_SIR.Modifier_Populations(64798590, 415405, 95426)) {
            for (int i = 0; i < 7; i++) {
                test_SIR.Calcul_Total();
                System.out.println(test_SIR);
            }
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------");

	    SEIR test_SEIR = new SEIR(15000, 1.5, 10, 0.5, 7, 0.1);
	    if (test_SEIR.Modifier_Populations(14800, 0, 200, 0)) {
            for (int i = 0; i < 20; i++) {
                test_SEIR.Calcul_Total();
                System.out.println(test_SEIR);
            }
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------");

        SEIRD test_SEIRD = new SEIRD(15000, 1.5, 10,0.5,7,0.1,0.1);
        if (test_SEIRD.Modifier_Populations(14800, 0, 200, 0, 0)) {
            for (int i = 0; i < 20; i++) {
                test_SEIRD.Calcul_Total();
                System.out.println(test_SEIRD);
            }
        }

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        Interface myInterface = new Interface();
        myInterface.setVisible(true);



    }
}
