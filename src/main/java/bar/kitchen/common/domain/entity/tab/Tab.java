package bar.kitchen.common.domain.entity.tab;

import bar.kitchen.common.domain.entity.Entity;
import bar.kitchen.common.domain.entity.tab.command.OpenTab;
import bar.kitchen.common.domain.entity.tab.event.TabOpened;
import bar.kitchen.common.domain.event.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Tab extends Entity {
  private int table;
  private String waiter;
  private List<TabItem> list;

  public Tab(UUID id, int table, String waiter) {
    super(id);
    this.table = table;
    this.waiter = waiter;
  }

  public void apply (TabOpened tabOpenedEvent) {
    table = tabOpenedEvent.tableNumber();
    waiter = tabOpenedEvent.waiter();
  }

  public List<Event> handle(OpenTab openTabCommand) {
    table = openTabCommand.tableNumber();
    waiter = openTabCommand.waiter();
    final TabOpened tabOpened = new TabOpened(openTabCommand.tableNumber(),openTabCommand.waiter());
    return new ArrayList<Event>(){{add(tabOpened);}};
  }

  public int table() {
    return table;
  }

  public String waiter() {
    return waiter;
  }
}
