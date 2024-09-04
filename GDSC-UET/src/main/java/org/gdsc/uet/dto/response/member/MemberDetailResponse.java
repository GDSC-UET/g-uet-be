package org.gdsc.uet.dto.response.member;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.gdsc.uet.entity.Activity;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberDetailResponse {
    String fullName;
    String email;
    String university;
    String generation;
    String positionName;
    String teamName;
    List<String> awardList;
    Date joiningDate;
    Date leavingDate;
    String description;
    List<Activity> activities;
    String favouriteQuote;
    String link_avatar;
    String link_fb;
    String link_linkedin;
    String link_github;
}
