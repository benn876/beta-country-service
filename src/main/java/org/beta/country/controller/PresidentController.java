package org.beta.country.controller;

import lombok.RequiredArgsConstructor;
import org.beta.country.model.President;
import org.beta.country.service.PresidentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("presidents")
@RequiredArgsConstructor
public class PresidentController {
    private final PresidentService presidentService;

    @GetMapping
    public List<President> getAll() {
        return presidentService.getAll();
    }

    @PostMapping
    public President create(@RequestBody President president) {
        return presidentService.createPresident(president);
    }
}
