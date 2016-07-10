package bar.kitchen.common.domain.tab.steps;

import bar.kitchen.common.domain.event.Event;
import bar.kitchen.common.domain.tab.Tab;
import bar.kitchen.common.domain.tab.command.OpenTab;
import bar.kitchen.common.domain.tab.event.TabOpened;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

/**
 * Created by IONER on 10/07/2016.
 */
public class TabSteps {

    private String waiter;
    private int table;
    private Tab tab;
    private List<Event> eventList;

    @Given("^a customer and the waiter \"([^\"]*)\" are at the table (\\d+)$")
    public void customerIsOnTable(final String waiter, final int table) {
        this.waiter = waiter;
        this.table = table;
    }

    @When("^customer ask waiter to \"([^\"]*)\"$")
    public void customerAskWaiterTo(final String action) {
        tab = new Tab();
        switch (action) {
            case "openTab":
                eventList = tab.handle(new OpenTab(table, waiter));
                break;
            default:
                throw new RuntimeException("Undefined action");
        }
    }

    @Then("^the tab is \"([^\"]*)\"$")
    public void theTabIs(final String tabStatus) {
        assertThat(eventList, not(empty()));
        assertThat(eventList, hasItem(isA(TabOpened.class)));
    }

    @And("^the tab table is (\\d+)$")
    public void theTabTableIs(int table) {
        assertThat(table, equalTo(this.table));
    }

    @And("^the tab waiter is \"([^\"]*)\"$")
    public void theTabWaiterIs(String waiter) {
        assertThat(waiter, equalTo(this.waiter));
    }
}
