package com.diuoa.ci.repository;

import com.diuoa.ci.model.UserQueryData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserQueryDataRepository extends JpaRepository<UserQueryData, Long> {

    Page<UserQueryData> findByUsername(String username, Pageable pageable);

}
