package mappers;

import com.testBci.jpa.entity.Usuarios;

import dtos.UsuariosResponseDto;

public class MapperUsuariosResponse {
	
	public MapperUsuariosResponse() {}

	public UsuariosResponseDto Map(Usuarios usuarioRequest){
		UsuariosResponseDto dto = new UsuariosResponseDto();
		dto.setId(usuarioRequest.getId());
		dto.setCreated(usuarioRequest.getCreated());
		dto.setModified(usuarioRequest.getModified());
		dto.setLastLogin(usuarioRequest.getLastLogin());
		dto.setToken(usuarioRequest.getToken());
		dto.setIsActive(usuarioRequest.getIsActive());
		return dto;
	}
}
