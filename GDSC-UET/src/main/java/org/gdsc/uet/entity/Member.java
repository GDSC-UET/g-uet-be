package org.gdsc.uet.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "member")
public class Member {

    @Id
    String id;
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
