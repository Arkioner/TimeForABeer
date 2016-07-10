package bar.kitchen.common.domain.account.command;

import bar.kitchen.common.domain.command.Command;

public class OpenAccount implements Command{
  public String id;
  public int tableNumber;
  public String waiter;
}
