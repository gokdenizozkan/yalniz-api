package dev.patika.plus.yalnizapi.service;

import dev.patika.plus.yalnizapi.dto.workday.WorkdayDto;
import dev.patika.plus.yalnizapi.dto.workday.WorkdayDtoDemapper;
import dev.patika.plus.yalnizapi.dto.workday.WorkdayDtoIntegrator;
import dev.patika.plus.yalnizapi.entity.Workday;
import dev.patika.plus.yalnizapi.entity.response.Response;
import dev.patika.plus.yalnizapi.entity.response.ResponseBuilder;
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

    public Response<List<Workday>> findAll() {
        return ResponseBuilder.templateSuccess(workdayRepository.findAll());
    }

    public Response<Workday> findById(long id) {
        return ResponseBuilder.auto(workdayRepository.findById(id).orElse(null));
    }

    public Response<Workday> save(WorkdayDto workdayDto) {
        Workday workday = workdayDtoDemapper.apply(workdayDto);
        return ResponseBuilder.templateSuccess(workdayRepository.save(workday));
    }

    public Response<Workday> update(WorkdayDto workdayDto) {
        return ResponseBuilder.templateSuccess(workdayRepository.save(workdayDtoIntegrator.apply(workdayDto)));
    }

    public Response<Workday> deleteById(long id) {
        if (!workdayRepository.existsById(id)) {
            return ResponseBuilder.templateFail("Workday with id " + id + " does not exist!");
        }
        workdayRepository.deleteById(id);
        return ResponseBuilder.templateSuccess(null);
    }
}
