package com.example.demo.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user-profile")
public class UserProfileController {

    private final UserProfileService userProfileService;

    // Constructor
    @Autowired
    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    // Map list of users method
    @GetMapping
    public List<UserProfile> getUserProfiles() {
        return userProfileService.getUserProfiles();
    }
}
