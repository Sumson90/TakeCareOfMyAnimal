package pl.takecareofmyanimal.controllers;

import org.springframework.web.bind.annotation.*;
import pl.takecareofmyanimal.model.Advert;
import pl.takecareofmyanimal.service.AdvertService;

import java.util.List;

@RestController
@RequestMapping("/adverts")
public class AdvertController {
    private final AdvertService advertService;

    public AdvertController(AdvertService advertService) {
        this.advertService = advertService;
    }

    @PostMapping
    public Advert createAdvert(@RequestBody Advert advert) {
        return advertService.createAdvert(advert);
    }

    @GetMapping
    public List<Advert> getAllAdverts() {
        return advertService.getAllAdverts();
    }

    @GetMapping("/{id}")
    public Advert getAdvertById(@PathVariable Long id) {
        return advertService.getAdvertById(id)
                .orElseThrow();
    }}