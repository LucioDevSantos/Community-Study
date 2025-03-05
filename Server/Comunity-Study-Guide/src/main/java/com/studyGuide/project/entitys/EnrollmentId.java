package com.studyGuide.project.entitys;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Data
public class EnrollmentId implements Serializable {

    private Long userId;
    private Long  communityId;


}
