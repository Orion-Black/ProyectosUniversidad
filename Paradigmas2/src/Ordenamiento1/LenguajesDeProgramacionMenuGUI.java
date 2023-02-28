package Ordenamiento1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class LenguajesDeProgramacionMenuGUI extends JFrame {
    static LinkedList<String> listaLenguajesDeProgramacion;
    static DefaultListModel<String> modeloLista;

    public void llenarLinkedListLenguajes() {
        modeloLista.removeAllElements();
        for (int i = 0; i < listaLenguajesDeProgramacion.size(); i++) {
            modeloLista.addElement(listaLenguajesDeProgramacion.get(i));
        }
    }

    public LenguajesDeProgramacionMenuGUI() {
        super("Lenguajes de programación 2021");
        listaLenguajesDeProgramacion = new LinkedList<>();
        listaLenguajesDeProgramacion.add("C++");

        modeloLista = new DefaultListModel<>();
        llenarLinkedListLenguajes();

        // Crear componentes
        JLabel etiquetaTitulo = new JLabel("Lenguajes de programación 2021");
        JLabel etiquetaAgregar = new JLabel("Agregar lenguaje:");

        JTextField campoAgregar = new JTextField(10);
        JButton botonAgregar = new JButton("Agregar");
        JList<String> lista = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(lista);

        JButton botonAgregarInicio = new JButton("Agregar al inicio");
        JButton botonAgregarFinal = new JButton("Agregar al final");

        // Agregar componentes a contenedor
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.setBackground(new Color(255, 204, 204)); // Cambiar color de fondo del contenedor
        contenedor.add(etiquetaTitulo, BorderLayout.NORTH);
        contenedor.add(scrollLista, BorderLayout.CENTER);

        JPanel panelAgregar = new JPanel();
        panelAgregar.setBackground(new Color(204, 255, 204)); // Cambiar color de fondo del panel
        panelAgregar.add(etiquetaAgregar);
        panelAgregar.add(campoAgregar);
        panelAgregar.add(botonAgregar);
        panelAgregar.add(botonAgregarInicio);
        panelAgregar.add(botonAgregarFinal);
        contenedor.add(panelAgregar, BorderLayout.SOUTH);

        // Configurar comportamiento de componentes
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lenguaje = campoAgregar.getText();
                if (!lenguaje.isEmpty()) {
                    listaLenguajesDeProgramacion.add(lenguaje);
                    modeloLista.addElement(lenguaje);
                    campoAgregar.setText("");
                }
            }
        });

        botonAgregarInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lenguaje = campoAgregar.getText();
                if (!lenguaje.isEmpty()) {
                    listaLenguajesDeProgramacion.addFirst(lenguaje);
                    modeloLista.add(0, lenguaje);
                    campoAgregar.setText("");
                }
            }
        });

        botonAgregarFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String lenguaje = campoAgregar.getText();
                if (!lenguaje.isEmpty()) {
                    listaLenguajesDeProgramacion.addLast(lenguaje);
                    modeloLista.addElement(lenguaje);
                    campoAgregar.setText("");
                }
            }
        });

        // Configurar ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centrar ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LenguajesDeProgramacionMenuGUI();
            }
        });
    }
}
