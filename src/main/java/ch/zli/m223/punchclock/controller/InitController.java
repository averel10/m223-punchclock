package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.domain.Department;
import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.User;
import ch.zli.m223.punchclock.service.CategoryService;
import ch.zli.m223.punchclock.service.DepartmentService;
import ch.zli.m223.punchclock.service.EntryService;
import ch.zli.m223.punchclock.service.SessionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/init")
public class InitController {
    SessionService sessionService;
    EntryService entryService;
    DepartmentService departmentService;
    CategoryService categoryService;


    public InitController(SessionService sessionService, EntryService entryService, DepartmentService departmentService, CategoryService categoryService) {
        this.sessionService = sessionService;
        this.entryService = entryService;
        this.departmentService = departmentService;
        this.categoryService = categoryService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String init() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        sessionService.signUp(user);

        Category category = new Category();
        category.setName("Testcat");

        categoryService.createCategory(category);


        Department department = new Department();
        department.setName("Testdepartment");
        department.setLocation("Testlocation");

        departmentService.createDepartment(department);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        Entry entry = new Entry();
        entry.setCheckIn(LocalDateTime.parse("2020-10-10 20:00", dateTimeFormatter));
        entry.setCheckOut(LocalDateTime.parse("2020-10-10 22:00", dateTimeFormatter));
        entry.setUser(user);
        entry.setCategory(category);
        entry.setDepartment(department);

        entryService.createEntry(entry);
        return "Initialized";
    }
}
