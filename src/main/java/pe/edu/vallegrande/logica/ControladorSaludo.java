package pe.edu.vallegrande.logica;

import pe.edu.vallegrande.interfaz.InterfazDeBienvenida;
import pe.edu.vallegrande.util.Internacionalizacion;
import javax.swing.*;
import java.util.ResourceBundle;

public class ControladorSaludo {
    private InterfazDeBienvenida interfaz;
    private ResourceBundle mensajes;

    public ControladorSaludo(InterfazDeBienvenida interfaz) {
        this.interfaz = interfaz;
        this.mensajes = Internacionalizacion.obtenerMensajes();

        System.out.println("Idioma detectado: " + Internacionalizacion.obtenerIdiomaSistema());
    }

    public void mostrarSaludoPersonalizado() {
        String nombre = JOptionPane.showInputDialog(
                interfaz.getVentana(),
                mensajes.getString("solicitud.nombre"),
                mensajes.getString("titulo.solicitud"),
                JOptionPane.QUESTION_MESSAGE
        );

        if (nombre != null && !nombre.trim().isEmpty()) {
            String mensaje = mensajes.getString("saludo.personalizado")
                    .replace("{0}", nombre.trim());

            JOptionPane.showMessageDialog(
                    interfaz.getVentana(),
                    mensaje,
                    mensajes.getString("titulo.saludo"),
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else if (nombre != null) {
            JOptionPane.showMessageDialog(
                    interfaz.getVentana(),
                    mensajes.getString("error.nombre.vacio"),
                    mensajes.getString("titulo.error"),
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public ResourceBundle getMensajes() {
        return mensajes;
    }
}