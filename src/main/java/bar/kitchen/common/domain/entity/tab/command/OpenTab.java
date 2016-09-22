package bar.kitchen.common.domain.entity.tab.command;

import bar.kitchen.common.domain.command.Command;

import java.util.UUID;

public class OpenTab implements Command{
  private UUID id;
  private int tableNumber;
  private UUID waiterId;

  public OpenTab(int tableNumber, UUID waiterId) {
    this.id = UUID.randomUUID();
    this.tableNumber = tableNumber;
    this.waiterId = waiterId;
  }

  public UUID id() {
    return id;
  }

  public int tableNumber() {
    return tableNumber;
  }

  public UUID waiterId() {
    return waiterId;
  }
}
