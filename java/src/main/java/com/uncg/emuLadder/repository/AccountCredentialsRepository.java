package com.uncg.emuLadder.repository;

import com.uncg.emuLadder.model.database.AccountCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountCredentialsRepository extends JpaRepository<AccountCredentials, String> {

    @Modifying
    @Transactional
    @Query("UPDATE AccountCredentials SET password=:password WHERE email=:email")
    void resetPassword(@Param("password") String password, @Param("email") String email);
}
