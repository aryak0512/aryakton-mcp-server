package com.aryak.mcp.tools;

import org.springaicommunity.mcp.annotation.McpTool;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class MyTools {

    private final AtomicLong counter = new AtomicLong(1_00_000);

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
        return counter.get();
    }

    // for simulation
    @Scheduled(fixedDelay = 5)
    void incrementCounter() {
        counter.incrementAndGet();
    }
}
