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

public class Minigame_2 {

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel;

    Font titleFont;
    Font normalFont;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    String weapon, position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public Minigame_2() {

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
        titleNameLabel = new JLabel("IT ADVENTURE STAGE 2");
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
        mainTextArea.setText("มีเพื่อนแล้วไปทำกิจกรรม TobeIT กับเพื่อนดีมั้ย ?");
        choice1.setText("ไปดิ หาประสบการณ์ใหม่ๆด้วย");
        choice2.setText("ไม่ไปละกัน");
        choice3.setText("คิดแป๊ป");
    }

    public void backto() {
        position = "backto";
        mainTextArea.setText("ไปเถอะนะ ไปเถอะ");
        choice1.setText("เอาไงดีนะ ไปก็ได้");
        choice2.setText("ไม่อะ ยังไงก็ขี้เกียจ");
        choice3.setText("ไม่ไป อยากนอน");
    }

    public void sick() {
        position = "sick";
        mainTextArea.setText("แย่แล้ว น้องค่ายไม่สบายหนักมาก! ทำไงดี ?");
        choice1.setText("ไปขอยากับประธานค่าย");
        choice2.setText("ไปหาฝ่ายพยาบาล");
        choice3.setText("ไปขอยากับเพื่อนของน้องค่าย");
    }

    public void ignore() {
        position = "ignore";
        mainTextArea.setText("ไม่มี ! ตอนนี้ไม่ว่าง ลองถามคนอื่นดูนะ");
        choice1.setText("โอเค เดี๋ยวลองดูฝ่ายอื่น");
        choice2.setText("ไปหาฝ่ายพยาบาล");
        choice3.setText("ไม่สนใจ");
    }

    public void nextto() {
        position = "nextto";
        mainTextArea.setText("อ่าว หมดเขตซะแล้ว ทำไงดี ?");
        choice1.setText("กลับบ้านนอนแล้วกัน");
        choice2.setText("ไปดูหลักสูตรก่อนดีกว่า");
        choice3.setText("คิดใหม่แปป");
    }

    public void happyend() {
        position = "happyend";

        mainTextArea.setText("เย้ ได้ยาแล้ว เอาไปให้น้องดีกว่า");

        choice1.setText("gogo~");
        choice2.setVisible(false);
        choice3.setVisible(false);

    }

    public void pre_badend() {
        position = "pre_badend";

        mainTextArea.setText("ถ้าไม่ทำงาน เพื่อนจะติดโปรนะ");

        choice1.setText("ขอเวลาคิดหน่อย");
        choice2.setText("ช่างแม่ง");
        choice3.setText("ไม่สน ไม่แคร์");
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
                            sick();
                            break;
                        case "c2":
                            pre_badend();
                            break;
                        case "c3":
                            backto();
                            break;
                    }
                    break;
                case "backto":
                    switch (yourChoice) {
                        case "c1":
                            sick();
                            break;
                        case "c2":
                            pre_badend();
                            break;
                        case "c3":
                            pre_badend();
                            break;
                    }
                    break;
                case "sick":
                    switch (yourChoice) {
                        case "c1":
                            ignore();
                            break;
                        case "c2":
                            happyend();
                            break;
                        case "c3":
                            ignore();
                            break;
                    }
                    break;
                case "ignore":
                    switch (yourChoice) {
                        case "c1":
                            sick();
                            break;
                        case "c2":
                            ending();
                            break;
                        case "c3":
                            ignore();
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
                case "pre_badend":
                    switch (yourChoice) {
                        case "c1":
                            start();
                            break;
                        case "c2":
                            badend();
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
                    }
                    break;
            }

        }
    }

}
