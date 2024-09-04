package org.gdsc.uet.repository;

import org.gdsc.uet.entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {

    Integer countByPositionName(String positionName);

    Integer countByTeamName(String teamName);
}
