package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }
    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mapping-get-v1");
        return "ok";
    }
    @GetMapping( "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }

    /**
     * pathVariable 사용
     * 받는 변수와 사용변수 명이 동일하면 pathVariable 매핑은 생략해도됨
     * @param data
     * @return
     */
//    @GetMapping("/mapping/{userId}")
//    public String mappingPathV1(@PathVariable("userId") String data) {
//        log.info("mappingPath userId={}", data);
//        return "ok";
//    }

    @GetMapping("/mapping/{userId}")
    public String mappingPathV2(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    /**
     * pathVariable 다중 사용
     * @param userId
     * @param orderId
     * @return
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPathV3(@PathVariable String userId, @PathVariable String orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터 추가로 매핑
     * params="mode"
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug"
     * params={"mode=debug", "data=good"}
     */
    @GetMapping(value = "/mapping-param", params= "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode"
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug"
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces ="text/html"
     * consumes="!text/html"
     * consumes="text/*"
     * consumes="*\/*"
     */
    @PostMapping(value = "/mapping-consume", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
