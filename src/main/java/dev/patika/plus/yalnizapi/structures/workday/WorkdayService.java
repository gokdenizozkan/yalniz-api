package dev.patika.plus.yalnizapi.structures.workday;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class WorkdayService {
    private final WorkdayRepository workdayRepository;

    public WorkdayService(WorkdayRepository workdayRepository) {
        this.workdayRepository = workdayRepository;
    }

    public Workday save(@RequestBody Workday workday) {
        return workdayRepository.save(workday);
    }

    public List<Workday> findAll() {
        return workdayRepository.findAll();
    }

    public Workday findById(long id) {
        return workdayRepository.findById(id).orElseThrow();
    }

    public Workday update(long id, Workday workday) {
        Workday w = workdayRepository.findById(id).orElseThrow();
        workday.setId(w.getId());
        return workdayRepository.save(workday);
    }

    public void deleteById(long id) {
        workdayRepository.deleteById(id);
    }
}
