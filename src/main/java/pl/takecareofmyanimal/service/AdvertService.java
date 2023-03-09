package pl.takecareofmyanimal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.takecareofmyanimal.dto.AdvertDTO;
import pl.takecareofmyanimal.model.Advert;
import pl.takecareofmyanimal.model.User;
import pl.takecareofmyanimal.repo.AdvertRepository;
import pl.takecareofmyanimal.repo.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdvertService {

    private final AdvertRepository advertRepository;
    private final UserRepository userRepository;

    @Autowired
    public AdvertService(AdvertRepository advertRepository, UserRepository userRepository) {
        this.advertRepository = advertRepository;
        this.userRepository = userRepository;
    }

    public List<AdvertDTO> getAllAdverts() {
        return advertRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public Optional<AdvertDTO> getAdvertById(Long id) {
        return advertRepository.findById(id).map(this::convertToDto);
    }

    public AdvertDTO createAdvert(AdvertDTO advertDTO) {
        User user = userRepository.findById(advertDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Advert advert = new Advert();
        advert.setTitle(advertDTO.getTitle());
        advert.setDescription(advertDTO.getDescription());
        advert.setPrice(advertDTO.getPrice());
        advert.setUser(user);
        return convertToDto(advertRepository.save(advert));
    }

    public AdvertDTO updateAdvert(Long id, AdvertDTO advertDTO) {
        Advert advert = advertRepository.findById(id).orElseThrow(() -> new RuntimeException("Advert not found"));
        User user = userRepository.findById(advertDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        advert.setTitle(advertDTO.getTitle());
        advert.setDescription(advertDTO.getDescription());
        advert.setPrice(advertDTO.getPrice());
        advert.setUser(user);
        return convertToDto(advertRepository.save(advert));
    }

    public void deleteAdvert(Long id) {
        advertRepository.deleteById(id);
    }

    private AdvertDTO convertToDto(Advert advert) {
        AdvertDTO advertDTO = new AdvertDTO();
        advertDTO.setId(advert.getId());
        advertDTO.setTitle(advert.getTitle());
        advertDTO.setDescription(advert.getDescription());
        advertDTO.setPrice(advert.getPrice());
        advertDTO.setUserId(advert.getUser().getId());
        return advertDTO;
    }
}
