
package com.klef.soa.docker.service;

import java.util.List;
import java.util.Optional;

import com.klef.soa.docker.dto.TrainStationRequest;
import com.klef.soa.docker.entity.TrainStation;

public interface TrainStationService {

    TrainStation add(TrainStationRequest request);

    List<TrainStation> displayAll();

    Optional<TrainStation> getById(Long id);

    TrainStation update(TrainStationRequest request, Long id);

    String delete(Long id);
}
