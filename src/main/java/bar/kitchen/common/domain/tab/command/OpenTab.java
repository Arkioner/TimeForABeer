package bar.kitchen.common.domain.tab.command;

import bar.kitchen.common.domain.command.Command;

import java.util.UUID;

public class OpenTab implements Command{
  private UUID id;
  private int tableNumber;
  private String waiter;

  public OpenTab(int tableNumber, String waiter) {
    this.id = UUID.randomUUID();
    this.tableNumber = tableNumber;
    this.waiter = waiter;
  }

  public UUID id() {
    return id;
  }

  public int tableNumber() {
    return tableNumber;
  }

  public String waiter() {
    return waiter;
  }
}
