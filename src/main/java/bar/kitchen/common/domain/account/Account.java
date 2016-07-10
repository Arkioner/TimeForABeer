package bar.kitchen.common.domain.account;

import bar.kitchen.common.domain.account.command.OpenAccount;

import java.util.List;

public class Account {
  private List<AccountItem> list;

  public void apply(OpenAccount openAccountCommand) {

  }
}
