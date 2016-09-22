package bar.kitchen.common.domain.entity.tab;

import bar.kitchen.common.domain.entity.Entity;

import java.util.List;
import java.util.UUID;

public class Tab extends Entity {
  private int table;
  private UUID waiter;
  private List<TabItem> list;

  public Tab(UUID id, int table, UUID waiter) {
    super(id);
    this.table = table;
    this.waiter = waiter;
  }

  public Tab(int table, UUID waiter) {
    super(null);
    this.table = table;
    this.waiter = waiter;
  }

  public int table() {
    return table;
  }

  public UUID waiter() {
    return waiter;
  }
}
