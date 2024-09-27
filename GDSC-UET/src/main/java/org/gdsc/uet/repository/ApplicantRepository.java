package org.gdsc.uet.repository;

import org.gdsc.uet.entity.Applicant;
import org.gdsc.uet.entity.Position;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends MongoRepository<Applicant, String> {
//    Integer countByPosition(Position position);
}
