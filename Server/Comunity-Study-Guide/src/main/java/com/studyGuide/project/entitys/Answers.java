package com.studyGuide.project.entitys;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratedColumn;

import java.io.Serializable;

@Entity
@Table(name = "Answers")
@Getter
@Setter
@NoArgsConstructor
public class Answers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(255)")
    private String text;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    Question question;

}
