package bar.kitchen.common.domain.tab.event;

import bar.kitchen.common.domain.event.Event;

public class TabOpened implements Event{
  public String id;
  public int tableNumber;
  public String waiter;
}
