package bar.kitchen.common.domain.entity.waiter.command;

import bar.kitchen.common.domain.command.Command;

public class HireWaiter implements Command{

    private String name;

    public HireWaiter() {
    }

    public HireWaiter(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
