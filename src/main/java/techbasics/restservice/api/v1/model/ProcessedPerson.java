package techbasics.restservice.api.v1.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ApiModel(value="ProcessedPersonV1")//Api model names must be unique for springFox to differentiate them
public class ProcessedPerson {

	private String name;
	private boolean over18;
	private int numberOfQualifications;

}
