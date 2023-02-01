package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s04.t02.n01.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> { //Aquí creamos los métodos que no existan en JPA (incluidos
    List<Fruit> findByName(String name);
}
