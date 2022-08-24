package com.cts.pensionerDetails.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pensionerDetails.Model.PensionerDetailEntity;

@Repository
public interface PensionerDetailsRepository extends JpaRepository<PensionerDetailEntity, String> {

}
