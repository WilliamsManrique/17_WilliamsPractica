package pe.edu.vallegrande;

import pe.edu.vallegrande.interfaz.InterfazDeBienvenida;
import pe.edu.vallegrande.logica.ControladorSaludo;
import javax.swing.*; // ← AÑADE ESTA IMPORTACIÓN (incluye JOptionPane)
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Configuración avanzada del Look and Feel
        configurarLookAndFeel();

        SwingUtilities.invokeLater(() -> {
            try {
                InterfazDeBienvenida interfaz = new InterfazDeBienvenida();
                ControladorSaludo controlador = new ControladorSaludo(interfaz);
                interfaz.setControlador(controlador);
                interfaz.mostrar();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "Error al iniciar la aplicación: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private static void configurarLookAndFeel() {
        try {
            // Intentar con Nimbus (más moderno)
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    return;
                }
            }
            // Fallback al sistema
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("No se pudo configurar el Look and Feel: " + e.getMessage());
        }
    }
}