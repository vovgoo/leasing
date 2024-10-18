package by.vovgoo.leasing.controllers;

import by.vovgoo.leasing.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/photos")
public class ImageController {

    private static final String UPLOAD_DIR = "images/";

    private final ImageService imageService;

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> getPhoto(@PathVariable("filename") String filename) {
        try {
            Resource resource = imageService.getImage(filename);
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(resource);
        } catch (RuntimeException | MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
