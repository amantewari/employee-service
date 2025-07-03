package com.example.employeeservice.controller;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import com.example.employeeservice.model.Employee;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
  private Map<Long,Employee> store = new ConcurrentHashMap<>();

  @GetMapping public Collection<Employee> all() { return store.values(); }
  @PostMapping public Employee create(@RequestBody Employee e) {
    long id = System.currentTimeMillis();
    e.setId(id);
    store.put(id, e);
    return e;
  }
  @PutMapping("/{id}") public Employee update(@PathVariable long id, @RequestBody Employee e) {
    e.setId(id);
    store.put(id, e);
    return e;
  }
  @DeleteMapping("/{id}") public void delete(@PathVariable long id) { store.remove(id); }
}

