package dev.abeatriz.crud.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name", nullable = false, length = 100)
    private String firstName;
    @Column(name="last_name", nullable = false, length = 100)
    private String lastName;
    private int age;
    @Column(nullable = false, length = 100)
    private String occupation;
    @Column(nullable = false, length = 20)
    private String phone;
    @Column(nullable = false, length = 100)
    private String mail;



}
