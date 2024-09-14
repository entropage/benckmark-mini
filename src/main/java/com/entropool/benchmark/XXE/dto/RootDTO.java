package com.entropool.benchmark.XXE.dto;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class RootDTO {
    private String someField;
    // getters and setters
    public String toString() {
        return "RootDTO{" +
                "someField='" + someField + '\'' +
                '}';
    }
}
