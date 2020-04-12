package techbasics.restservice.api.v1.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ApiModel(value="PersonV1")//Api model names must be unique for springFox to differentiate them
public class Person {

	private String name;
	private int age;
	private List<String> qualifications;

}