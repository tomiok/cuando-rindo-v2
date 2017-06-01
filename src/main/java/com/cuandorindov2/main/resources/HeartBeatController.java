package com.cuandorindov2.main.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tomas.lingotti on 26/05/17.
 */
@RestController("/status")
public class HeartBeatController {

    private String status = "UP";

    @RequestMapping("/heart")
    public String sayStatus() {
        return this.status;
    }
}
