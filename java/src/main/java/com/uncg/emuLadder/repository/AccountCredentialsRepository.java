package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.AccountCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountCredentialsRepository extends JpaRepository<AccountCredentials, String> {
}
