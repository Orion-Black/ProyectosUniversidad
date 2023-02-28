package Ordenamiento1.TareaColeccionLinkedList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class RoundButton extends JButton {

    public RoundButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setPreferredSize(new Dimension(120, 40)); // Ajusta el tamaño a tus necesidades
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(0xFFC0CB)); // Color rosa claro
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40); // Bordes redondeados
        g2.setColor(getForeground());
        g2.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente en negrita y fácil de leer
        g2.drawString(getText(), getWidth() / 2 - g2.getFontMetrics().stringWidth(getText()) / 2,
                getHeight() / 2 + g2.getFontMetrics().getAscent() / 2);
        g2.dispose();
    }
}
