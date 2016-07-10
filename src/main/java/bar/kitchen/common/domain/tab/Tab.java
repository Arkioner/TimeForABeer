package bar.kitchen.common.domain.tab;

import bar.kitchen.common.domain.tab.command.OpenTab;
import bar.kitchen.common.domain.tab.event.TabOpened;
import bar.kitchen.common.domain.event.Event;

import java.util.ArrayList;
import java.util.List;

public class Tab {
  private List<TabItem> list;

  public void apply (TabOpened tabOpenedEvent) {

  }

  public List<Event> handle(OpenTab openTabCommand) {
    return new ArrayList<Event>(){{add(new TabOpened());}};
  }
}
