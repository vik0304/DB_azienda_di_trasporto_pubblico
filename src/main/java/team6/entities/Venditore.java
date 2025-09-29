package team6.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Venditore {
    @Id
    @GeneratedValue
    protected UUID id;

}
