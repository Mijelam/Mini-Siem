package com.Mijelam.mini_siem.service;

import com.Mijelam.mini_siem.model.LogEvent;
import com.Mijelam.mini_siem.repository.LogEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class LogEventService {

    private final LogEventRepository logEventRepository;
    private final Random rand = new Random();

    private final List<String> sources = List.
            of("Firewall", "Web Server", "Auth Service", "Database");

    private final List<String> levels = List.of("INFO", "WARNING", "CRITICAL");
    private final List<String> messages = List.of(
            "Multiple failed login attempts",
            "Suspicious IP detected",
            "Database connection timeout",
            "User privilege escalation",
            "Malware signature found",
            "Unusual outbound traffic detected"
    );

    public void generator(){

        new Thread(() -> {
            while (true) {
                LogEvent event = LogEvent.builder()
                        .source(randomElement(sources))
                        .level(randomElement(levels))
                        .message(randomElement(messages))
                        .timestamp(LocalDateTime.now())
                        .build();

                logEventRepository.save(event);
                System.out.println(" New event: " + event);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
    private String randomElement(List<String> events) {
        return events.get(rand.nextInt(events.size()));
    }
}
