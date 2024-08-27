package com.projectcloud.reportms.Service;

import com.projectcloud.reportms.models.Company;

public interface ReportService {

    String makeReport(String name);
    String saveReport(String report);
    void deleteReport(String name);
}
