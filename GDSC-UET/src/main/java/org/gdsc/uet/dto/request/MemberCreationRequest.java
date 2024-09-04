package org.gdsc.uet.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.entity.Activity;
import org.gdsc.uet.entity.Award;
import org.gdsc.uet.entity.Member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberCreationRequest {
    String fullName;
    String email;
    String university;
    String generation;
    String positionName;
    String teamName;
    List<String> awardList = new ArrayList<>();
    Date joiningDate;
    Date leavingDate;
    String description;
    List<Activity> activities = new ArrayList<>();
    String favouriteQuote;
    String linkAvatar;
    String linkFb;
    String linkLinkedin;
    String linkGithub;
}
