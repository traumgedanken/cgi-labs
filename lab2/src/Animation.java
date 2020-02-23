import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Animation extends Skeleton implements ActionListener {
    double[][] points = {
            { -100, -15 }, { -25, -25 }, { 0, -90 }, { 25, -25 },
            { 100, -15 }, { 50, 25 }, { 60, 100 }, { 0, 50 },
            { -60, 100 }, { -50, 25 }, { -100, -15 }
    };
    Timer timer;
    private GeneralPath star;

    private double angle = 0;
    private double dx = -150;
    private double dy = 0;

    public Animation() {
        star = pathFromPoints(points);
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        g2d.translate(width / 2, 0);
        drawFrame();
        // Центр координат в середину рамки
        g2d.translate(width / 4, height / 2);
        // Для обертання навколо кута
        g2d.rotate(angle, points[0][0], points[0][1]);
        g2d.setColor(Color.GREEN);
        g2d.fill(star);
        g2d.rotate(-angle, points[0][0], points[0][1]);

        // Для руху по колу
        g2d.translate(dx, dy);
        g2d.setColor(Color.PINK);
        g2d.fill(star);
    }

    public void drawFrame() {
        int frameWeight = 16;
        BasicStroke bs = new BasicStroke(frameWeight, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_ROUND);
        g2d.setStroke(bs);
        g2d.setColor(Color.RED);
        g2d.drawRect(frameWeight / 2, frameWeight / 2,
                width / 2 - frameWeight, height - frameWeight);
    }

    public void actionPerformed(ActionEvent e) {
        angle += 0.07;
        double x = -150;
        double y = 0;
        double cos = Math.cos(-angle);
        double sin = Math.sin(-angle);
        dx = x * cos - y * sin;
        dy = x * sin + y * cos;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CGI LAB2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        width = 1600;
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new Animation());
        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        height = size.height - insets.top - insets.bottom;
    }
}