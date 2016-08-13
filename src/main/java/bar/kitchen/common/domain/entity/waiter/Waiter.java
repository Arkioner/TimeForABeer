package bar.kitchen.common.domain.entity.waiter;

import bar.kitchen.common.domain.entity.tab.Tab;
import bar.kitchen.common.domain.entity.tab.command.OpenTab;
import bar.kitchen.common.domain.entity.tab.event.TabOpened;
import bar.kitchen.common.domain.event.Event;

import java.util.ArrayList;
import java.util.List;


public class Waiter {

  private List<Waiter> waiters;

  public List<Event> handle(OpenTab openTabCommand) {
    new Tab(null, openTabCommand.tableNumber(), openTabCommand.waiter());
    final TabOpened tabOpened = new TabOpened(openTabCommand.tableNumber(),openTabCommand.waiter());
    return new ArrayList<Event>(){{add(tabOpened);}};
  }
}
