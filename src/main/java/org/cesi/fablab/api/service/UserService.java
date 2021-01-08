package org.cesi.fablab.api.service;

import java.util.List;

import org.cesi.fablab.api.dto.UserDTO;

public interface UserService {
	public List<UserDTO> getAllUsers() throws Exception;
	public void addUser(UserDTO dto) throws Exception;
	public void removeUser(UserDTO dto) throws Exception;
	public void updateUser(UserDTO dto) throws Exception;

}
