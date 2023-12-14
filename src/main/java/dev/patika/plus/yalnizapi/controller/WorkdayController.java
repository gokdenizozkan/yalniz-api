package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.workday.WorkdayDto;
import dev.patika.plus.yalnizapi.entity.Workday;
import dev.patika.plus.yalnizapi.entity.response.Response;
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
    public Response<List<Workday>> findAll() {
        return workdayService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public Response<Workday> findById(long id) {
        return workdayService.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public Response<Workday> save(@RequestBody WorkdayDto workdayDto) {
        return workdayService.save(workdayDto);
    }

    @PutMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public Response<Workday> update(@RequestBody WorkdayDto workdayDto) {
        return workdayService.update(workdayDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public Response<Workday> deleteById(@PathVariable long id) {
        return workdayService.deleteById(id);
    }
}
