package com.projectcloud.reportms.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class WebSite implements Serializable {

    private Long id;
    private String name;
    private Category category;
    private String description;
}
