package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s04.t02.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name= "Products")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "KG")
    private int quilosQuantity;

    public Fruit() {
    }

    public Fruit(String name, int quilosQuantity) {
        this.name = name;
        this.quilosQuantity = quilosQuantity;
    }

    public long getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuilosQuantity() {
        return quilosQuantity;
    }

    public void setQuilosQuantity(int quilosQuantity) {
        this.quilosQuantity = quilosQuantity;
    }

    @Override
    public String toString() {
        return "ID:" + id + " Fruit: " + name + " Quilos Cuantity:" + quilosQuantity;
    }
}
