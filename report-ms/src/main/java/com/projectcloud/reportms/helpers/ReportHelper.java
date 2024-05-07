package com.projectcloud.reportms.helpers;

import com.projectcloud.reportms.models.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReportHelper {

    @Value("${report.template}")
    private String template;

    public String readTemplate(Company company){
        return template
                .replace("{company}", company.getName())
                .replace("{foundation_date}", company.getFounder()).toLowerCase()
                .replace("{founder}",company.getFounder())
                .replace("{web_sites}",company.getWebSites().toString());
    }
}
