package main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import shapes.Rectangle;
import shapes.ShapeContainer;
import shapes.Square;

public class RunnerGamePanel extends JPanel {

    public static final int BASEY = 750;
    public static final int MINGAP = 200;
    public static final int MAXGAP = 500;
    private static int jumpCount = 0;

    private ShapeContainer obstacles;

    private static int randomGapx = (int) (Math.random() * (1)) * 100;
    private ArrayList<Image> runnerGif, downGif;
    private ArrayList<Image> girlrunnerGif, bar_m, bar_g;

    private JLabel scoreLabel;
    private Timer obstacleTimer1;
    private Timer obstacleTimer, runnerTimer, jumpTimer;
    private ImageIcon image0, image1, attack, plas, image2, howto1;
    private ImageIcon card, correct, wrong;
    private ImageIcon upGif, a, b, d, c, f;
    private Rectangle border;
    protected int score, newbackground, obstacleSpeed, index, heightOfJump, gamescore, pscore;
    private int bodysize_x = 200, bodysize_y = 200, x = 0, background = 0, yclass = 0;
    private int addarrow, arrow, clash = 0, clashx = 0, clashy = 0, first, second, changeHerocountdown;
    private int minicount, spacecount, xmove, attackcount, attackstart, ymove, plascount, plasstart, arrow_select;
    private int num1, numx, numy, numq, ranmove, ycount, xcount, anscorrect, coutcorrect,arrowy;
    private boolean newarrow, down, up, start, flag, isGameOver, jumpstart, quizstart;
    private int soundstart, soundcount, backgroundplas, changeHero, countdown;
    private Font pixelMplus;
    protected boolean minigameisrun;
    private Minigame_1 miniGame1;
    private Minigame_2 miniGame2;
    private Minigame_3 miniGame3;
    private sound sound;
    sound sound1 = new sound();
    
    private String[] quiz1 = {
        "1 + 1 = 2",
        "(2*100) + (6*10) + (9*1) = 269",
        "ซื้อแท่งพลาสติกแท่งละ 54 บาทจำนวน 22 แท่ง ",
        " 1234%5 = 4",
        "543%21 = 17",
        "432+123 = 555",
        "บางเดือนมี 30 วัน บางเดือนมี 31 วัน",
        "ถ้าคุณหมอให้ยามา 3 เม็ด แล้วบอกให้คุณกินยาทุกๆครึ่งชั่วโมง",
        "เอา 30 หารครึ่ง แล้วบวก 10 จะได้คำตอบเท่ากับ 70",
        "ชาวนามีแกะ 17 ตัว ทุกตัวยกเว้น 9 ตัวตายหมด",
        "ฉันเข้านอนตอน 2 ทุ่ม แล้วตั้งนาฬิกาให้ปลุกตอน 9 โมงเช้า",
        "ถ้าคุณมีไม้ขีดเพียงก้านเดียว แล้วต้องอยู่ในห้องที่หนาวเย็น",
        "ชายคนหนึ่งสร้างบ้านด้วยไม้ที่เป็นสี่เหลี่ยมผืนผ้าทั้ง 4 ด้าน",
        "หยิบแอปเปิ้ล 2 ลูกออกจากแอปเปิ้ล 3 ลูก",
        "536+27 = 563",
        "12*4*0+1 = 0",
        "13*9 = 117",
        "55+90 = 145",
        "78-12 = 66",
        "59%2 = 0",
        "100*42 = 4200",
        "45*2 = 95",
        "เมื่อเราแลบลิ้นเราจะไม่สามารถหายใจได้",
        "ถ้าเราวิ่งแข่งอยู่ แล้วแซงที่ 2 ได้ แสดงว่าเราอยู่ลำดับที่ 1",
        "ในจำนวน ตั้งแต่ 0-40 มีเลข 3 ทั้งหมด 11 ตัว",
        "กาที่ปากกว้างมากๆคือ กาโถนใส่คาหยะ",
        "ตอที่อยู่ในบ้าน คือ ตอระตั้ด",
        "นาฬิกาที่หายากที่สุดคือนาฬิกาหาย",
        "สจล. ย่อมาจาก สวยจังเลย",
        "เจ้าของร้านน้องจิ๊บชื่อจิ๊บ",
        "คณะไอทีมี 7 ชั้น",
        "อธิการบดีคณะไอทีคือ ผศ.ดร. ปานวิทย์",
        "ห้อง Auditorium มีที่นั่ง200ที่นั่ง",
        "รศ.ดร. โชติพัชร์ สอน PSIT ",
        "รศ.ดร. สุขสันต์ สอน ICS",
        "ผศ.ดร. โอฬาร สอน General Business",
        "ผศ.ดร. ธนิศา สอน OOP",
        "ผศ.ดร. มานพ สอน Web Technology",
        "ดร.อนันตพัฒน์ สอน ComOr",
        "ปัจจุบันคณะไอทีมี 4 แขนง",
        "ปัจจุบันมีนักศึกษาป.ตรี ทั้งหมด 16 รุ่น",
        
        "0.027 + 1.963 = 2",
        "(2*100) + (6*10) + (9*1) = 269",
        "ซื้อแท่งพลาสติกแท่งละ 54 บาทจำนวน 22 แท่ง ",
        " 1234%5 = 4",
        "543%21 = 17",
        "432+123 = 555",
        "บางเดือนมี 30 วัน บางเดือนมี 31 วัน",
        "ถ้าคุณหมอให้ยามา 3 เม็ด แล้วบอกให้คุณกินยาทุกๆครึ่งชั่วโมง",
        "เอา 30 หารครึ่ง แล้วบวก 10 จะได้คำตอบเท่ากับ 70",
        "ชาวนามีแกะ 17 ตัว ทุกตัวยกเว้น 9 ตัวตายหมด",
        "ฉันเข้านอนตอน 2 ทุ่ม แล้วตั้งนาฬิกาให้ปลุกตอน 9 โมงเช้า",
        "ถ้าคุณมีไม้ขีดเพียงก้านเดียว แล้วต้องอยู่ในห้องที่หนาวเย็น",
        "ชายคนหนึ่งสร้างบ้านด้วยไม้ที่เป็นสี่เหลี่ยมผืนผ้าทั้ง 4 ด้าน",
        "หยิบแอปเปิ้ล 2 ลูกออกจากแอปเปิ้ล 3 ลูก",
        "536+27 = 563",
        "12*4*0+1 = 0",
        "13*9 = 117",
        "55+90 = 145",
        "78-12 = 66",
        "59%2 = 0",
        "100*42 = 4200",
        "45*2 = 95",
        "เมื่อเราแลบลิ้นเราจะไม่สามารถหายใจได้",
        "ถ้าเราวิ่งแข่งอยู่ แล้วแซงที่ 2 ได้ แสดงว่าเราอยู่ลำดับที่ 1",
        "ในจำนวน ตั้งแต่ 0-40 มีเลข 3 ทั้งหมด 11 ตัว",
        "กาที่ปากกว้างมากๆคือ กาโถนใส่คาหยะ",
        "ตอที่อยู่ในบ้าน คือ ตอระตั้ด",
        "นาฬิกาที่หายากที่สุดคือนาฬิกาหาย",
        "สจล. ย่อมาจาก สวยจังเลย",
        "เจ้าของร้านน้องจิ๊บชื่อจิ๊บ",
        "คณะไอทีมี 7 ชั้น",
        "อธิการบดีคณะไอทีคือ ผศ.ดร. ปานวิทย์",
        "ห้อง Auditorium มีที่นั่ง200ที่นั่ง",
        "รศ.ดร. โชติพัชร์ สอน PSIT ",
        "รศ.ดร. สุขสันต์ สอน ICS",
        "ผศ.ดร. โอฬาร สอน General Business",
        "ผศ.ดร. ธนิศา สอน OOP",
        "ผศ.ดร. มานพ สอน Web Technology",
        "ดร.อนันตพัฒน์ สอน ComOr",
        "ปัจจุบันคณะไอทีมี 4 แขนง",
        "ปัจจุบันมีนักศึกษาป.ตรี ทั้งหมด 16 รุ่น"};

    private String[] quiz2 = {
        "",
        "",
        "จะต้องเตรียมเงิน 1881 บาท",
        "",
        "",
        "",
        "มี 1 เดือนที่มี 28 วัน",
        "คุณต้องใช้เวลา 1 ชั่วโมง 30 นาที ถึงจะกินยาหมด",
        "",
        "ถามว่ายังมีแกะที่มีชีวิตเหลืออยู่ 8 ตัว",
        "ดังนั้น ฉันจะได้นอน 13 ชั่วโมงก่อนที่นาฬิกาปลุกจะดัง",
        "ในนั้นมีฮีตเตอร์ ตะเกียง และเทียนไข คุณจะเลือกจุดเทียนไข",
        "และหันบ้านไปทางทิศใต้ ถ้ามีหมีผ่านมา หมีตัวนั้นจะมีสีน้ำตาล",
        "ถามว่าคุณจะได้แอปเปิ้ล 2 ลูก",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        
        "",
        "",
        "จะต้องเตรียมเงิน 1881 บาท",
        "",
        "",
        "",
        "มี 1 เดือนที่มี 28 วัน",
        "คุณต้องใช้เวลา 1 ชั่วโมง 30 นาที ถึงจะกินยาหมด",
        "",
        "ถามว่ายังมีแกะที่มีชีวิตเหลืออยู่ 8 ตัว",
        "ดังนั้น ฉันจะได้นอน 13 ชั่วโมงก่อนที่นาฬิกาปลุกจะดัง",
        "ในนั้นมีฮีตเตอร์ ตะเกียง และเทียนไข คุณจะเลือกจุดเทียนไข",
        "และหันบ้านไปทางทิศใต้ ถ้ามีหมีผ่านมา หมีตัวนั้นจะมีสีน้ำตาล",
        "ถามว่าคุณจะได้แอปเปิ้ล 2 ลูก",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        ""};

    private String[] ans = {"1", "1", "0", "1", "0", "1", "0", "0", "1", "0", "0",
        "0", "0", "1", "1", "0", "1", "1", "1", "0", "1", "0",
        "0", "0", "0", "1", "1", "1", "0", "0", "0", "0", "0",
        "1", "1", "1", "1", "1", "1", "0", "1",
        "0", "1", "0", "1", "0", "1", "0", "0", "1", "0", "0",
        "0", "0", "1", "1", "0", "1", "1", "1", "0", "1", "0",
        "0", "0", "0", "1", "1", "1", "0", "0", "0", "0", "0",
        "1", "1", "1", "1", "1", "1", "0", "1"};

    // constructors
    public RunnerGamePanel() {
        setPreferredSize(new Dimension(1400, 800));
        setFocusable(true);
        scoreLabel = new JLabel();
        init();
        add(scoreLabel);
        this.addKeyListener((KeyListener) new JumpKeyListener());

    }

    private void init() {
        arrowy = 790;
        arrow_select = 1;
        coutcorrect = 0;
        minicount = 0;
        num1 = 0;
        pscore = 0;
        soundcount = 0;
        attackstart = 0;
        attackcount = 0;
        plascount = 0;
        plasstart = 0;
        ymove = 1400;
        xmove = 1400;
        gamescore = 0;
        jumpstart = false;
        soundstart = 0;
        changeHero = 0;
        addarrow = 95;
        arrow = 360;
        countdown = 0;
        newbackground = 0;
        score = 0;
        down = false;
        up = false;
        start = false;
        newarrow = true;
        obstacleSpeed = 1;
        index = 0;
        heightOfJump = 0;
        flag = false;
        background = 0;
        minigameisrun = true;
        quizstart = false;
        first = 0;
        numx = 10;
        numy = 15;
        numq = 5;

        image0 = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/bg/bgA.png")).getImage());
        howto1 = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/bg/howtoplay1.png")).getImage());
        image1 = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/bg/howtoA.png")).getImage());
        image2 = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/arrow.png")).getImage());
        upGif = new ImageIcon(new ImageIcon(getClass().getResource("element/character/b_up0.png")).getImage());
        attack = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/attack.png")).getImage());
        plas = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/plas.png")).getImage());
        a = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/bg/bgA.png")).getImage());
        b = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/bg/bgB.png")).getImage());
        c = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/bg/bgC.png")).getImage());
        d = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/bg/bgD.png")).getImage());
        f = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/bg/bgF.png")).getImage());
        card = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/card.png")).getImage());
        correct = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/correct.png")).getImage());
        wrong = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/wrong.png")).getImage());

        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("RD CHULAJARUEK.ttf")).deriveFont(Font.BOLD, 42f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("RD CHULAJARUEK.ttf")));
            System.out.println("Font -  Check font complete");
        } catch (IOException | FontFormatException e) {
            System.out.println("Font - not response");
        }
        border = new Rectangle(30, 30);
        border.setLocation(30, BASEY - 300 - heightOfJump);
        isGameOver = false;
        obstacles = new ShapeContainer();
        obstacles.add(new obj1(0, yclass + 50));
        runnerGif = new ArrayList<Image>();
        downGif = new ArrayList<Image>();
        girlrunnerGif = new ArrayList<Image>();
        bar_g = new ArrayList<Image>();
        bar_m = new ArrayList<Image>();
        bar_m = new ArrayList<Image>();

        for(int i = 0; i < 5; i++) {
            runnerGif.add((new ImageIcon(this.getClass().getResource("element/character/b_run" + i + ".png")).getImage()));
            girlrunnerGif.add((new ImageIcon(this.getClass().getResource("element/character/g_run" + i + ".png")).getImage()));
            bar_m.add((new ImageIcon(this.getClass().getResource("element/character/b_def" + i + ".png")).getImage()));
            bar_g.add((new ImageIcon(this.getClass().getResource("element/character/g_def" + i + ".png")).getImage()));
        }

        obstacleTimer = new Timer(obstacleSpeed, (ActionListener) new TimerActionListener());
        obstacleTimer1 = new Timer(obstacleSpeed, new TimerActionListener());
        jumpTimer = new Timer(50, new JumpActionListener());
        runnerTimer = new Timer(100, new RunnerActionListener());
        obstacleTimer.start();
        obstacleTimer1.start();
        runnerTimer.start();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (start == true) {
            numx = 10;
            numy = 15;
            numq = 5;
            backgroundplas = 5;
            background -= backgroundplas;
        } else {
            numx = 0;
            numy = 0;
            numq = 0;
        }

        if (newbackground == 0) {
            g.drawImage(image0.getImage(), background, 0, 44400, getHeight(), this);
        } else {
            g.drawImage(image1.getImage(), background, 0, 44400, getHeight(), this);
        }

        if (background <= -43000) {
            start = false;
            backgroundplas = 0;
            if (gamescore >= 80) {
                g.drawImage(a.getImage(), background, 0, 44400, getHeight(), this);
                System.out.println("Grade A");
            } else if (gamescore >= 70) {
                g.drawImage(b.getImage(), background, 0, 44400, getHeight(), this);
                System.out.println("Grade B");
            } else if (gamescore >= 60) {
                g.drawImage(c.getImage(), background, 0, 44400, getHeight(), this);
                System.out.println("Grade C");
            } else if (gamescore >= 50) {
                g.drawImage(d.getImage(), background, 0, 44400, getHeight(), this);
                System.out.println("Grade D");
            } else {
                g.drawImage(f.getImage(), background, 0, 44400, getHeight(), this);
                System.out.println("Grade F");
            }
        } else {
            if (newbackground == 0) {
                g.drawImage(image0.getImage(), background, 0, 44400, getHeight(), this);
            } else if (newbackground == 1) {
                g.drawImage(howto1.getImage(), background, 0, getWidth(), getHeight(), this);
            } else if (newbackground == 2) {
                g.drawImage(image1.getImage(), background, 0, 44400, getHeight(), this);
            }
        }

        if (newarrow == true) {
            g.drawImage(image2.getImage(), arrowy, arrow + 50, 50, 70, this);
        }

        if (changeHero == 0) {
            if (clash != 0) {
                g2.drawImage(bar_m.get(index), 30, BASEY - bodysize_y - heightOfJump, bodysize_x - 50, bodysize_y, this);
            } else if (down == true) {
                g2.drawImage(downGif.get(index), 30, BASEY - bodysize_y - heightOfJump, bodysize_x - 50, bodysize_y, this);
            } else if (up == true) {
                g2.drawImage(upGif.getImage(), 30, BASEY - bodysize_y - heightOfJump, bodysize_x - 50, bodysize_y, this);
            } else {
                g2.drawImage(runnerGif.get(index), 30, BASEY - bodysize_y - heightOfJump, bodysize_x - 50, bodysize_y, this);
            }
        } else {
            if (clash != 0) {
                g2.drawImage(bar_g.get(index), 30, BASEY - bodysize_y - heightOfJump, bodysize_x - 50, bodysize_y, this);
            } else {
                g2.drawImage(girlrunnerGif.get(index), 30, BASEY - bodysize_y - heightOfJump, bodysize_x - 50, bodysize_y, this);
            }
        }
// ------------------------------------------------------------------------------------------------------------------------------

        border.setLocation(30, BASEY - 80 - heightOfJump);
        Iterator i = obstacles.iterator();
        while (i.hasNext()) {
            ((obj1) i.next()).draw(g2);
        }

        ranmove = ((int) (Math.random() * (4) + 1) * 300);

        if (background % ranmove == 0 && attackcount == 0 && background <= -1000 && background >= -43000) {
            if (background % ranmove == 0) {
                ycount = ((int) (Math.random() * (2)) * 100 + 400);
                xcount = ((int) (Math.random() * (2)) * 100 + 450);
                attackcount += 1;
                attackstart = 1;
            }
        }

        if (attackcount == 1) {
            g2.drawImage(attack.getImage(), xmove, xcount, 50, 50, this);
            xmove -= numx;
            if (xmove <= 0) {
                attackcount = 0;
                xmove = 1400;
            }
        }

        //------------------------------------------------------------------------------------
        if ((background % 50) == 0 && plascount == 0 && background <= -1000) {
            ycount = ((int) (Math.random() * (3)) * 100 + 500);
            plascount += 1;
            plasstart = 1;
        }
        if (plascount == 1) {
            g2.drawImage(plas.getImage(), ymove, ycount, 50, 50, this);
            ymove -= numy;
            if (ymove <= 0) {
                plascount = 0;
                ymove = 1400;
            }
        }

        if (background <= -1000 && soundcount == 0) {
            System.out.println("-----------SOUND : 1----------------: " + soundcount);
            sound1.background1();
            soundcount = 1;
        }
        if (background <= -20000 && soundcount == 1) {
            System.out.println("-----------SOUND : 2----------------: " + soundcount);
            sound1.background2();
            soundcount = 2;
        }
        if (background <= -30000 && soundcount == 2) {
            sound1.background3();
            soundcount = 3;
            System.out.println("-----------SOUND : 3----------------: " + soundcount);
        }
        if (background <= -37000 && soundcount == 3) {
            System.out.println("-----------SOUND : 3----------------: " + soundcount);
            sound1.background4();
            soundcount = 4;

        }

        if (minicount == 2 && background <= -23700) {
            minigameisrun = true;
            minicount = 3;
        } else if (minicount == 1 && background <= -14600) {
            minigameisrun = true;
            minicount = 2;
        } else if (minicount == 0 && background <= -6000) {
            minigameisrun = true;
            minicount = 1;
        }

        if (background <= -23700 && minigameisrun == true) {
            start = false;
            miniGame3 = new Minigame_3();
            minigameisrun = false;
            minicount = 3;
        } else if (background <= -14600 && minigameisrun == true) {
            start = false;
            miniGame2 = new Minigame_2();
            minigameisrun = false;
            minicount = 2;
        } else if (background <= -6000 && minigameisrun == true) {
            start = false;
            miniGame1 = new Minigame_1();
            minigameisrun = false;
            minicount = 1;
        }

        if (quiz1[num1] != "") {
            if (num1 >= 0 && quizstart == true) {
                start = false;
                minigameisrun = false;
                g.drawImage(card.getImage(), 50, 50, 1300, 700, this);
                g.setFont(pixelMplus);
                g.drawString("" + quiz1[num1], 150, 300);
                g.drawString("" + quiz2[num1], 150, 400);
            }
        } else {
            num1 = 0;
        }

        if (anscorrect != 0 && spacecount == 1) {
            if (coutcorrect == 1) {
                g.drawImage(correct.getImage(), 50, 50, 340, 60, this);
            }
            if (coutcorrect == 0) {
                g.drawImage(wrong.getImage(), 50, 50, 310, 55, this);
            }
        }

    }

    class TimerActionListener implements ActionListener {

        private int shapeX;

        public void actionPerformed(ActionEvent e) {

            // obstacles.size คือพวก 4 เหลี่ยนนั้นละมมันคือจำนวนของมัน
            for (int i = 0; i < obstacles.size(); i++) {
                obj1 obstacle = ((obj1) obstacles.getShape(i));
                obstacle.setLocation(obstacle.getX() - numq, obstacle.getY());
                if (obstacle.getX() == -50) {
                    obstacle.setSelected(true);
                }
            }

            if ((new java.awt.Rectangle(((Square) obstacles.getShape(x)).getX(), ((Square) obstacles.getShape(x)).getY(), 10, 10)
                    .intersects(new java.awt.Rectangle(0, BASEY - bodysize_y - heightOfJump, 90, 150))) && clash <= 0) {
                if (clash == 0) {
                    clash = 400;
                    isGameOver = true;
                }
            } else {
                if (clash > 0) {
                    clash--;
                }
            }

            if ((new java.awt.Rectangle(xmove, ycount, 50, 100)
                    .intersects(new java.awt.Rectangle(0, BASEY - bodysize_y - heightOfJump, 80, 150))) && clashx <= 0) {
                gamescore -= 5;
                xmove = -100;
                if (clashx == 0) {
                    clashx = 500;
                }
            } else {
                if (clashx > 0) {
                    clashx--;
                }
            }

            if ((new java.awt.Rectangle(ymove, ycount, 50, 50)
                    .intersects(new java.awt.Rectangle(0, BASEY - bodysize_y - heightOfJump, 80, 150))) && clashy <= 0) {
                gamescore += 5;
                ymove = -100;
                if (clashy == 0) {
                    clashy = 300;
                }
            } else {
                if (clashy > 0) {
                    clashy--;
                }
            }

            if (start == true) {
                if (first == 0) {
                    obstacles.add(new obj1(1400, 100 + 50));
                    first++;
                }
                obj1 obstacle = ((obj1) obstacles.getShape(obstacles.size() - 1));
                if (1200 - obstacle.getX() == randomGapx) {
                    obstacles.add(new obj1(1400, yclass + 50));
                    randomGapx = (int) (Math.random() * (2)) * 200 + 800;
                    yclass = (int) (Math.random() * (3)) * 200 + 400;
                    score++;
                    scoreLabel.setText("Score: " + gamescore);
                }
                obstacles.remove();
            }

            if (isGameOver) {
                System.out.println("overrrrrrr");
                runnerTimer.stop();
                obstacleTimer.stop();
                spacecount = 0;

                //     int confirm = JOptionPane.showConfirmDialog(null, scoreLabel.getText() + "\n" + ""+quiz[num1], "Quiz", 0);
                if (quizstart == false) {
                    num1++;
                }

                quizstart = true;
                isGameOver = false;
                runnerTimer.start();
                obstacleTimer.start();
                System.out.println("isgameover : " + isGameOver);

            }
            repaint();

        }

    }

    class RunnerActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (index == 4) {
                index = 1;
            } else {
                index++;
            }
            if (anscorrect != 0) {
                anscorrect -= 1;
            }
        }
    }

    class JumpMouseListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            jumpTimer.setDelay(3);
            jumpTimer.start();
        }

    }

    class JumpActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (start == true || jumpstart == true) {
                if (jumpCount == 160) {
                    flag = true;
                }
                if (flag) {
                    jumpCount -= 5;
                    if (jumpCount == 0) {
                        jumpTimer.stop();
                        flag = false;
                        score += 2;
                        up = false;
                    }
                    if (jumpCount != 0) {
                        up = true;
                    }
                } else {
                    jumpCount += 5;
                    up = true;
                }
                heightOfJump = 2 * jumpCount;
                if (down == true) {
                    if (countdown == 100) {
                        down = false;
                        countdown = 0;
                    } else {
                        countdown++;
                    }
                }
            }
        }

    }

    class JumpKeyListener extends KeyAdapter {

        sound sound = new sound();

        public void keyReleased(KeyEvent e) {

            if (e.getExtendedKeyCode() == e.VK_SPACE) {
                up = false;
            }
            if (e.getExtendedKeyCode() == e.VK_DOWN) {
                down = false;
            }
            if (e.getExtendedKeyCode() == e.VK_ENTER) {
                if (minigameisrun == false) {
                    start = true;
                    first = 0;
                    //   anscorrect = 4;
                    //   spacecount = spacecount + 1;
                }
            }
            if (e.getExtendedKeyCode() == e.VK_RIGHT) {
                if (minigameisrun == false && spacecount == 0) {
                    if (spacecount == 0) {
                        start = true;
                        first = 0;
                    }
                    anscorrect = 4;
                    spacecount = spacecount + 1;
                }
            }
            if (e.getExtendedKeyCode() == e.VK_LEFT) {
                if (minigameisrun == false) {
                    if (spacecount == 0) {
                        start = true;
                        //   first = 0;
                    }

                    anscorrect = 4;
                    spacecount = spacecount + 1;
                }
            }

        }

        public void keyPressed(KeyEvent e) {
            if (e.getExtendedKeyCode() == e.VK_SPACE) {
                jumpTimer.setDelay(3);
                jumpTimer.start();
                up = true;
                //เสียงกระโดด
                sound.jump();
            }
            if (e.getExtendedKeyCode() == e.VK_UP) {
                
                if(arrow_select >= 3){
                    arrow -= addarrow;
                    arrowy = 830;
                    arrow_select--;
                    System.out.println("arrows : "+arrow_select);
                }
                else if(arrow_select >= 2){
                    arrow -= addarrow;
                    arrowy = 790;
                    arrow_select--;
                    System.out.println("arrows : "+arrow_select);
                }

            } else if (e.getExtendedKeyCode() == e.VK_DOWN) {
                
                if(arrow_select <= 1){
                    arrow += addarrow;
                    arrowy = 830;
                    arrow_select++;
                    System.out.println("arrows : "+arrow_select);
                }
                else if(arrow_select <= 2){
                    arrow += addarrow;
                    arrowy = 860;
                    arrow_select++;
                    System.out.println("arrows : "+arrow_select);
                }
                
                
                if (jumpstart == true) {
                    down = true;
                }
                if (start == true) {
                    down = true;
                }
            } else if (e.getExtendedKeyCode() == e.VK_RIGHT) {
                System.out.println(ans[num1]);
                if (ans[num1] == "0" && quizstart == true) {
                    if (anscorrect != 0 || quizstart == true) {
                        coutcorrect = 1;
                        gamescore = gamescore + 5;
                    } else {
                        coutcorrect = 0;
                    }
                    gamescore = gamescore - 10;
                }
                if (start == false && background >= -50) {
                    changeHero++;
                }
                quizstart = false;

            } else if (e.getExtendedKeyCode() == e.VK_LEFT) {
                System.out.println(ans[num1]);
                if (ans[num1] == "1" && quizstart == true) {
                    gamescore = gamescore + 5;
                    coutcorrect = 1;
                } else {
                    gamescore = gamescore - 10;
                    coutcorrect = 0;
                }
                if (start == false && background >= -50) {
                    changeHero++;
                }
                quizstart = false;
            }

            if (e.getExtendedKeyCode() == e.VK_ENTER) {
                if (newbackground == 2) {
                    System.out.println("in 6333333333333333");
                    start = true;
                    newbackground = 3;
                }
                if (newbackground == 1) {
                    newbackground = 2;
                    System.out.println("in 2222222222222222");
                }
                
                if (arrow_select == 2 && newarrow == true) {
                    arrow = 0;
                    newbackground = 1;
                    jumpstart = true;
                    newarrow = false;
                    System.out.println("in 11111111111111111111111");
                    //addarrow = 0;
                }
                if (arrow_select == 3 && newarrow == true) {
                    System.exit(0);
                }
                


                if (arrow_select == 1) {
                    arrow = 0;
                    start = true;
                    newbackground = 0;
                    newarrow = false;
                    
                }
                


                if (background <= -42000) {
                    runnerTimer.stop();
                    obstacleTimer.stop();
                    jumpTimer.stop();
                    runnerTimer.removeActionListener(runnerTimer.getActionListeners()[0]);
                    obstacleTimer.removeActionListener(obstacleTimer.getActionListeners()[0]);
                    if (jumpTimer.getActionListeners()[0] != null) {
                        jumpTimer.removeActionListener(jumpTimer.getActionListeners()[0]);
                    }
                    sound1.background5();
                    init();
                }

            }
            if (e.getExtendedKeyCode() == e.VK_ESCAPE) {
                System.exit(0);
            }
            if (e.getExtendedKeyCode() == e.VK_0) {
                background = -40000;
            }
            changeHero = changeHero % 2;
        }

    }
}
