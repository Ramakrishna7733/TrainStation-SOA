
package com.klef.soa.docker.controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.docker.dto.TrainStationRequest;
import com.klef.soa.docker.entity.TrainStation;
import com.klef.soa.docker.service.TrainStationService;

@RestController
@RequestMapping("/station")
@CrossOrigin(origins = "*")
public class TrainStationController {

    @Autowired
    private TrainStationService service;

    @PostMapping("/add")
    public TrainStation add(@Valid @RequestBody TrainStationRequest request) {
        return service.add(request);
    }

    @GetMapping("/displayall")
    public List<TrainStation> displayAll() {
        return service.displayAll();
    }

    @GetMapping("/displaybyid/{id}")
    public Optional<TrainStation> displayById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/update/{id}")
    public TrainStation update(@Valid @RequestBody TrainStationRequest request,
                               @PathVariable Long id) {
        return service.update(request, id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
