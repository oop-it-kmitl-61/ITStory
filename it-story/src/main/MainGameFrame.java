package main;

import java.awt.Toolkit;
import javax.swing.*;

public class MainGameFrame extends JFrame {

    private JPanel runnerGamePanel;

    public MainGameFrame() throws InterruptedException {

        runnerGamePanel = new RunnerGamePanel();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("element/assets/icon.png")));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("IT Story Game : OOP Project 2018");
        setLocation(250, 100);
        add(runnerGamePanel);

        pack();
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) throws InterruptedException {

        new MainGameFrame();
    }

}
