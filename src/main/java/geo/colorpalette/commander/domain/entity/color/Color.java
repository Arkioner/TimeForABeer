package geo.colorpalette.commander.domain.entity.color;

/**
 * Created by IONER on 03/07/2016.
 */
public class Color {
    private int minValue = 0;
    private int maxValue = 255;

    private String name;
    private int red;
    private int green;
    private int blue;

    public Color(String name, int red, int green, int blue) {
        setName(name);
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    private void setName(String name) {
        if(name == null || name.isEmpty()) {
            throw new InvalidColorException("The color name cant be empty");
        }
        this.name = name;
    }

    private void setRed(int red) {
        checkColorValueInRange(red);
        this.red = red;
    }

    private void setGreen(int green) {
        checkColorValueInRange(green);
        this.green = green;
    }

    private void setBlue(int blue) {
        checkColorValueInRange(blue);
        this.blue = blue;
    }

    private void checkColorValueInRange(int colorValue) {
        if (!(minValue <= colorValue && colorValue <= maxValue)) {
            throw new InvalidColorException("The color value is invalid");
        }
    }

    public static Color defaultColor() {
        return new Color("default", 0, 0, 0);
    }

    public int red() {
        return red;
    }

    public int green() {
        return green;
    }

    public int blue() {
        return blue;
    }
}
