package dev.punchlines.line;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class LineController {
    private final LineRepository lineRepository;

    public LineController(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    @QueryMapping(name = "get_all")
    public List<Line> getAll() {
        return lineRepository.findAll();
    }
}
