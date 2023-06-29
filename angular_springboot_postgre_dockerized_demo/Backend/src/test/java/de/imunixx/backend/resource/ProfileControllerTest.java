package de.imunixx.backend.resource;

import de.imunixx.backend.controller.ProfileController;
import de.imunixx.api.entity.Profile;
import de.imunixx.api.entity.User;
import de.imunixx.backend.service.ProfileService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ProfileControllerTest {

    @Mock
    private ProfileService profileService;

    @InjectMocks
    private ProfileController profileResource;

    private Profile profile;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        profile = new Profile();
        profile.setId(1L);
        profile.setName("Profile01");
        profile.setUser(new User());
    }

    @Test
    void shouldGetAllUserProfiles() {
        List<Profile> expectedProfiles = new ArrayList<Profile>();
        expectedProfiles.add(profile);
        when(profileService.findAllUserProfiles(1L)).thenReturn(expectedProfiles);
        ResponseEntity response = profileResource.getAllUserProfiles(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedProfiles, response.getBody());
    }
    @Test
    void shouldGetProfileById() {
        when(profileService.findProfileById(1L)).thenReturn(profile);
        ResponseEntity response = profileResource.getProfileById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(profile, response.getBody());
    }

    @Test
    void shouldAddProfile() {
        when(profileService.addProfile(profile)).thenReturn(profile);
        ResponseEntity response = profileResource.addProfile(profile);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(profile, response.getBody());
    }

    @Test
    void shouldUpdateProfile() {
        when(profileService.updateProfile(profile)).thenReturn(profile);
        ResponseEntity response = profileResource.updateProfile(profile);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(profile, response.getBody());
    }

    @Test
    void shouldDeleteProfile() {
        ResponseEntity response = profileResource.deleteProfile(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(profileService).deleteProfile(1L);
    }
}