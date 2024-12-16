package com.example.monumentosv2.models;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class MonumentoRepository {

    private HashMap<Long, Monumento> monumentos = new HashMap<>();
    private AtomicLong counter = new AtomicLong(0);

    @PostConstruct
    public void init() {
        add(Monumento.builder()
                .id(1L)
                .countryCode("ES")
                .countryName("Spain")
                .cityName("Madrid")
                .latitude(40.4165)
                .longitude(-3.70256)
                .name("Puerta de Alcalá")
                .description("The Puerta de Alcalá is a Neo-classical monument in the Plaza de la Independencia in Madrid, Spain.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Puerta_de_Alcal%C3%A1%2C_Madrid%2C_Espa%C3%B1a%2C_2014-12-20%2C_DD_01.JPG/800px-Puerta_de_Alcal%C3%A1%2C_Madrid%2C_Espa%C3%B1a%2C_2014-12-20%2C_DD_01.JPG")
                .build());
        add(Monumento.builder()
                .id(2L)
                .countryCode("ES")
                .countryName("Spain")
                .cityName("Barcelona")
                .latitude(41.3851)
                .longitude(2.1734)
                .name("Sagrada Familia")
                .description("The Basílica de la Sagrada Família, also known as the Sagrada Família, is a large unfinished Roman Catholic minor basilica in Barcelona, Catalonia, Spain.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Barcelona_-_Sagrada_Familia_-_2015_%281%29.jpg/800px-Barcelona_-_Sagrada_Familia_-_2015_%281%29.jpg")
                .build());
        add(Monumento.builder()
                .id(3L)
                .countryCode("FR")
                .countryName("France")
                .cityName("Paris")
                .latitude(48.8566)
                .longitude(2.3522)
                .name("Eiffel Tower")
                .description("The Eiffel Tower is a wrought-iron lattice tower on the Champ de Mars in Paris, France.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Tour_Eiffel_Wikimedia_Commons.jpg/800px-Tour_Eiffel_Wikimedia_Commons.jpg")
                .build());
        add(Monumento.builder()
                .id(4L)
                .countryCode("IT")
                .countryName("Italy")
                .cityName("Rome")
                .latitude(41.9028)
                .longitude(12.4964)
                .name("Colosseum")
                .description("The Colosseum is an oval amphitheatre in the centre of the city of Rome, Italy.")
                .image("https://upload.wikimedia.org/wikipedia/commons/thumb/6/66/Colosseo_2020.jpg/800px-Colosseo_2020.jpg")
                .build());
    }

    public Monumento add(Monumento monumento) {
        long id = counter.incrementAndGet();
        monumento.setId(id);
        monumentos.put(id, monumento);
        return monumento;
    }

    public Optional<Monumento> get(Long id) {
        return Optional.ofNullable((Monumento) monumentos.get(id));
    }

    public List<Monumento> getAll() {
        return List.copyOf(monumentos.values());
    }

    public Optional<Monumento> edit(Long id, Monumento newMonument) {
        return Optional.ofNullable(monumentos.computeIfPresent(id, (k, v) -> {
            v.setCityName(newMonument.getCityName());
            v.setImage(newMonument.getImage());
            v.setDescription(newMonument.getDescription());
            v.setLatitude(newMonument.getLatitude());
            v.setCountryCode(newMonument.getCountryCode());
            v.setLongitude(newMonument.getLongitude());
            v.setCountryName(newMonument.getCountryName());
            v.setName(newMonument.getName());

            return v;
        }));
    }

    public void delete(Long id) {
        monumentos.remove(id);
    }

    public List<Monumento> query(double maxLatitude, String sortDirection) {
        List<Monumento> data = new ArrayList<>(monumentos.values());
        List<Monumento> result;

        if (maxLatitude < 0) {
            result = data;
        } else {
            result = data
                    .stream()
                    .filter(m -> m.getLatitude() <= maxLatitude)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        if (sortDirection.equalsIgnoreCase("asc"))
            result.sort(Comparator.comparing(Monumento::getName));
        else if (sortDirection.equalsIgnoreCase("desc"))
            result.sort(Comparator.comparing(Monumento::getName).reversed());

        return Collections.unmodifiableList(result);
    }


}

