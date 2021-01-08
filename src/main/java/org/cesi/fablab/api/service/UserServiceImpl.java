package org.cesi.fablab.api.service;

import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.dto.UserDTO;
import org.cesi.fablab.api.entity.UserEntity;
import org.cesi.fablab.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public List<UserDTO> getAllUsers() throws Exception {
		List<UserDTO> lstUsersDTO= new ArrayList<UserDTO>();
		List<UserEntity> lstUsersEntity=userRepository.findAll();
		if(lstUsersEntity != null && !lstUsersEntity.isEmpty()) {
			for(UserEntity currentUserEntity : lstUsersEntity) {
				UserDTO userDTO=new UserDTO(currentUserEntity);
				lstUsersDTO.add(userDTO);
			}
		}
		return lstUsersDTO;
	}

	@Override
	public void addUser(UserDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(UserDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserDTO dto) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
