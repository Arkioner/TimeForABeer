package geo.colorpalette.commander.domain.command.color;

/**
 * Created by IONER on 05/07/2016.
 */
public class DefineColor implements ColorCommand{
    private String name;
    private int red;
    private int green;
    private int blue;

    public DefineColor(String name, int red, int green, int blue) {
        this.name = name;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public String name() {
        return name;
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
