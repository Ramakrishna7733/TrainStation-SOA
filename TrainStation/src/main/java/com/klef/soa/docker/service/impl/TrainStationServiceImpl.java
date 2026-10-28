
package com.klef.soa.docker.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.docker.dto.TrainStationRequest;
import com.klef.soa.docker.entity.TrainStation;
import com.klef.soa.docker.repository.TrainStationRepository;
import com.klef.soa.docker.service.TrainStationService;

@Service
public class TrainStationServiceImpl implements TrainStationService {

    @Autowired
    private TrainStationRepository repo;

    @Override
    public TrainStation add(TrainStationRequest request) {
        TrainStation station = new TrainStation(
                request.getStationName(),
                request.getCity(),
                request.getPlatformCount(),
                request.getStationCode()
        );

        return repo.save(station);
    }

    @Override
    public List<TrainStation> displayAll() {
        return repo.findAll();
    }

    @Override
    public Optional<TrainStation> getById(Long id) {
        return repo.findById(id);
    }

    @Override
    public TrainStation update(TrainStationRequest request, Long id) {
        Optional<TrainStation> optional = repo.findById(id);

        if (optional.isPresent()) {
            TrainStation station = optional.get();

            station.setStationName(request.getStationName());
            station.setCity(request.getCity());
            station.setPlatformCount(request.getPlatformCount());
            station.setStationCode(request.getStationCode());

            return repo.save(station);
        }

        return null;
    }

    @Override
    public String delete(Long id) {
        boolean flag = repo.existsById(id);

        if (flag) {
            repo.deleteById(id);
            return "Successfully deleted";
        }

        return "Not found";
    }
}
