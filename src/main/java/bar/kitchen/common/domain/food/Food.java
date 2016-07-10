package bar.kitchen.common.domain.food;

import bar.kitchen.common.domain.account.AccountItem;

public class Food extends AccountItem {
  private String name;

  public Food (String id, float price, String name) {
    super(id, price);
    this.name = name;
  }

  public String getName() {
    return name;
  }
}


