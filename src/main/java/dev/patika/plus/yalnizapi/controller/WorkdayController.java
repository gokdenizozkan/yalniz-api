package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.workday.WorkdayDto;
import dev.patika.plus.yalnizapi.entity.Workday;
import dev.patika.plus.yalnizapi.service.WorkdayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workdays")
public class WorkdayController {
    private final WorkdayService workdayService;

    public WorkdayController(WorkdayService workdayService) {
        this.workdayService = workdayService;
    }

    @GetMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public List<Workday> findAll() {
        return workdayService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Workday findById(long id) {
        return workdayService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public Workday save(WorkdayDto workdayDto) {
        return workdayService.save(workdayDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public Workday update(@PathVariable long id, @RequestBody WorkdayDto workdayDto) {
        return workdayService.update(id, workdayDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable long id) {
        workdayService.deleteById(id);
    }

}
