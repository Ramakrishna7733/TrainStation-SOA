
package com.klef.soa.docker.entity;

import jakarta.persistence.*;

@Entity
@Table(
    name = "trainstation",
    uniqueConstraints = @UniqueConstraint(
        name = "trainstationcode",
        columnNames = "stationcode"
    )
)
public class TrainStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stationname", nullable = false, length = 100)
    private String stationName;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(name = "platformcount", nullable = false)
    private Integer platformCount;

    @Column(name = "stationcode", nullable = false, length = 10, unique = true)
    private String stationCode;

    public TrainStation() {
    }

    public TrainStation(String stationName, String city,
                        Integer platformCount, String stationCode) {
        this.stationName = stationName;
        this.city = city;
        this.platformCount = platformCount;
        this.stationCode = stationCode;
    }

    public Long getId() {
        return id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPlatformCount() {
        return platformCount;
    }

    public void setPlatformCount(Integer platformCount) {
        this.platformCount = platformCount;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }
}
