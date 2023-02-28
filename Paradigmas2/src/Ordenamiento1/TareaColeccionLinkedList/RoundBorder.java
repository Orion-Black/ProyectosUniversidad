package Ordenamiento1.TareaColeccionLinkedList;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.Border;

public class RoundBorder implements Border {
    private boolean roundTopLeft = true;
    private boolean roundTopRight = true;

    private int radius;

    public RoundBorder(int radius) {
        this.radius = radius;
    }
    /*
    public RoundBorder(int radius, boolean roundTopLeft, boolean roundTopRight) {
        this.radius = radius;
        this.roundTopLeft = roundTopLeft;
        this.roundTopRight = roundTopRight;
    }

     */

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return false; // establece la opacidad del borde como transparente
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(c.getBackground());
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }

    /*
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.setColor(c.getBackground());
        if (roundTopLeft) {
            g.drawRoundRect(x, y, radius, radius, radius, radius);
        } else {
            g.drawLine(x, y, x + radius, y);
            g.drawLine(x, y, x, y + radius);
        }
        if (roundTopRight) {
            g.drawRoundRect(x + width - radius, y, radius, radius, radius, radius);
        } else {
            g.drawLine(x + width - radius, y, x + width, y);
            g.drawLine(x + width, y, x + width, y + radius);
        }
        //g.drawLine(x + radius, y, x + width - radius, y);
        //g.drawLine(x + radius, y + height - 1, x + width - radius, y + height - 1);
        //g.drawLine(x, y + radius, x, y + height - 2);
        //g.drawLine(x + width - 1, y + radius, x + width - 1, y + height - 2);
    }

     */


    public Shape getBorderShape(int x, int y, int w, int h) {
        return new RoundRectangle2D.Double(x, y, w, h, radius, radius);
    }
}


