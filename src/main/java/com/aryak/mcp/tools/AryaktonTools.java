package com.aryak.mcp.tools;

import com.aryak.mcp.model.Resident;
import com.aryak.mcp.repository.ResidentRepository;
import com.github.javafaker.Faker;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class AryaktonTools {

    private final AtomicLong counter = new AtomicLong(1_00_000);

    private final ResidentRepository residentRepository;

    public AryaktonTools(final ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    /**
     * @return the ZonedDateTime in a fictional town called Aryakton
     */
    @McpTool(name = "get_local_time",
            description = "returns the current local time in a fictional town called 'Aryakton'")
    public LocalDateTime getTimeInAryakton() {
        return LocalDateTime.now(ZoneId.of("Europe/London"));
    }

    /**
     * @return the population in a fictional town called Aryakton
     */
    @McpTool(name = "get_current_population",
            description = "returns the current population of the fictional town called 'Aryakton'")
    public long getCurrentPopulationInAryakton() {
        return residentRepository.count();
    }

    // for simulation
    @Scheduled(fixedDelay = 500)
    void incrementCounter() {
        addResident();
        counter.incrementAndGet();
    }

    private void addResident() {
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String address = faker.address().fullAddress();
        Resident resident = new Resident(name, address);
        residentRepository.save(resident);
    }

    /**
     * @return the residents in a fictional town called Aryakton
     */
    @McpTool(name = "get_residents",
            description = "returns the resident info of the fictional town called 'Aryakton'")
    public List<Resident> getCurrentPopulationInAryakton(
            @McpToolParam(required = false, description = "The number of residents to be returned(limit)") int limit) {

        List<Resident> residents = new ArrayList<>();
        List<Resident> all = residentRepository.findAll();
        for (Resident resident : all) {
            if (residents.size() < limit) {
                residents.add(resident);
            }
        }
        return residents;
    }

    /**
     * @return the all places in a fictional town called Aryakton
     */
    @McpTool(name = "get_places",
            description = "returns the names of some places in the fictional town called 'Aryakton'")
    public List<String> getPlacesInAryakton() {

        // actual API call
        ParameterizedTypeReference<List<String>> bodyType =
                new ParameterizedTypeReference<>() {
                };
        RestClient restClient = RestClient.create();
        return restClient.get()
                .uri("http://localhost:8080/cities")
                .retrieve()
                .body(bodyType);

    }
}
