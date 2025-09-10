package pe.edu.vallegrande.util;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GestorRecursos {
    public static Image obtenerIcono() {
        try {
            // Intentar cargar desde recursos
            URL url = GestorRecursos.class.getClassLoader().getResource("icono.png");
            if (url != null) {
                return new ImageIcon(url).getImage();
            }

            // Intentar cargar desde archivo externo
            return new ImageIcon("icono.png").getImage();
        } catch (Exception e) {
            System.out.println("No se pudo cargar el ícono: " + e.getMessage());
            return null;
        }
    }
}