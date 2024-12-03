package dev.trabajo.publicaciones;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "publicaciones")
public class Publicacion {

    @Id
    private String id;
    private String userId;
    private String content;
    private String imageUrl;
    private String createdAt;

}
