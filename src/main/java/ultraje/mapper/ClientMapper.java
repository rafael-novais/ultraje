package ultraje.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ultraje.domain.dto.client.ClientToRegister;
import ultraje.domain.dto.client.ClientLogin;
import ultraje.domain.dto.client.ClientLoginVO;
import ultraje.domain.dto.client.ClientToList;
import ultraje.domain.dto.client.FullProfileResponse;
import ultraje.domain.entity.Client;

@Component
public class ClientMapper {

	public FullProfileResponse clientToFullProfileResponse(Client client) {
		FullProfileResponse response = new FullProfileResponse();
		response.setId(client.getId());
		response.setName(client.getName());
		response.setEmail(client.getEmail());
		response.setNickname(client.getNickname());
		response.setSalary(client.getSalary());
		response.setAccountNumber(client.getAccountNumber());
		response.setCreditCard(client.getAccountNumber());
		response.setProfiles(client.getProfiles());
		return response;
	}
	
	public Client registerDtoToClient(ClientToRegister clientDto) {
		Client client = new Client();
		client.setName(clientDto.getName());
		client.setEmail(clientDto.getEmail());
		client.setPassword(clientDto.getPassword());
		return client;
	}
	
	public List<ClientToList> clientToList(List<Client> clientList) {
		List<ClientToList> clientToList = new ArrayList<>();
		clientList.forEach(client -> {
			clientToList.add(new ClientToList(client));
		});
		return clientToList;
	}
	
	public ClientLogin fromClientLoginVo(ClientLoginVO loginVo) {
		ClientLogin login = new ClientLogin();
		login.setEmail(loginVo.getEmail());
		login.setPassword(loginVo.getPassword());
		return login;
	}
	
}
