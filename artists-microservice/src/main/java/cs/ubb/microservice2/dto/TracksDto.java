package cs.ubb.microservice2.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TracksDto implements Serializable {
    List<ItemsDto> items;
}
