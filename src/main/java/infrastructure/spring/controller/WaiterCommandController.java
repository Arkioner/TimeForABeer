package infrastructure.spring.controller;

import bar.kitchen.common.domain.command.CommandBus;
import bar.kitchen.common.domain.entity.waiter.command.HireWaiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class WaiterCommandController {

    private CommandBus commandBus;

    @Autowired
    public WaiterCommandController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @RequestMapping(method = POST, path = "/hireWaiterCommand")
    public void hireWaiterCommand(@RequestBody HireWaiter hireWaiter) {
        this.commandBus.dispatch(hireWaiter);
    }


}
