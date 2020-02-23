import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Skeleton extends JPanel {
    protected static int width = 800;
    protected static int height = 500;
    protected Graphics2D g2d;

    public void paint(Graphics g) {
        g2d = (Graphics2D) g;
        setRenderRights();
        setBackgroundColor(new Color(100, 100, 100));
        drawPillar();
        drawSign();
        drawLights();
    }

    private void setRenderRights() {
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
    }

    private void setBackgroundColor(Color color) {
        g2d.setBackground(color);
        g2d.clearRect(0, 0, width, height);
    }

    private void drawPillar() {
        GradientPaint gp = new GradientPaint(5, 10,
                Color.BLACK, 10, 5, Color.LIGHT_GRAY, true);
        g2d.setPaint(gp);
        g2d.fillRect(385,260,30,200);
    }

    protected GeneralPath pathFromPoints(double[][] points) {
        GeneralPath path = new GeneralPath();
        path.moveTo(points[0][0], points[0][1]);
        for (int k = 1; k < points.length; k++)
            path.lineTo(points[k][0], points[k][1]);
        path.closePath();
        return path;
    }

    private void drawSign() {
        // Red part
        double[][] pointsRedBoard = {{ 285, 260 }, { 515, 260}, { 400, 40 }};
        GeneralPath redBoard = pathFromPoints(pointsRedBoard);
        g2d.setColor(Color.RED);
        g2d.fill(redBoard);

        // White part
        double[][] pointsWhiteBoard = {{ 315.0, 240.0 }, { 485.0, 240.0 }, { 400.0, 75.0 }};
        GeneralPath whiteBoard = pathFromPoints(pointsWhiteBoard);
        g2d.setColor(Color.WHITE);
        g2d.fill(whiteBoard);
    }

    private void drawLights() {
        g2d.setColor(Color.RED);
        g2d.fillOval(380,105,40, 40);
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(380,150,40, 40);
        g2d.setColor(Color.GREEN);
        g2d.fillOval(380,195,40, 40);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CGI LAB2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new Skeleton());
        frame.setVisible(true);
    }
}