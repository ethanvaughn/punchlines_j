package dev.punchlines;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.health.actuate.endpoint.HealthDescriptor;
import org.springframework.boot.health.actuate.endpoint.HealthEndpoint;
import org.springframework.boot.health.actuate.endpoint.IndicatedHealthDescriptor;
import org.springframework.boot.health.contributor.Health;

class HealthQueryControllerTest {
    @Test
    void returnsActuatorHealthStatusCode() throws Exception {
        HealthEndpoint healthEndpoint = mock(HealthEndpoint.class);
        var constructor = IndicatedHealthDescriptor.class.getDeclaredConstructor(Health.class);
        constructor.setAccessible(true);
        HealthDescriptor healthDescriptor = constructor.newInstance(Health.down().build());
        when(healthEndpoint.health()).thenReturn(healthDescriptor);

        HealthQueryController controller = new HealthQueryController(healthEndpoint);

        assertEquals("DOWN", controller.health());
    }
}