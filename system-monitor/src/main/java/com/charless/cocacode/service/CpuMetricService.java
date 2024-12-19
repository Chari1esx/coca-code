package com.charless.cocacode.service;

import com.charless.cocacode.common.model.HttpResponseBody;

public interface CpuMetricService {

    HttpResponseBody<?> getCpuLoad();

}
