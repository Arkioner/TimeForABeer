package geo.colorpalette.commander.application.service.color.register;

import geo.colorpalette.commander.domain.command.Command;

/**
 * Created by IONER on 03/07/2016.
 */
public class RegisterColorCommand implements Command {

    private String name;
    private int red;
    private int green;
    private int blue;

    public RegisterColorCommand(String name, int red, int green, int blue) {
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
