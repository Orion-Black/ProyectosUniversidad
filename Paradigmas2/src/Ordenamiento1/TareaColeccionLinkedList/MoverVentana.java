package Ordenamiento1.TareaColeccionLinkedList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MoverVentana extends JFrame {

    private JPanel panel;
    private Point mouseDownCompCoords = null;

    public MoverVentana() {
        super("Mover ventana al arrastrar panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 300));
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
            }
        });

        getContentPane().add(panel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new MoverVentana();
    }
}

