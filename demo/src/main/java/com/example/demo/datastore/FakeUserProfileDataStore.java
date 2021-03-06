package com.example.demo.datastore;

import com.example.demo.profile.UserProfile;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    // Array of user profiles
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static {
        USER_PROFILES.add(new UserProfile(UUID.fromString("a087161d-6772-4f27-a6a3-110f54757905"), "janetJones", null));      // add new profileuser
        USER_PROFILES.add(new UserProfile(UUID.fromString("5fa909ae-9cc1-496d-b096-8c9689e47c81"), "antonioJunior", null));   // add new profileuser
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }
}
