package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class Ventana extends JFrame {
    private JPanel panel1;
    private JButton botonpanel1;
    private JLabel etiquetaPanel1;

    private JPanel panel2;
    private JLabel etiquetaPanel2;
    private JPanel panel3;
    private JComboBox<String> comboBoxPanel3;
    private JPanel panel4;
    private GridLayout layout;

    public Ventana(String title) throws HeadlessException {
        super(title);
        setSize(800, 600);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panel 1
        panel1 = new JPanel();
        panel1.setBackground(new Color(51, 255, 181));
        botonpanel1 = new JButton("presioname");
        panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel1.add(botonpanel1);
        etiquetaPanel1 = new JLabel("....");
        panel1.add(etiquetaPanel1);
        botonpanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                etiquetaPanel1.setText("Presionaste el boton del panel 1");
            }
        });

        this.getContentPane().add(panel1, 0);

        //panel 2
        String urlImagen = "https://media.tenor.com/DtVdz6DCxloAAAAM/flareon-pokemon.gif";
        panel2 = new JPanel();
        this.getContentPane().add(panel2);
        panel2.setBackground(Color.cyan);
        panel2.setLayout(new FlowLayout());
        //cargar imagen de internet

        try{
            URL url = new URL(urlImagen);
            Image imagen = ImageIO.read(url);
            ImageIcon imagenIcon = new ImageIcon(imagen);
            etiquetaPanel2 = new JLabel(imagenIcon);
            panel2.add(etiquetaPanel2);
            this.getContentPane().add(panel2, 1);

        }catch (MalformedURLException mue){
            System.out.println("Url no valida");
        }catch (Exception e){
            System.out.println("Error al cargar la imagen");
        }

        //panel 3
        panel3 = new JPanel();
        this.getContentPane().add(panel3);
        panel3.setBackground(Color.GREEN);

        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        String[] elementos = {"Opcion 1","Opcion 2","Opcion 3","Opcion 4"};
        comboBoxPanel3 = new JComboBox<>(elementos);
        comboBoxPanel3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getSource().toString());
                System.out.println(comboBoxPanel3.getSelectedIndex());
            }
        });
        panel3.add(comboBoxPanel3);
        this.getContentPane().add(panel3, 2);
        //panel 4
        panel4 = new JPanel();
        this.getContentPane().add(panel4);
        panel4.setBackground(Color.MAGENTA);
        this.getContentPane().add(panel4, 3);


        this.setVisible(true);
    }
}
