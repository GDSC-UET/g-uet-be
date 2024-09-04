package org.gdsc.uet.repository;

import org.gdsc.uet.entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends MongoRepository<Position, String> {

    Page<Position> findByTeamName(String name, Pageable pageable);

    void deleteByTeamName(String name);

    int countByTeamName(String name);

    Position findByName(String positionName);
}
