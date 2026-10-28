
package com.klef.soa.docker.dto;

import com.klef.soa.docker.entity.TrainStation;

public class TrainStationResponse {

    private Long id;
    private String stationName;
    private String city;
    private Integer platformCount;
    private String stationCode;

    public TrainStationResponse() {
    }

    public TrainStationResponse(Long id, String stationName, String city,
                                Integer platformCount, String stationCode) {
        this.id = id;
        this.stationName = stationName;
        this.city = city;
        this.platformCount = platformCount;
        this.stationCode = stationCode;
    }

    public static TrainStationResponse from(TrainStation station) {
        return new TrainStationResponse(
                station.getId(),
                station.getStationName(),
                station.getCity(),
                station.getPlatformCount(),
                station.getStationCode()
        );
    }

    public Long getId() {
        return id;
    }

    public String getStationName() {
        return stationName;
    }

    public String getCity() {
        return city;
    }

    public Integer getPlatformCount() {
        return platformCount;
    }

    public String getStationCode() {
        return stationCode;
    }
}
