package br.com.forum_hub.controller;



import br.com.forum_hub.model.Autor;
import br.com.forum_hub.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<Autor> listar() {
        return autorRepository.findAll();
    }

    @PostMapping
    @Transactional
    public Autor criar(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }
}
