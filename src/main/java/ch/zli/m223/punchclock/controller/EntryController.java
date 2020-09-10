package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.security.Principal;
import java.util.List;

/**
 * Controller fürs Erstellen, Ändern und Löschen von Zeiteinträgen
 */
@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    /**
     * Gibt alle Zeiteinträge des aktiven Users zurück
     * @param principal Aktiver User (wird automatisch über Bean injiziert)
     * @return Liste der Zeiteinträge des Users
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Entry> getAllEntries(Principal principal) {
        return entryService.findAll(principal);
    }

    /**
     * Erstellt einen neuen Zeiteintrag
     * @param entry neuer Zeiteintrag aus RequestBody
     * @param principal Aktiver User (wird direkt beim Zeiteintrag hinterlegt)
     * @return neu erstellter Zeiteintrag
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@Valid @RequestBody Entry entry, Principal principal) {
        return entryService.createEntry(entry, principal);
    }

    /**
     * Aktualisiert einen Zeiteintrag
     * @param entry Zeiteintrag mit Werten, die aktualisiert werden sollen
     * @param principal Aktiver User
     * @return Zeiteintrag mit Änderungen
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Entry updateEntry(@Valid @RequestBody Entry entry, Principal principal) {
        return entryService.updateEntry(entry, principal);
    }

    /**
     * Löscht einen Zeiteintrag
     * @param id ID des Eintrag, der gelöscht wird
     */
    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEntry(@PathVariable("id") Long id){
        entryService.deleteEntry(id);
    }
}
