package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    //private final Logger log = LoggerFactory.getLogger(getClass());
    @RequestMapping("/log-test")
    public String logTest(){

        String name = "spring";

        log.trace("trace log = {}", name);
        log.debug("debug log = {})", name);
        log.info("debug log = {})", name);
        log.warn("debug log = {})", name);
        log.error("debug log = {})", name);

        return "ok";
    }
}