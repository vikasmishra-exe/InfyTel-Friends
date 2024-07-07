package com.infosys.infytel.friend.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.infosys.infytel.friend.dto.FriendFamilyDTO;
import com.infosys.infytel.friend.entity.FriendFamily;
import com.infosys.infytel.friend.repository.FriendFamilyRepository;

@Service
public class FriendFamilyService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	FriendFamilyRepository friendRepo;

	// Create Friend Family
	public void saveFriend(@PathVariable Long phoneNo, @RequestBody FriendFamilyDTO friendDTO) {
		logger.info("Creation request for customer {} with data {}", phoneNo, friendDTO);
		friendDTO.setPhoneNo(phoneNo);
		FriendFamily friend = friendDTO.createFriend();
		friendRepo.save(friend);
	}
	
	public List<Long> getFriendFamily(@PathVariable Long phoneNo) {
		logger.info("Fetch request for Friend-Family by phoneNumber {}", phoneNo);
		List<FriendFamily> friendFamilyList = friendRepo.findByPhoneNo(phoneNo);
		List<Long> friendFamily = new ArrayList<>();
		for (FriendFamily friend : friendFamilyList) {
			friendFamily.add(friend.getFriendAndFamily());
		}
		logger.info("Friend-Family" + friendFamily);
		return friendFamily;
	}

}
