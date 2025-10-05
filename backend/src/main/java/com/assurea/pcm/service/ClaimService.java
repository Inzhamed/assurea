package com.assurea.pcm.service;

import com.assurea.pcm.model.Claim;
import com.assurea.pcm.repository.ClaimRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClaimService {
    private final ClaimRepository repo;

    public ClaimService(ClaimRepository repo) {
        this.repo = repo;
    }

    public List<Claim> getAll() {
        return repo.findAll();
    }

    public Claim getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Claim save(Claim claim) {
        return repo.save(claim);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}