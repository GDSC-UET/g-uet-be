package org.gdsc.uet.repository;

import org.gdsc.uet.entity.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
    Integer countByStatus(String status);
}
