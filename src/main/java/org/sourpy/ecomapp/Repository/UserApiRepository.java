package org.sourpy.ecomapp.Repository;

import org.sourpy.ecomapp.Entity.UserApi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserApiRepository extends JpaRepository<UserApi,Long> {
}
