package bar.kitchen.common.domain.entity.waiter;

import bar.kitchen.common.domain.entity.Entity;
import bar.kitchen.common.domain.entity.tab.Tab;
import bar.kitchen.common.domain.entity.tab.command.OpenTab;
import bar.kitchen.common.domain.entity.tab.event.TabOpened;
import bar.kitchen.common.domain.entity.waiter.command.HireWaiter;
import bar.kitchen.common.domain.entity.waiter.event.WaiterHired;
import bar.kitchen.common.domain.event.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Waiter extends Entity {

  private String name;
  private List<Tab> tabs;

  public Waiter(String id, String name) {
    super(UUID.fromString(id));
    this.name = name;
  }

  public Waiter() {
      super(null);
  }


  public List<Event> handle(OpenTab openTabCommand) {
    Tab tab = new Tab(openTabCommand.tableNumber(), openTabCommand.waiterId());
    this.tabs.add(tab);

    final TabOpened tabOpened = new TabOpened(tab.id(),tab.table(),tab.waiter());
    return new ArrayList<Event>(){{add(tabOpened);}};

  }

  public void apply(TabOpened tabOpened){
    tabs.add(new Tab(tabOpened.id(), tabOpened.tableNumber(), tabOpened.waiterId()));
  }


  public List<Event> handle(HireWaiter hireWaiter) {
    this.name = hireWaiter.name();
    final WaiterHired waiterHired = new WaiterHired(this.id(), this.name);
    return new ArrayList<Event>(){{add(waiterHired);}};
  }

  public void apply(WaiterHired waiterHired) {
    this.id = waiterHired.id();
    this.name = waiterHired.name();
  }
}
