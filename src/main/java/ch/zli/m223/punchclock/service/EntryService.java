package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.exceptions.EntryNotFoundException;
import ch.zli.m223.punchclock.repository.EntryRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class EntryService {
    private EntryRepository entryRepository;

    private SessionService sessionService;

    public EntryService(EntryRepository entryRepository, SessionService sessionService) {
        this.entryRepository = entryRepository;
        this.sessionService = sessionService;
    }

    public Entry createEntry(Entry entry, Principal principal) {
        entry.setUser(sessionService.getUserByUsername(principal.getName()));
        return entryRepository.saveAndFlush(entry);
    }

    public Entry updateEntry(Entry entry) {
        if(entryRepository.findById(entry.getId()).isPresent()) {
            return entryRepository.saveAndFlush(entry);
        }
        throw new EntryNotFoundException();
    }

    public List<Entry> findAll(Principal principal) {
        return entryRepository.findAllFromUser(sessionService.getUserByUsername(principal.getName()));
    }

    public void deleteEntry(Long id) {
        try {
            entryRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new EntryNotFoundException();
        }
    }
}
