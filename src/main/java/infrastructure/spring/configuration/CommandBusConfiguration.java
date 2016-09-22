package infrastructure.spring.configuration;

import bar.kitchen.common.domain.command.CommandBus;
import bar.kitchen.common.domain.entity.tab.commandhandler.OpenTabCommandHandler;
import bar.kitchen.common.domain.entity.waiter.WaiterRepository;
import bar.kitchen.common.domain.entity.waiter.commandHandler.HireWaiterCommandHandler;
import bar.kitchen.common.domain.event.EventStore;
import bar.kitchen.common.infrastructure.commandbus.InMemoryCommandBus;
import bar.kitchen.common.infrastructure.eventstore.InMemoryEventStore;
import bar.kitchen.common.infrastructure.repository.EventStoreWaiterRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandBusConfiguration {

    @Bean
    public EventStore eventStore(){
        return new InMemoryEventStore();
    }

    @Bean
    public WaiterRepository waiterRepository(EventStore eventStore){
        return new EventStoreWaiterRepository(eventStore);
    }

    @Bean
    public OpenTabCommandHandler openTabCommandHandler(WaiterRepository waiterRepository){
        return new OpenTabCommandHandler(waiterRepository);
    }

    @Bean
    public HireWaiterCommandHandler hireWaiterCommandHandler(WaiterRepository waiterRepository){
        return new HireWaiterCommandHandler(waiterRepository);
    }

    @Bean
    public CommandBus commandBus(OpenTabCommandHandler openTabCommandHandler,HireWaiterCommandHandler hireWaiterCommandHandler){
        return new InMemoryCommandBus()
                .addCommandSubscriber(openTabCommandHandler)
                .addCommandSubscriber(hireWaiterCommandHandler);
    }

}
