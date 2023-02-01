package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s04.t02.n01.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {
    List<Fruit> findByName(String name);
}
