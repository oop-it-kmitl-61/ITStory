package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import static main.RunnerGamePanel.BASEY;

import shapes.Drawable;
import shapes.Square;

public class obj1 extends Square implements ImageObserver {

    private ImageIcon item1 = new ImageIcon(new ImageIcon(getClass().getResource("element/assets/question.png")).getImage());

    public obj1(int x, int y) {
        super(0);
        setLocation(x, y);

    }

    public void draw(Graphics2D g) {

        g.drawImage(item1.getImage(), getX(), getY(), 80, 80, (ImageObserver) this);
        //g.fillRect(getX(), getY(), 50, 50);
    }

    @Override
    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
        throw new UnsupportedOperationException(" "); //To change body of generated methods, choose Tools | Templates.
    }
}
