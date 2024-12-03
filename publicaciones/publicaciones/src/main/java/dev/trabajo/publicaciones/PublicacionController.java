package dev.trabajo.publicaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Publicacion createPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionService.createPublicacion(publicacion);
    }


    @GetMapping("/user/{userId}")
    public List<Publicacion> getPublicacionesByUserId(@PathVariable String userId) {
        return publicacionService.getPublicacionesByUserId(userId);
    }


    @PutMapping("/{id}")
    public Publicacion updatePublicacion(@PathVariable String id, @RequestBody Publicacion publicacion) {
        return publicacionService.updatePublicacion(id, publicacion);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublicacion(@PathVariable String id) {
        publicacionService.deletePublicacion(id);
    }
}
