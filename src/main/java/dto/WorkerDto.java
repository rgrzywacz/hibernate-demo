package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class WorkerDto {
    private String fullName;
    private String externalId;
}
