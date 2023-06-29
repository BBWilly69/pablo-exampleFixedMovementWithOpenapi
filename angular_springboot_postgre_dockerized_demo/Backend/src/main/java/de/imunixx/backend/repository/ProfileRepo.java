package de.imunixx.backend.repository;

import de.imunixx.api.entity.Profile;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Long> {
    List<Profile> findByUser_Id(Long userId);
    Optional<Profile> findProfileById(Long id);
    void deleteProfileById(Long id);
}
