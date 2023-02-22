package cs.ubb.microservice2.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DataDto implements Serializable {
    private String name;
    private DurationDto duration;
}
