package infrastructure.spring.configuration;

/**
 * Created by IONER on 05/07/2016.
 */
public class GeoColorPaletteConfiguration {

    /*public RegisterColorUseCase registerColorUseCase(
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
    }*/
}
