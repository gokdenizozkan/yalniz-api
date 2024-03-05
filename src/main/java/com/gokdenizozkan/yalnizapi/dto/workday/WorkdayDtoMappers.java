package com.gokdenizozkan.yalnizapi.dto.workday;

import com.gokdenizozkan.yalnizapi.dto.workday.mapper.WorkdayResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkdayDtoMappers {
    public final WorkdayResponseMapper toResponse;
}
