package bar.kitchen.common.domain.entity.waiter.commandHandler;

import bar.kitchen.common.domain.command.CommandSubscriber;
import bar.kitchen.common.domain.entity.waiter.Waiter;
import bar.kitchen.common.domain.entity.waiter.WaiterRepository;
import bar.kitchen.common.domain.entity.waiter.command.HireWaiter;

public class HireWaiterCommandHandler extends CommandSubscriber<HireWaiter>{

    private WaiterRepository waiterRepository;

    public HireWaiterCommandHandler(WaiterRepository waiterRepository) {
        this.waiterRepository = waiterRepository;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(HireWaiter hireWaiter) {
        Waiter waiter = new Waiter();
        waiterRepository.save(waiter.id(), waiter.handle(hireWaiter));
    }
}
