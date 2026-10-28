
package com.klef.soa.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.klef.soa.docker.entity.TrainStation;

public interface TrainStationRepository extends JpaRepository<TrainStation, Long> {

}
