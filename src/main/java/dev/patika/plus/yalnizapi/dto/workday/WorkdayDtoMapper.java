package dev.patika.plus.yalnizapi.dto.workday;

import dev.patika.plus.yalnizapi.entity.Workday;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class WorkdayDtoMapper implements Function<Workday, WorkdayDto> {
    @Override
    public WorkdayDto apply(Workday workday) {
        return new WorkdayDto(
                workday.getId(),
                workday.getDate(),
                workday.getVet().getId());
    }
}
