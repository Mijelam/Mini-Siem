package com.Mijelam.mini_siem.controller;

import com.Mijelam.mini_siem.service.LogEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class LogEventController {

    private final LogEventService logEventService;

    @GetMapping("/generate")
    public void startGenerator(){
        logEventService.generator();
    }
}
