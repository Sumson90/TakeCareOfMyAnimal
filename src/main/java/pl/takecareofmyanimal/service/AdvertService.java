package pl.takecareofmyanimal.service;

import org.springframework.stereotype.Service;
import pl.takecareofmyanimal.model.Advert;
import pl.takecareofmyanimal.repo.AdvertRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertService {
    private final AdvertRepository advertRepository;

    public AdvertService(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    public Advert createAdvert(Advert advert) {
        return advertRepository.save(advert);
    }

    public List<Advert> getAllAdverts() {
        return advertRepository.findAll();
    }

    public Optional<Advert> getAdvertById(Long id) {
        return advertRepository.findById(id);
    }

    public void updateAdvert(Advert advert) {
        advertRepository.save(advert);
    }

    public void deleteAdvertById(Long id) {
        advertRepository.deleteById(id);
    }
}
