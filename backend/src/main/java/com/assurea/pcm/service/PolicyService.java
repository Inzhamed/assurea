package com.assurea.pcm.service;

import com.assurea.pcm.model.Policy;
import com.assurea.pcm.repository.PolicyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PolicyService {
    private final PolicyRepository repo;

    public PolicyService(PolicyRepository repo) {
        this.repo = repo;
    }

    public List<Policy> getAll() {
        return repo.findAll();
    }

    public Policy getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Policy save(Policy policy) {
        return repo.save(policy);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}