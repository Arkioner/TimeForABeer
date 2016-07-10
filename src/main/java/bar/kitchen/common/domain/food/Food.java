package bar.kitchen.common.domain.food;

import bar.kitchen.common.domain.tab.TabItem;

public class Food extends TabItem {
  private String name;

  public Food (String id, float price, String name) {
    super(id, price);
    this.name = name;
  }

  public String getName() {
    return name;
  }
}


