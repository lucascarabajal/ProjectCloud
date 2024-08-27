package com.projectcloud.reportms.helpers;

import com.projectcloud.reportms.models.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getPlaceholdersFromTemplate(String template){
        String[] split = template.split("\\{");

        return Arrays.stream(split)
                .filter(line->!line.isEmpty())
                .map(line ->{
                    var index = line.indexOf('}');
                    return line.substring(0,index);
                }).toList();
    }
}
