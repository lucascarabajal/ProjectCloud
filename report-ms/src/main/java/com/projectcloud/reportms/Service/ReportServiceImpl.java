package com.projectcloud.reportms.Service;

import com.projectcloud.reportms.helpers.ReportHelper;
import com.projectcloud.reportms.models.Company;
import com.projectcloud.reportms.models.WebSite;
import com.projectcloud.reportms.repositories.CompaniesRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImpl implements ReportService {

    private final CompaniesRepository companiesRepository;
    private final ReportHelper reportHelper;

    @Override
    public String makeReport(String name) {
        return reportHelper.readTemplate(companiesRepository.getByName(name).orElseThrow());
    }

    @Override
    public String saveReport(String report) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<String> placeholders = this.reportHelper.getPlaceholdersFromTemplate(report);
        List<WebSite> webSites = Stream.of(placeholders.get(3))
                .map(webSite -> WebSite.builder()
                        .name(webSite).build())
                .toList();

        Company company = Company.builder()
                .name(placeholders.get(0))
                .foundationDate(LocalDate.parse(placeholders.get(1),formatter))
                .founder(placeholders.get(2))
                .webSites(webSites)
                .build();

        companiesRepository.postByName(company);
        return "Saved";
    }

    @Override
    public void deleteReport(String name) {
        this.companiesRepository.deleteByName(name);
    }
}
