package bar.kitchen.common.domain.tab;

import bar.kitchen.common.domain.tab.command.OpenTab;
import bar.kitchen.common.domain.tab.event.TabOpened;
import bar.kitchen.common.domain.event.Event;

import java.util.ArrayList;
import java.util.List;

public class Tab {
  private int table;
  private String waiter;
  private List<TabItem> list;

  public void apply (TabOpened tabOpenedEvent) {
    table = tabOpenedEvent.tableNumber();
    waiter = tabOpenedEvent.waiter();
  }

  public List<Event> handle(OpenTab openTabCommand) {
    TabOpened tabOpened = new TabOpened(openTabCommand.tableNumber(),openTabCommand.waiter());
    apply(tabOpened);
    return new ArrayList<Event>(){{add(tabOpened);}};
  }

  public int table() {
    return table;
  }

  public String waiter() {
    return waiter;
  }
}
