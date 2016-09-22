package infrastructure.spring.controller;

import bar.kitchen.common.domain.command.CommandBus;
import bar.kitchen.common.domain.entity.tab.command.OpenTab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class TabCommandController {


    private final CommandBus commandBus;

    @Autowired
    public TabCommandController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @RequestMapping(method = POST, path = "/openTabCommand")
    public void openTabController(@RequestBody OpenTab openTab) {
        this.commandBus.dispatch(openTab);
    }


}
