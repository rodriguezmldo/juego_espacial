package graphics;

import javax.swing.ImageIcon;
import java.net.URL;

public class Loader {

    public static ImageIcon ImageLoader(String path) {
        URL url = Loader.class.getResource(path);
        if (url != null) {
            return new ImageIcon(url);
        } else {
            System.err.println("No se pudo cargar la imagen: " + path);
            return null;
        }
    }
}
