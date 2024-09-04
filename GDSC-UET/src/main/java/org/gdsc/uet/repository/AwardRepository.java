package org.gdsc.uet.repository;

import org.gdsc.uet.entity.Applicant;
import org.gdsc.uet.entity.Award;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardRepository extends MongoRepository<Award, String> {
    Award findByName(String name);
}
