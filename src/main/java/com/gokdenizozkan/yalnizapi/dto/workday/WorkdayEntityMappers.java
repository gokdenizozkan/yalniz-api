package com.gokdenizozkan.yalnizapi.dto.workday;

import com.gokdenizozkan.yalnizapi.dto.workday.mapper.WorkdaySaveRequestDemapper;
import com.gokdenizozkan.yalnizapi.dto.workday.mapper.WorkdayUpdateRequestDemapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkdayEntityMappers {
    public final WorkdaySaveRequestDemapper fromSaveRequest;
    public final WorkdayUpdateRequestDemapper fromUpdateRequest;
}
