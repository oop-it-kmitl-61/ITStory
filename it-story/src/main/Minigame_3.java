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

public class Minigame_3 {

    Font pixelMplus;
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel;

    Font titleFont;
    Font normalFont;
    JButton startButton, choice1, choice2, choice3;
    JTextArea mainTextArea;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    /*
	public static void main(String[] args) {

		new Minigame_3();
	}
     */
    public Minigame_3() {

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
        titleNameLabel = new JLabel("IT ADVENTURE STAGE 3");
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

        playerSetup();

    }

    public void playerSetup() {
        start();
    }

    public void start() {
        position = "start";
        mainTextArea.setText("สอบไฟนอลเสร็จแล้วทำอะไรต่อดี ?");
        choice1.setText("ดูหลักสูตรเทอมหน้าดีกว่า");
        choice2.setText("ไปงานแข่ง Hackathon");
        choice3.setText("กลับบ้าน เฮ้!!");
    }

    public void backto() {
        position = "backto";
        mainTextArea.setText("OOP / WebTech / Data Structure\nน่าเรียนจังเลย แต่ละอันเรียนเกี่ยวกับอะไรบ้างนะ ?");
        choice1.setText("ดูของ OOP ก่อนแล้วกัน");
        choice2.setText("ดูของ Web Technology ก่อนแล้วกัน");
        choice3.setText("ดูของ Data Structure ก่อนแล้วกัน");
    }

    public void oop() {
        position = "oop";
        mainTextArea.setText("OOP ดูน่าสนใจไม่น้อยเลย\nเรียนเกี่ยวกับการเขียนโปรแกรมเชิงวัตถุใช่มั้ยเนี่ย ?");
        choice1.setText("ดูของ Web Technology ต่อแล้วกัน");
        choice2.setText("ดูของ Data Structure ต่อแล้วกัน");
        choice3.setText("ไปทำอย่างอื่นดีกว่า");
    }

    public void webtech() {
        position = "webtech";
        mainTextArea.setText("Web Technology ดูน่าสนใจไม่น้อยเลย\nเรียนเกี่ยวกับการเขียนเว็บด้วย");
        choice1.setText("ดูของ OOP ต่อแล้วกัน");
        choice2.setText("ดูของ Data Structure ต่อแล้วกัน");
        choice3.setText("ไปทำอย่างอื่นดีกว่า");
    }

    public void data() {
        position = "data";
        mainTextArea.setText("Data Structure ดูน่าสนใจไม่น้อยเลย\nเรียนเกี่ยวกับการฝึกอัลกอรึทึมนิ น่าสนใจแฮะ");
        choice1.setText("ดูของ OOP ต่อแล้วกัน");
        choice2.setText("ดูของ Web Technology ต่อแล้วกัน");
        choice3.setText("ไปทำอย่างอื่นดีกว่า");
    }

    public void nextto() {
        position = "nextto";
        mainTextArea.setText("อ่าว หมดเขตซะแล้ว ทำไงดี ?");
        choice1.setText("กลับบ้านนอนแล้วกัน");
        choice2.setText("ไปดูหลักสูตรก่อนดีกว่า");
        choice3.setText("คิดใหม่แปป");
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
                            ending();
                            break;
                    }
                    break;
                case "backto":
                    switch (yourChoice) {
                        case "c1":
                            oop();
                            break;
                        case "c2":
                            webtech();
                            break;
                        case "c3":
                            data();
                            break;
                    }
                    break;
                case "oop":
                    switch (yourChoice) {
                        case "c1":
                            webtech();
                            break;
                        case "c2":
                            data();
                            break;
                        case "c3":
                            start();
                            break;
                    }
                    break;
                case "webtech":
                    switch (yourChoice) {
                        case "c1":
                            oop();
                            break;
                        case "c2":
                            data();
                            break;
                        case "c3":
                            start();
                            break;
                    }
                    break;
                case "data":
                    switch (yourChoice) {
                        case "c1":
                            oop();
                            break;
                        case "c2":
                            webtech();
                            break;
                        case "c3":
                            start();
                            break;
                    }
                    break;
                case "nextto":
                    switch (yourChoice) {
                        case "c1":
                            ending();
                            break;
                        case "c2":
                            backto();
                            break;
                        case "c3":
                            start();
                            break;
                    }
                    break;

            }

        }
    }

}
