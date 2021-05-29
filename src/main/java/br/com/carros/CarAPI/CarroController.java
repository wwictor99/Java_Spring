package br.com.carros.CarAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/carros")
public class CarroController {
    @Autowired
    private CarroRepository repository;

    @PostMapping()
    public ResponseEntity<Carro> cadastrarCarro(@RequestBody Carro carro) {
        return ResponseEntity.ok(repository.save(carro));
    }

    @GetMapping()
    public ResponseEntity <List<Carro>> listarCarro() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarCarro(@PathVariable Long id, @RequestBody Carro alteraçoesNoCarro) {
        repository.findById(id);
        Optional<Carro> possivelCarro = repository.findById(id);
        if (possivelCarro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Carro carro = possivelCarro.get();
        carro.setAno(alteraçoesNoCarro.getAno());
        carro.setCor(alteraçoesNoCarro.getCor());
        carro.setPlaca(alteraçoesNoCarro.getPlaca());
        carro.setModelo(alteraçoesNoCarro.getModelo());
        return ResponseEntity.ok(repository.save(carro));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCarro(@PathVariable Long id){
        Optional<Carro> possivelCarro = repository.findById(id);
        if (possivelCarro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
