package study.ch06.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import study.ch06.enumerated.Currency;

@Entity
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private double price;

    @Enumerated(EnumType.STRING)
    private Currency currency;
}
