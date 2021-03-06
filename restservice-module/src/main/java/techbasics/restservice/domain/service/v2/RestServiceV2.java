package techbasics.restservice.domain.service.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techbasics.common.annotaiton.UncaughtExceptionHandler;
import techbasics.common.manager.PersonManager;
import techbasics.restservice.api.v2.model.Person;
import techbasics.restservice.api.v2.model.ProcessedPerson;
import techbasics.restservice.mapper.PersonMapper;
import techbasics.restservice.mapper.ProcessedPersonMapper;

// Service layer should contain only input validation and calls to manager classes.
// No non-domain classes are to be passed into the manager layer, mapping between api and domain classes to take place here.

@RestController
@RequestMapping("/restService/v2")
@Slf4j
@UncaughtExceptionHandler
public class RestServiceV2 {

	@Autowired
	private PersonManager personManager;

	@PostMapping(value = "/processPerson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProcessedPerson> processPerson(@RequestBody Person person) {
		techbasics.common.domain.model.Person p = PersonMapper.INSTANCE.mapToDomain(person);

		techbasics.common.domain.model.ProcessedPerson pp = personManager.processPerson(p);

		return new ResponseEntity<>(ProcessedPersonMapper.INSTANCE.mapToV2(pp), HttpStatus.OK);
	}

}

