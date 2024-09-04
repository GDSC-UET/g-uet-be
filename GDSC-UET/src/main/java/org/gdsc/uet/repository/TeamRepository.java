package org.gdsc.uet.repository;

import org.gdsc.uet.entity.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {

    void deleteTeamsByName(String name);

    Team findByName(String teamName);
}
