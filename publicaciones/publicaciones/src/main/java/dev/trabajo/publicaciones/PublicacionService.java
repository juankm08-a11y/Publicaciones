package dev.trabajo.publicaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;


    public Publicacion createPublicacion(Publicacion publicacion) {
        return publicacionRepository.save(publicacion);
    }


    public List<Publicacion> getPublicacionesByUserId(String userId) {
        return publicacionRepository.findByUserId(userId);
    }


    public Publicacion updatePublicacion(String id, Publicacion publicacion) {
        Optional<Publicacion> existingPublicacion = publicacionRepository.findById(id);
        if (existingPublicacion.isPresent()) {
            Publicacion pub = existingPublicacion.get();
            pub.setContent(publicacion.getContent());
            pub.setImageUrl(publicacion.getImageUrl());

            return publicacionRepository.save(pub);
        }
        return null;
    }


    public void deletePublicacion(String id) {
        publicacionRepository.deleteById(id);
    }
}
