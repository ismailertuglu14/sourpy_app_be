package org.sourpy.ecomapp.Repository;

import org.sourpy.ecomapp.Entity.Api;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepostiory extends JpaRepository<Api,Long> {
}
