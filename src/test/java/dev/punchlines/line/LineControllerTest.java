package dev.punchlines.line;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

class LineControllerTest {
    @Test
    void returnsEveryLineFromRepository() {
        LineRepository lineRepository = mock(LineRepository.class);
        List<Line> lines = List.of(new Line("first"), new Line(null));
        when(lineRepository.findAll()).thenReturn(lines);

        LineController controller = new LineController(lineRepository);

        assertEquals(lines, controller.getAll());
        verify(lineRepository).findAll();
    }
}
