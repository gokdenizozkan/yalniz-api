package dev.patika.plus.yalnizapi.controller;

import dev.patika.plus.yalnizapi.dto.workday.WorkdayDto;
import dev.patika.plus.yalnizapi.entity.Workday;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.service.WorkdayService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Workday>> findAll() {
        Response<List<Workday>> response = workdayService.findAll();
        return ResponseEntity.status(response.code()).body(response.data());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.OK)
    public ResponseEntity<Workday> findById(long id) {
        Response<Workday> response = workdayService.findById(id);
        return ResponseEntity.status(response.code()).body(response.data());
    }

    @PostMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public ResponseEntity<Workday> save(@RequestBody WorkdayDto workdayDto) {
        Response<Workday> response = workdayService.save(workdayDto);
        return ResponseEntity.status(response.code()).body(response.data());
    }

    @PutMapping("/")
    @ResponseStatus(code = org.springframework.http.HttpStatus.ACCEPTED)
    public ResponseEntity<Workday> update(@RequestBody WorkdayDto workdayDto) {
        Response<Workday> response = workdayService.update(workdayDto);
        return ResponseEntity.status(response.code()).body(response.data());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public ResponseEntity<Workday> deleteById(@PathVariable long id) {
        Response<Workday> response = workdayService.deleteById(id);
        return ResponseEntity.status(response.code()).body(response.data());
    }
}
