package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    @Query("SELECT e FROM Entry e WHERE e.user = ?1")
    List<Entry> findAllFromUser(User user);
}
