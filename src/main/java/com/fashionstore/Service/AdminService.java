package com.fashionstore.Service;

import java.util.List;

import com.fashionstore.DTO.AddingAdminDTO;
import com.fashionstore.DTO.AddingAdminResponseDTO;
import com.fashionstore.DTO.AddingManagerDTO;
import com.fashionstore.DTO.AdminLoginDTO;
import com.fashionstore.DTO.ManagerResponseDTO;
import com.fashionstore.DTO.UpdatedManagerResponseDTO;
import com.fashionstore.Entities.Manager;

public interface AdminService {

	AddingAdminResponseDTO addAdmin(AddingAdminDTO addingAdminDTO);

	String adminLogin(AdminLoginDTO adminLogindto);

	Manager addManager(AddingManagerDTO addingManagerDTO);
	
	List<ManagerResponseDTO> getAllManagers();	
	
	ManagerResponseDTO getManagerById(Long managerId);
	
	String deleteManagerById(Long managerId);
	
	UpdatedManagerResponseDTO updateManager(Manager manager);

}
