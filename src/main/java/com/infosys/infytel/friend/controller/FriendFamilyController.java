package com.infosys.infytel.friend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.infytel.friend.dto.FriendFamilyDTO;
import com.infosys.infytel.friend.service.FriendFamilyService;

@RestController
@CrossOrigin
public class FriendFamilyController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	FriendFamilyService friendService;

	// Create Friend Family
	@RequestMapping(value = "/customers/{phoneNo}/friends", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveFriend(@PathVariable Long phoneNo, @RequestBody FriendFamilyDTO friendDTO) {
		logger.info("Creation request for customer {} with data {}", phoneNo, friendDTO);
		friendService.saveFriend(phoneNo, friendDTO);
	}
	
	@RequestMapping(value = "/friendFamily/{phoneNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Long> getFriendFamily(@PathVariable Long phoneNo) {
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		logger.info("Fetch request for Friend-Family by phoneNumber {}", phoneNo);
		return friendService.getFriendFamily(phoneNo);
	}

}
