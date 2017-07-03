package com.cuandorindov2.main.resources.responses;

/**
 * Created by tomaslingotti on 6/29/17.
 */
public class HeartBeatResponse {

    private String status;

    public HeartBeatResponse() {
    }

    public HeartBeatResponse(String status) {
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "HeartBeatResponse{" +
                "status='" + status + '\'' +
                '}';
    }
}
