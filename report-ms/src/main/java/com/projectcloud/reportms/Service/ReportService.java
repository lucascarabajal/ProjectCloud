package com.projectcloud.reportms.Service;

public interface ReportService {

    String makeReport(String name);
    String saveReport(String name);
    void deleteReport(String name);
}
