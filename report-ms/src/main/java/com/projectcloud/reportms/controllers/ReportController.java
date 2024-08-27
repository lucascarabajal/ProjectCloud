package com.projectcloud.reportms.controllers;

import com.projectcloud.reportms.Service.ReportService;
import com.projectcloud.reportms.models.Company;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "report")
@AllArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping(path = "{name}")
    public ResponseEntity<Map<String, String>> getReport(@PathVariable String name) {
        Map<String, String> map = Map.of("report",reportService.makeReport(name));
        return ResponseEntity.ok(map);
    }

    @PostMapping()
    public ResponseEntity<String> postReport(@RequestBody String report) {
        return ResponseEntity.ok(this.reportService.saveReport(report));
    }

    @DeleteMapping(path = "{name}")
    public ResponseEntity<String> deleteReport(@PathVariable String name) {
        this.reportService.deleteReport(name);
        return ResponseEntity.ok("DELETE REPORT");
    }
}
