package bar.kitchen.common.domain.drink;

import bar.kitchen.common.domain.tab.TabItem;

public class Drink extends TabItem {
  private String name;

  public Drink (String id, float price, String name) {
    super(id, price);
    this.name = name;
  }

  public String getName() {
    return name;
  }
}