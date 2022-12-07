package org.sourpy.ecomapp.Repository;

import org.sourpy.ecomapp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
