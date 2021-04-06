package ru.reybos.forum.service;

import org.springframework.stereotype.Service;
import ru.reybos.forum.model.Authority;
import ru.reybos.forum.repository.db.AuthorityRepository;

@Service
public class AuthorityService {
    private final AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public Authority findByAuthority(String authority) {
        return authorityRepository.findByAuthority(authority);
    }
}
