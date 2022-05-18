package richardsde;

import javafx.scene.paint.Color;

public interface Transformable {
    /**
     * Changes the color of an image.
     * @param y - The y-location of a pixel.
     * @param color - The current color of the pixel.
     * @return - A new color.
     */
    public Color apply(int y, Color color);
}
