package bar.kitchen.common.domain.entity.tab.commandhandler;

import bar.kitchen.common.domain.command.CommandSubscriber;
import bar.kitchen.common.domain.entity.tab.command.OpenTab;
import bar.kitchen.common.domain.entity.waiter.WaiterRepository;

public class OpenTabCommandHandler extends CommandSubscriber<OpenTab> {

    private final WaiterRepository waiterRepository;

    public OpenTabCommandHandler(WaiterRepository waiterRepository) {
        this.waiterRepository = waiterRepository;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(OpenTab openTab) {
        waiterRepository.getById(openTab.waiterId())
                .doOnNext(waiter -> waiterRepository.save(
                        waiter.id(),
                        waiter.handle(openTab)
                    )
                )
                .subscribe();

    }
}
