package pl.takecareofmyanimal.dto;

import lombok.*;

import java.math.BigDecimal;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AdvertDTO {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private Long userId;
}
