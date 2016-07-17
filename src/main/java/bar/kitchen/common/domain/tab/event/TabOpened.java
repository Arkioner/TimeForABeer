package bar.kitchen.common.domain.tab.event;

import bar.kitchen.common.domain.event.Event;

import java.util.UUID;

public class TabOpened implements Event{
  private UUID id;
  private int tableNumber;
  private String waiter;

  public TabOpened(int tableNumber, String waiter) {
    id = UUID.randomUUID();
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
