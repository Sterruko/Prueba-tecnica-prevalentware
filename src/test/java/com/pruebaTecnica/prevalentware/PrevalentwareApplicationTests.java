package com.pruebaTecnica.prevalentware;

import com.pruebaTecnica.prevalentware.dto.RoleDto;
import com.pruebaTecnica.prevalentware.dto.SessionDto;
import com.pruebaTecnica.prevalentware.entity.UserEntity;
import com.pruebaTecnica.prevalentware.exception.GenericException;
import com.pruebaTecnica.prevalentware.repository.UserRepository;
import com.pruebaTecnica.prevalentware.service.impl.RoleService;
import com.pruebaTecnica.prevalentware.service.impl.SessionService;
import com.pruebaTecnica.prevalentware.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class PrevalentwareApplicationTests {

	@MockBean
	private UserRepository userRepository;

	@MockBean
	private SessionService sessionService;

	@MockBean
	private RoleService roleService;

	@Autowired
	private UserService userService;
	@Test
	void givenAnUnauthorizedUserWhenGetAllThenThrows() throws GenericException {
		UserEntity userEntity = new UserEntity();
		userEntity.setId("1");
		userEntity.setRoleId("1");
		when(userRepository.findById(any())).thenReturn(Optional.of(userEntity));

		SessionDto sessionDto = new SessionDto();
		sessionDto.setUserId("1");
		sessionDto.setSessionToken("1");

		when(sessionService.findSessionToken(any())).thenReturn(sessionDto);

		RoleDto roleDto = new RoleDto();
		roleDto.setId("1");
		roleDto.setName("User");
		when(roleService.findById(any())).thenReturn(roleDto);

		assertThrows(GenericException.class, () -> userService.getAll("1",1,1));

	}

}
