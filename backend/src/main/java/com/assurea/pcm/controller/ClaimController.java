package com.assurea.pcm.controller;

import com.assurea.pcm.model.Claim;
import com.assurea.pcm.service.ClaimService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
@CrossOrigin(origins = "http://localhost:4200")
public class ClaimController {
    private final ClaimService service;

    public ClaimController(ClaimService service) {
        this.service = service;
    }

    @GetMapping
    public List<Claim> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Claim getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Claim create(@Valid @RequestBody Claim claim) {
        return service.save(claim);
    }

    @PutMapping("/{id}")
    public Claim update(@PathVariable Long id, @Valid @RequestBody Claim claim) {
        claim.setId(id);
        return service.save(claim);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}