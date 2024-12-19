package com.charless.cocacode.service.impl;

import com.charless.cocacode.common.constant.AppConstant;
import com.charless.cocacode.common.model.HttpResponseBody;
import com.charless.cocacode.common.utils.HttpResponseUtil;
import com.charless.cocacode.service.CpuMetricService;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

@Service
public class CpuMetricServiceImpl implements CpuMetricService {

    private final SystemInfo systemInfo = new SystemInfo();

    @Override
    public HttpResponseBody<?> getCpuLoad() {
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        CentralProcessor processor = hardware.getProcessor();
        return HttpResponseUtil.success(processor.getProcessorCpuLoad(AppConstant.CPU_LOAD_DELAYS_MS));
    }

}
