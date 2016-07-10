package bar.kitchen.common.domain.tab;

public abstract class TabItem {
  private String id;
  private float price;

  public TabItem(String id, float price) {
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
