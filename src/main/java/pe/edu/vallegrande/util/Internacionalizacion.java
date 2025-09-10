package pe.edu.vallegrande.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Internacionalizacion {
    public static ResourceBundle obtenerMensajes() {
        Locale locale = Locale.getDefault();
        return ResourceBundle.getBundle("mensaje", locale);
    }

    public static String obtenerIdiomaSistema() {
        return Locale.getDefault().getLanguage();
    }
}