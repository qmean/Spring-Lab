package study.ch06.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.ch06.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
