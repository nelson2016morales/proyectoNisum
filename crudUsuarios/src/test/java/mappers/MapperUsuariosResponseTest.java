package mappers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.testBci.jpa.entity.Usuarios;
import dtos.UsuariosResponseDto;
import java.time.Instant;
import java.util.UUID;

class MapperUsuariosResponseTest {

	private MapperUsuariosResponse sut;
	
	@BeforeEach
    public void setup() {
        sut = new MapperUsuariosResponse();
    }
	
	@Test 
    public void MapToUsuariosResponseDto() {
        
		// given
		UUID uuid = UUID.randomUUID();
		Instant now = Instant.now();
		
    	Usuarios entity = new Usuarios();
    	
        entity.setId(uuid);
        entity.setCreated(now);
        entity.setModified(now);
        entity.setLastLogin(now);        
        entity.setToken("token");
        entity.setIsActive(true);

        // when
        UsuariosResponseDto aDto = sut.Map(entity);

        // then
        assertEquals(aDto.getId(),uuid);
        assertEquals(aDto.getCreated(),now);
        assertEquals(aDto.getModified(),now);
        assertEquals(aDto.getLastLogin(),now);
        assertEquals(aDto.getToken(),"token");
        assertEquals(aDto.getIsActive(),true);        
    }
}
