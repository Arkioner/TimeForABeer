package infrastructure.spring.configuration;

import geo.colorpalette.commander.application.service.color.ColorCommandHandler;
import geo.colorpalette.commander.application.service.color.ColorQueryHandler;
import geo.colorpalette.commander.application.service.color.register.RegisterColorUseCase;
import geo.colorpalette.commander.domain.entity.color.ColorStore;
import geo.colorpalette.commander.infrastructure.commandBus.GeoColorPaletteColorCommandSubscriber;
import geo.colorpalette.commander.infrastructure.commandBus.GeoColorPaletteColorQuerySubscriber;
import infrastructure.commandbus.CommandBus;

/**
 * Created by IONER on 05/07/2016.
 */
public class GeoColorPaletteConfiguration {

    public RegisterColorUseCase registerColorUseCase(
        ColorStore colorStore
    ) {
        return new RegisterColorUseCase(colorStore);
    }

    public ColorCommandHandler colorCommandHandler(
            RegisterColorUseCase registerColorUseCase
    ) {
        return new ColorCommandHandler(registerColorUseCase);
    }

    public GeoColorPaletteColorCommandSubscriber geoColorPaletteColorCommandSubscriber(
            ColorCommandHandler colorCommandHandler
    ) {
        return new GeoColorPaletteColorCommandSubscriber(colorCommandHandler);
    }

    public ColorQueryHandler colorQueryHandler() {
        return new ColorQueryHandler();
    }

    public GeoColorPaletteColorQuerySubscriber geoColorPaletteColorQuerySubscriber(
            ColorQueryHandler colorQueryHandler
    ) {
        return new GeoColorPaletteColorQuerySubscriber(colorQueryHandler);
    }

    public CommandBus initCommandBus(
            GeoColorPaletteColorCommandSubscriber geoColorPaletteColorCommandSubscriber,
            GeoColorPaletteColorQuerySubscriber geoColorPaletteColorQuerySubscriber
    ) {
        CommandBus commandBus = new CommandBus();
        commandBus.addCommandSubscriber(geoColorPaletteColorCommandSubscriber);
        commandBus.addQuerySubscriber(geoColorPaletteColorQuerySubscriber);
        return commandBus;
    }
}
