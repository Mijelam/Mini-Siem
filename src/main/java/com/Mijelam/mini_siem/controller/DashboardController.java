package com.Mijelam.mini_siem.controller;

import com.Mijelam.mini_siem.model.LogEvent;
import com.Mijelam.mini_siem.repository.LogEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class DashboardController {
    private final LogEventRepository logEventRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<LogEvent> events = logEventRepository
                .findAll(Sort.by(Sort.Direction.DESC, "timestamp"))
                .stream()
                .limit(10)
                .collect(Collectors.toList());
        model.addAttribute("events", events);
        model.addAttribute("criticalCount", logEventRepository.countByLevel("CRITICAL"));
        model.addAttribute("warningCount", logEventRepository.countByLevel("WARNING"));
        model.addAttribute("infoCount", logEventRepository.countByLevel("INFO"));
        return "newdashboard";
    }
}
