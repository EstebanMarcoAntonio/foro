package foro.alura.api.controller;

import foro.alura.api.topico.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    public void registrarTopico(@RequestBody DatosRegistroTopico datosRegistroTopico){
        topicoRepository.save(new Topico(datosRegistroTopico));
    }

    @GetMapping
    public Page<DatosListadoTopico> listadoTopico(Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosListadoTopico> obtenerTopicoPorId(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(topico -> ResponseEntity.ok(new DatosListadoTopico(topico)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }
}
