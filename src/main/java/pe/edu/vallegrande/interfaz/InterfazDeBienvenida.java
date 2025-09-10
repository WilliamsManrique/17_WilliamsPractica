package pe.edu.vallegrande.interfaz;

import pe.edu.vallegrande.logica.ControladorSaludo;
import pe.edu.vallegrande.util.GestorRecursos;
import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle; // ← AÑADE ESTA IMPORTACIÓN

public class InterfazDeBienvenida {
    private JFrame ventana;
    private JPanel panel;
    private JButton botonSaludo;
    private ControladorSaludo controlador;

    public InterfazDeBienvenida() {
        inicializarInterfaz();
    }

    private void inicializarInterfaz() {
        // Configurar Look and Feel avanzado
        configurarLookAndFeel();

        ventana = new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(450, 250);
        ventana.setLocationRelativeTo(null);

        // Configurar ícono personalizado
        configurarIcono();

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(240, 248, 255));

        botonSaludo = new JButton();
        botonSaludo.setBackground(new Color(70, 130, 180));
        botonSaludo.setForeground(Color.WHITE);
        botonSaludo.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botonSaludo.setFocusPainted(false);
        botonSaludo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(new Color(240, 248, 255));
        panelBoton.add(botonSaludo);

        panel.add(panelBoton, BorderLayout.CENTER);
        ventana.add(panel);
    }

    private void configurarLookAndFeel() {
        try {
            // Usar Nimbus Look and Feel para un aspecto más moderno
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            try {
                // Fallback al sistema
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void configurarIcono() {
        Image icono = GestorRecursos.obtenerIcono();
        if (icono != null) {
            ventana.setIconImage(icono);
        }
    }

    public void setControlador(ControladorSaludo controlador) {
        this.controlador = controlador;

        // Internacionalizar la interfaz
        internacionalizarInterfaz();

        botonSaludo.addActionListener(e -> controlador.mostrarSaludoPersonalizado());
    }

    private void internacionalizarInterfaz() {
        ResourceBundle mensajes = controlador.getMensajes();
        ventana.setTitle(mensajes.getString("titulo.ventana"));
        botonSaludo.setText(mensajes.getString("boton.mostrar.saludo"));
    }

    public void mostrar() {
        ventana.setVisible(true);
    }

    public JFrame getVentana() {
        return ventana;
    }
}