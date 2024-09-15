package org.gdsc.uet.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "project")
public class Project {

    @Id
    String id;
    String name;
    String status;
    Date startedAt;
    Date finishedAt;
    double version;
    String description;
    Map<String, String> links;
    List<Member> contributors;
}