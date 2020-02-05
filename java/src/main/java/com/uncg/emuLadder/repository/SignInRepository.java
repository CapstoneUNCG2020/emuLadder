package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.AccountCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignInRepository extends JpaRepository<AccountCredentials, String> {
}
