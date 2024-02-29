package dtos;

import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class UsuariosResponseDtoTest {

	private UsuariosResponseDto sut;

	@BeforeEach
	public void setup() {
		sut = new UsuariosResponseDto();
	}

	@Test 
	public void createUsuariosResponseDtoTest() {
		assertNotNull(sut);        
	}
}
