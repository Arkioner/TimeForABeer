package bar.kitchen.common.domain.account;

public abstract class AccountItem {
  private String id;
  private float price;

  public AccountItem(String id, float price) {
    this.id = id;
    this.price = price;
  }

  public String getId() {
    return id;
  }

  public float getPrice() {
    return price;
  }
}
