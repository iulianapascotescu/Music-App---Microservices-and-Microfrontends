package cs.ubb.microservice2.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemsDto implements Serializable {
    private DataDto data;
}
