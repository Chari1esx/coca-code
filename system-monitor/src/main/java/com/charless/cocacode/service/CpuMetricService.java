package com.charless.cocacode.service;

import com.charless.cocacode.common.model.BaseResponse;

public interface CpuMetricService {
    BaseResponse<?> getCpuLoad();
}
