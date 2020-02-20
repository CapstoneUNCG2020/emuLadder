package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountInformationRepository extends JpaRepository<Accounts, String> {
}
