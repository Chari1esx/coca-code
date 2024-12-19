package com.charless.cocacode.controller;

import com.charless.cocacode.common.model.ResponseEntity;
import com.charless.cocacode.service.CpuMetricService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/system")
public class SystemMetricController {

    @Resource
    private CpuMetricService cpuMetricService;

    @GetMapping("/cpu/load")
    public ResponseEntity<?> getCpuLoad() {
        return cpuMetricService.getCpuLoad();
    }

}
