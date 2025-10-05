package com.assurea.pcm.controller;

import com.assurea.pcm.model.Policy;
import com.assurea.pcm.service.PolicyService;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/policies")
@CrossOrigin(origins = "http://localhost:4200")
public class PolicyController {
    private final PolicyService service;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Policy> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Policy getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Policy create(@Valid @RequestBody Policy policy) {
        return service.save(policy);
    }

    @PutMapping("/{id}")
    public Policy update(@PathVariable Long id, @Valid @RequestBody Policy policy) {
        policy.setId(id);
        return service.save(policy);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}