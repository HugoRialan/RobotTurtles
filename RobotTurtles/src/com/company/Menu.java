package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class Menu { //Dans cette classe, on choisit le nombre de joueur et quand on démarre le jeu


    private int nbJoueurs ;
    private JButton bouton2Players = new JButton("2 joueurs");
    private JButton bouton3Players = new JButton("3 joueurs");
    private JButton bouton4Players = new JButton("4 joueurs");
    private JFrame fenetre = new JFrame();

    public Menu(){
    }

    public int getNbJoueurs(){
        return nbJoueurs;
    }



    public void display() { //affiche le menu

        fenetre.setTitle("Ma première fenêtre Java");
        fenetre.setSize(620, 802);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        fenetre.setLocation(dim.width / 4 - fenetre.getWidth() / 2, dim.height / 2 - fenetre.getHeight() / 2);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        JPanelBackroud container = new JPanelBackroud("images/MenuBackground.jpg");
        container.setLayout(null);


        bouton2Players.setBounds(fenetre.getWidth() / 2 - 100, fenetre.getHeight() / 2, 200, 50);
        bouton3Players.setBounds(fenetre.getWidth() / 2 - 100, fenetre.getHeight() / 2 + 100, 200, 50);
        bouton4Players.setBounds(fenetre.getWidth() / 2 - 100 , fenetre.getHeight() / 2 + 200, 200, 50);

        container.add(bouton2Players);
        container.add(bouton3Players);
        container.add(bouton4Players);

        bouton2Players.addActionListener(new Bouton2Listener());
        bouton3Players.addActionListener(new Bouton3Listener());
        bouton4Players.addActionListener(new Bouton4Listener());

        fenetre.setContentPane(container);
        fenetre.setVisible(true);



    }

        class Bouton2Listener implements ActionListener {
            public void actionPerformed(ActionEvent arg0) {
                fenetre.setVisible(false);
                TwoPlayers twoPlayers = new TwoPlayers();
                twoPlayers.play();

            }
        }


        class Bouton3Listener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                fenetre.setVisible(false);
                ThreePlayers threePlayers = new ThreePlayers();
                threePlayers.play();
            }
        }

        class Bouton4Listener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                fenetre.setVisible(false);
                FourPlayers fourPlayers = new FourPlayers();
                fourPlayers.play();
            }
        }

}
