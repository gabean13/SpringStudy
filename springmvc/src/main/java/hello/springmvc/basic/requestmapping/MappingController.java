package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    /**
     * 편리한 축약 애노테이션 (코드보기)
     *
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping("/mapping-get-v1")
    public String mappingGet() {
        log.info("mappingGet");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("info data = {}", data);
        return "ok";
    }

    @PostMapping("/mapping/users/{userid}/orders/{order}")
    public String mappingPaths(@PathVariable String userid, @PathVariable String order) {
        log.info("userid = {}", userid);
        log.info("order = {}", order);
        return "ok";
    }

    @GetMapping(value = "/mapping-params", params = "mode=debug")
    public String mappingParams() {
        log.info("mappingParams");
        return "ok";
    }

    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    @PostMapping(value = "mapping-consume", consumes = "application/json")
    public String mappingConsume() {
        log.info("mappingConsume");
        return "ok";
    }

    @PostMapping(value = "mapping-produce", produces = "application/json")
    public String mappingProduce() {
        log.info("mappingProduce");
        return "ok";
    }
}
