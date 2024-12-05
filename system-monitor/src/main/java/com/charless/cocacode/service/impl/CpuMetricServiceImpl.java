package com.charless.cocacode.service.impl;

import com.charless.cocacode.common.model.BaseResponse;
import com.charless.cocacode.common.utils.ResponseUtil;
import com.charless.cocacode.service.CpuMetricService;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

import static com.charless.cocacode.common.constant.AppConstant.CPU_LOAD_DELAY_MS;

@Service
public class CpuMetricServiceImpl implements CpuMetricService {
    private final SystemInfo systemInfo = new SystemInfo();

    @Override
    public BaseResponse<?> getCpuLoad() {
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        CentralProcessor processor = hardware.getProcessor();
        return ResponseUtil.success(processor.getProcessorCpuLoad(CPU_LOAD_DELAY_MS));
    }
}
