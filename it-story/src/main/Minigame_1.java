package main;

import java.awt.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Minigame_1 {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;

    Font titleFont;
    Font normalFont;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP, monsterHP, silverRing;
    String weapon, position;
    
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public Minigame_1() {
        try {
            titleFont = Font.createFont(Font.TRUETYPE_FONT, new File("RD CHULAJARUEK.ttf")).deriveFont(50f);
            normalFont = Font.createFont(Font.TRUETYPE_FONT, new File("RD CHULAJARUEK.ttf")).deriveFont(30f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("RD CHULAJARUEK.ttf")));
            //System.out.println("\\\\\\\\ Check font complete ////////");

        } catch (IOException | FontFormatException e) {
            //System.out.println("\\\\\\\\ not response ////////");
        }

        window = new JFrame();
        window.setSize(1450, 850);
        window.setLocation(240, 100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(430, 300, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("IT ADVENTURE STAGE 1");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(630, 500, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

    }

    public void createGameScreen() {
        
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(500, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("This is the main text are. This game is going to be great. I'm sure of it!!!!!!!");
        mainTextArea.setBounds(600, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(500, 350, 500, 250);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 500, 60);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);
        playerSetup();

    }

    public void playerSetup() {
        start();
    }

    public void start() {
        position = "start";
        mainTextArea.setText("ตั้งแต่วันแรกที่ก้าวเข้าสู่คณะไอที\nตอนนี้ฉันยังไม่มีเพื่อนเลย ทำไงดี ?");
        choice1.setText("อยู่คนเดียว ก็เฟี้ยวได้");
        choice2.setText("ไปงาน Unite Camp");
        choice3.setText("ลาออก");
    }

    public void backto() {
        position = "backto";
        mainTextArea.setText("แต่ก็เหงาอ่ะ ทำไงดี ?");
        choice1.setText("กลับไปคิดใหม่ดีกว่า");
        choice2.setText("ไป Unite Camp เลยละกัน");
        choice3.setText("ลาออก");
    }

    public void nextto() {
        position = "nextto";
        mainTextArea.setText("ตอนนี้เรามาค่าย Unite Camp แล้ว จะหาเพื่อนยังไงดีนะ ?");
        choice1.setText("เดินไปทักเลย");
        choice2.setText("แอบชวนคุยตอนกินข้าวละกัน");
        choice3.setText("ไม่รู้จะคุยกับใครดี ลาออกแล้วกัน");
    }

    public void backto2() {
        position = "backto2";
        mainTextArea.setText("ถามผิดคนแล้ว!!");
        choice1.setText("เข้าใจแล้ว กลับไปเลือกใหม่");
        choice2.setText("ไม่เข้าใจ!!");
        choice2.setText("คิดก่อน");
    }

    public void happyend() {
        position = "happyend";

        mainTextArea.setText("มีเพื่อนแล้ว พร้อมจะเรียนต่อรึยัง ?");

        choice1.setText("พร้อม");
        choice2.setText("ยังไม่พร้อม ลาออกเลยแล้วกัน");
        choice3.setVisible(false);

    }

    public void pre_badend() {
        position = "pre_badend";

        mainTextArea.setText("ลาออกจริง ๆ ใช่ไหม ?");

        choice1.setText("คิดดีแล้ว");
        choice2.setText("ขอกลับไปคิดใหม่");
        choice3.setText("ลาออกดีกว่า");
    }

    public void badend() {
        position = "badend";

        System.exit(0);
    }

    public void ending() {
        position = "ending";
        window.setVisible(false);
    }

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String yourChoice = event.getActionCommand();

            switch (position) {
                case "start":
                    switch (yourChoice) {
                        case "c1":
                            backto();
                            break;
                        case "c2":
                            nextto();
                            break;
                        case "c3":
                            pre_badend();
                            break;
                    }
                    break;
                case "backto":
                    switch (yourChoice) {
                        case "c1":
                            start();
                            break;
                        case "c2":
                            nextto();
                            break;
                        case "c3":
                            pre_badend();
                            break;
                    }
                    break;
                case "nextto":
                    switch (yourChoice) {
                        case "c1":
                            happyend();
                            break;
                        case "c2":
                            happyend();
                            break;
                        case "c3":
                            pre_badend();
                            break;
                    }
                    break;
                case "pre_badend":
                    switch (yourChoice) {
                        case "c1":
                            badend();
                            break;
                        case "c2":
                            start();
                            break;
                        case "c3":
                            badend();
                            break;
                    }
                    break;
                case "happyend":
                    switch (yourChoice) {
                        case "c1":
                            ending();
                            break;
                        case "c2":
                            pre_badend();
                            break;
                    }
                    break;

            }

        }
    }

}
