package dev.patika.plus.yalnizapi.structures.workday;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workdays")
public class WorkdayController {
    private final WorkdayService workdayService;

    public WorkdayController(WorkdayService workdayService) {
        this.workdayService = workdayService;
    }

    @GetMapping
    public List<Workday> findAll() {
        return workdayService.findAll();
    }

    @GetMapping("/{id}")
    public Workday findById(long id) {
        return workdayService.findById(id);
    }

    @PostMapping
    public Workday save(Workday workday) {
        return workdayService.save(workday);
    }

    @PutMapping("/{id}")
    public Workday update(@PathVariable long id, @RequestBody Workday workday) {
        return workdayService.update(id, workday);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        workdayService.deleteById(id);
    }

}
