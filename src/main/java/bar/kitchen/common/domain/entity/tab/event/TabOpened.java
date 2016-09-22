package bar.kitchen.common.domain.entity.tab.event;

import bar.kitchen.common.domain.event.Event;

import java.util.UUID;

public class TabOpened implements Event{
  private UUID id;
  private UUID tabId;
  private int tableNumber;
  private UUID waiterId;

  public TabOpened(UUID tabId, int tableNumber, UUID waiterId) {
    this.tabId = tabId;
    id = UUID.randomUUID();
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

  public UUID tabId() {
    return tabId;
  }
}
