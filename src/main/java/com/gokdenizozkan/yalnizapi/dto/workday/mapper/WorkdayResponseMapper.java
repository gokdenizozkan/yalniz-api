package com.gokdenizozkan.yalnizapi.dto.workday.mapper;

import com.gokdenizozkan.yalnizapi.dto.workday.response.WorkdayResponse;
import com.gokdenizozkan.yalnizapi.entity.Workday;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class WorkdayResponseMapper implements Function<Workday, WorkdayResponse> {
        @Override
        public WorkdayResponse apply(Workday workday) {
            return new WorkdayResponse(
                    workday.getId(),
                    workday.getDate(),
                    workday.getVet().getId()
            );
        }
}
