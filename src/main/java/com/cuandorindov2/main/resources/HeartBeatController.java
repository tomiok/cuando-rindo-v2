package com.cuandorindov2.main.resources;

import com.cuandorindov2.main.resources.responses.HeartBeatResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tomas.lingotti on 26/05/17.
 */
@RestController()
public class HeartBeatController {

    private String status = "UP";

    @RequestMapping("/status/heart")
    public HeartBeatResponse sayStatus() {
        return new HeartBeatResponse(status);
    }
}
