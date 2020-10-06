package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Interface extends JFrame implements ActionListener {

    private JLabel Titre;
    private JPanel Panel;
    private JButton bouton_SIR;
    private JButton bouton_SEIR;
    private JButton bouton_SEIRD;

    public Interface() {

        add(Panel);
        setTitle("Modelisation epidemique");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bouton_SIR.addActionListener(this::Click_SIR);
        bouton_SEIR.addActionListener(this::Click_SEIR);
        bouton_SEIRD.addActionListener(this::Click_SEIRD);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void Click_SIR (ActionEvent e) {
        System.out.println("SIR");
        //remove(Panel);
        setVisible(false);
    }

    public void Click_SEIR (ActionEvent e) {
        System.out.println("SEIR");
        bouton_SEIRD.setVisible(false);
    }

    public void Click_SEIRD (ActionEvent e) {
        System.out.println("SEIRD");
        //remove(Panel);
    }
}
