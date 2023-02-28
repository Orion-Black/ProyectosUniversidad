package PruebasFormularios;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class LenguajesDeProgramacion {
    static LinkedList<String> listaLenguajesDeProgramacion = new LinkedList<>();
    static JTextArea textArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lenguajes de programacion 2021");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel label = new JLabel("Nombre del lenguaje: ");
        JTextField textField = new JTextField();

        JButton addButton = new JButton("Añadir elemento");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lenguaje = textField.getText();
                listaLenguajesDeProgramacion.add(lenguaje);
                textArea.setText(getListaLenguajesDeProgramacion());
                textField.setText("");
            }
        });

        JButton addLastButton = new JButton("Añadir elemento al final");
        addLastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lenguaje = textField.getText();
                listaLenguajesDeProgramacion.addLast(lenguaje);
                textArea.setText(getListaLenguajesDeProgramacion());
                textField.setText("");
            }
        });

        JButton addFirstButton = new JButton("Añadir elemento al principio");
        addFirstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lenguaje = textField.getText();
                listaLenguajesDeProgramacion.addFirst(lenguaje);
                textArea.setText(getListaLenguajesDeProgramacion());
                textField.setText("");
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(addButton);
        panel.add(addLastButton);
        panel.add(addFirstButton);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        listPanel.add(scrollPane, BorderLayout.CENTER);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(listPanel, BorderLayout.CENTER);

        frame.setVisible(true);

        listaLenguajesDeProgramacion.add("C++");
        textArea.setText(getListaLenguajesDeProgramacion());
    }

    private static String getListaLenguajesDeProgramacion() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de lenguajes de programacion: \n");
        for (String lenguaje : listaLenguajesDeProgramacion) {
            sb.append("-").append(lenguaje).append("\n");
        }
        return sb.toString();
    }
}

