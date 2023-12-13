package dev.patika.plus.yalnizapi.service;

import dev.patika.plus.yalnizapi.dto.workday.WorkdayDto;
import dev.patika.plus.yalnizapi.dto.workday.WorkdayDtoDemapper;
import dev.patika.plus.yalnizapi.dto.workday.WorkdayDtoIntegrator;
import dev.patika.plus.yalnizapi.entity.Workday;
import dev.patika.plus.yalnizapi.repository.WorkdayRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkdayService {
    private final WorkdayRepository workdayRepository;
    private final WorkdayDtoDemapper workdayDtoDemapper;
    private final WorkdayDtoIntegrator workdayDtoIntegrator;

    public WorkdayService(WorkdayRepository workdayRepository, WorkdayDtoDemapper workdayDtoDemapper, WorkdayDtoIntegrator workdayDtoIntegrator) {
        this.workdayRepository = workdayRepository;
        this.workdayDtoDemapper = workdayDtoDemapper;
        this.workdayDtoIntegrator = workdayDtoIntegrator;
    }

    public List<Workday> findAll() {
        return workdayRepository.findAll();
    }

    public Workday findById(long id) {
        return workdayRepository.findById(id).orElseThrow();
    }

    public Workday save(WorkdayDto workdayDto) {
        Workday workday = workdayDtoDemapper.apply(workdayDto);
        return workdayRepository.save(workday);
    }

    public Workday update(long id, WorkdayDto workdayDto) {
        WorkdayDto workdayDtoWithId = new WorkdayDto(id, workdayDto.date(), workdayDto.vetId());
        Workday workday = workdayDtoIntegrator.apply(workdayDtoWithId);
        return workdayRepository.save(workday);
    }

    public void deleteById(long id) {
        workdayRepository.deleteById(id);
    }
}
