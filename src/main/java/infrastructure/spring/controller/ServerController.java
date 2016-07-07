package infrastructure.spring.controller;

import infrastructure.spring.GeoApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by IONER on 02/07/2016.
 */
@RestController
@RequestMapping("/server")
public class ServerController {

    @RequestMapping(method = GET, path = "/info")
    public String info() {
        return "Greetings from Spring Boot!";
    }


    @RequestMapping(method = GET, path = "/stop")
    public void stop() {
        GeoApplication.exit();
    }

}
