package techbasics.restservice.api.v2.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ApiModel(value="PersonV2")//Api model names must be unique for springFox to differentiate them
public class Person {

	private String name;
	private Date dateOfBirth;
	private List<String> qualifications;

}