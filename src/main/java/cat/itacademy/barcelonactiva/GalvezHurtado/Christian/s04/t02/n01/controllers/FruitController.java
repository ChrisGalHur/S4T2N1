package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s04.t02.n01.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping(value = "/fruit")
public class FruitController {
    @Autowired
    FruitRepository fruitRepository;

    @GetMapping(value = "/getOne/{id}")
    public ResponseEntity<Fruit> getOne(@PathVariable("id") long id){
        Optional<Fruit> fruitData = fruitRepository.findById(id);

        if(fruitData.isPresent()){
            return new ResponseEntity<>(fruitData.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping(value = "/add")
    public ResponseEntity<Fruit> add(@RequestBody Fruit fruitAdd){
        try{
            Fruit fruitAddIn = fruitRepository.save(new Fruit(fruitAdd.getName(),
                    fruitAdd.getQuilosQuantity()));
            return new ResponseEntity<>(fruitAddIn, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Fruit> update(@PathVariable("id") long id,@RequestBody Fruit fruitModify){
        Optional<Fruit> fruitData = fruitRepository.findById(id);

        if(fruitData.isPresent()){
            Fruit fruitModifying = fruitData.get();
            fruitModifying.setName(fruitModify.getName());
            fruitModifying.setQuilosQuantity(fruitModify.getQuilosQuantity());
            return new ResponseEntity<>(fruitRepository.save(fruitModifying), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id){
        try{
            fruitRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits(@RequestParam(required = false)String name){
        try{
            List<Fruit> fruits = new ArrayList<Fruit>();

            if (name == null) {
                fruitRepository.findAll().forEach(fruits::add);
            }else {
                fruitRepository.findByName(name).forEach(fruits::add);
            }

            if (fruits.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(fruits, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/HelloWorld")
    public String saluda(@RequestParam(defaultValue = "UNKNOW") String name){//Definimos que si es llamado con la recepción de un nombre lo recibirá, de no ser así name = UNKNOW
        return "Hello, " + name + ". You are running a Maven project";
    }
}
