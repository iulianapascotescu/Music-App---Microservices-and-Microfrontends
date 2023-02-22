package cs.ubb.microservice2.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DurationDto implements Serializable {
    private long totalMilliseconds;
}
