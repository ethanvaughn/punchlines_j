package dev.punchlines;

import org.springframework.boot.health.actuate.endpoint.HealthEndpoint;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HealthQueryController {
    private final HealthEndpoint healthEndpoint;

    public HealthQueryController(HealthEndpoint healthEndpoint) {
        this.healthEndpoint = healthEndpoint;
    }

    @QueryMapping
    public String health() {
        return healthEndpoint.health().getStatus().getCode();
    }
}