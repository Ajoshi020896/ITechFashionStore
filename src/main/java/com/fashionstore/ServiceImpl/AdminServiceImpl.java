package com.fashionstore.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionstore.DTO.AddingAdminDTO;
import com.fashionstore.DTO.AddingAdminResponseDTO;
import com.fashionstore.DTO.AddingManagerDTO;
import com.fashionstore.DTO.AdminLoginDTO;
import com.fashionstore.DTO.ManagerResponseDTO;
import com.fashionstore.DTO.UpdatedManagerResponseDTO;
import com.fashionstore.Entities.Admin;
import com.fashionstore.Entities.Manager;
import com.fashionstore.Exception.BusinessException;
import com.fashionstore.Exception.EntityNotFoundException;
import com.fashionstore.Repository.AdminRepository;
import com.fashionstore.Repository.ManagerRepository;
import com.fashionstore.Service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private ModelMapper modelMapper;

	// adding admin data
	public AddingAdminResponseDTO addAdmin(AddingAdminDTO admin1) {

		Admin adminDb = null;

		Admin admin = new Admin();

		admin.setAdminName(admin1.getAdminName());
		admin.setAdminEmail(admin1.getAdminEmail());
		admin.setAdminPassword(admin1.getAdminPassword());
		admin.setAdminAddress(admin1.getAdminAddress());
		admin.setUpdateDate(new Date());
		admin.setCreatedDate(new Date());
		admin.setAdminMobileNo(admin1.getAdminMobileNo());

		try {

			adminDb = adminRepository.save(admin);

		} catch (IllegalArgumentException e) {

			throw new BusinessException("602", "Repository error");

		}

		catch (Exception e) {

			throw new BusinessException("601", "something wrong with service layer");
		}

		AddingAdminResponseDTO response = new AddingAdminResponseDTO();

		response.setAdminAddress(adminDb.getAdminAddress());
		response.setAdminEmail(adminDb.getAdminEmail());
		response.setAdminId(adminDb.getAdminId());
		response.setAdminMobileNo(adminDb.getAdminMobileNo());
		response.setAdminName(adminDb.getAdminName());
		response.setCreatedDate(adminDb.getCreatedDate());

		return response;

	}

	// admin login
	@Override
	public String adminLogin(AdminLoginDTO adminLogindto) {

		if (adminLogindto.getAdminEmail() == null || adminLogindto.getAdminPassword() == null) {

			throw new BusinessException("602", "Email id or password can't be empty");
		}

		List<Admin> admin = adminRepository.findAll();

		for (Admin obj : admin) {

			if (obj.getAdminEmail().equals(adminLogindto.getAdminEmail())
					&& obj.getAdminPassword().equals(adminLogindto.getAdminPassword())) {

				return "Welcome to the login page";
			} else {

				return "Email id or Password is wrong";
			}
		}
		return null;
	}

	// adding manager
	public Manager addManager(AddingManagerDTO addingManagerDTO) {

		Manager manager = new Manager();
		manager.setManagerEmail(addingManagerDTO.getManagerEmail());
		manager.setManagerPassword(addingManagerDTO.getManagerPassword());
		manager.setManagerName(addingManagerDTO.getManagerName());
		manager.setManagerAddress(addingManagerDTO.getManagerAddress());
		manager.setManagerMobileNo(addingManagerDTO.getManagerMobileNo());
		manager.setCreatedDate(new Date());
		manager.setUpdateDate(new Date());

		try {

			managerRepository.save(manager);

		} catch (IllegalArgumentException e) {

			throw new BusinessException("602", "Repository error");

		} catch (Exception e) {

			throw new BusinessException("601", "something wrong with service layer");

		}
		return manager;
	}

	@Override
	public List<ManagerResponseDTO> getAllManagers() {
		List<Manager> list = managerRepository.findAll();

		if (list.isEmpty()) {

			throw new EntityNotFoundException("601", "No managers found");
		}

		List<ManagerResponseDTO> responseList = list.stream()
				.map(response -> modelMapper.map(response, ManagerResponseDTO.class)).collect(Collectors.toList());
		return responseList;

	}

	@Override
	public ManagerResponseDTO getManagerById(Long managerId) {

		Optional<Manager> optionalManager = managerRepository.findById(managerId);

		if (optionalManager.isEmpty()) {

			throw new EntityNotFoundException("601", "Manager With " + managerId + " not found");
		}

		else {

			Manager managerDb = optionalManager.get();

			ManagerResponseDTO responseDto = new ManagerResponseDTO();

			responseDto.setManagerName(managerDb.getManagerName());
			responseDto.setManagerEmail(managerDb.getManagerEmail());
			responseDto.setManagerId(managerId);
			responseDto.setManagerMobileNo(managerDb.getManagerMobileNo());
			responseDto.setManagerAddress(managerDb.getManagerAddress());

			return responseDto;
		}
	}

	@Override
	public String deleteManagerById(Long managerId) {

		managerRepository.deleteById(managerId);

		return "Manager with " + managerId + " deleted";
	}

	@Override
	public UpdatedManagerResponseDTO updateManager(Manager manager) {

		manager.setUpdateDate(new Date());
		Manager updatedManager = managerRepository.save(manager);

		UpdatedManagerResponseDTO updatedResponse = new UpdatedManagerResponseDTO();

		updatedResponse.setManagerName(updatedManager.getManagerName());
		updatedResponse.setUpdateDate(new Date());
		updatedResponse.setManagerAddress(updatedManager.getManagerAddress());
		updatedResponse.setManagerMobileNo(updatedManager.getManagerMobileNo());
		updatedResponse.setManagerEmail(updatedManager.getManagerEmail());
		updatedResponse.setManagerId(updatedManager.getManagerId());

		return updatedResponse;
	}

}
