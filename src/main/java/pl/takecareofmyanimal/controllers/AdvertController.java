package pl.takecareofmyanimal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.takecareofmyanimal.dto.AdvertDTO;
import pl.takecareofmyanimal.service.AdvertService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adverts")
public class AdvertController {

    private final AdvertService advertService;

    @Autowired
    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @GetMapping
    public ResponseEntity<List<AdvertDTO>> getAllAdverts() {
        List<AdvertDTO> adverts = advertService.getAllAdverts();
        return ResponseEntity.ok(adverts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvertDTO> getAdvertById(@PathVariable Long id) {
        Optional<AdvertDTO> advertDTO = advertService.getAdvertById(id);
        if (advertDTO.isPresent()) {
            return ResponseEntity.ok(advertDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<AdvertDTO> createAdvert(@RequestBody AdvertDTO advertDTO) {
        AdvertDTO createdAdvert = advertService.createAdvert(advertDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdvert);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvertDTO> updateAdvert(@PathVariable Long id, @RequestBody AdvertDTO advertDTO) {
        AdvertDTO updatedAdvert = advertService.updateAdvert(id, advertDTO);
        return ResponseEntity.ok(updatedAdvert);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvert(@PathVariable Long id) {
        advertService.deleteAdvert(id);
        return ResponseEntity.noContent().build();
    }
}