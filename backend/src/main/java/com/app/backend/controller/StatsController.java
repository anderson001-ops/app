package com.app.backend.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.backend.service.StatsService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/stats")
@CrossOrigin(origins = "*")
public class StatsController {
    @Autowired
    private StatsService statsService;

    @GetMapping
    public Map<String, Long> getStats() {
        return statsService.getStats();
    }
}