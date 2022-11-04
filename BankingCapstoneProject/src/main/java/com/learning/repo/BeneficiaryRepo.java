package com.learning.repo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.entity.Beneficiary;

import com.learning.entity.Beneficiary;

/**
 * @author Greg N.
 * @date :
 * 
 */

//@Transactional
@Repository
@Transactional
public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Long> {
	
	@Query(value="select * From beneficiary where account_number = :acctID", nativeQuery= true)
	public List<Beneficiary> getBeneficiaryForAccount(@Param("acctID") long accountID);
	
	@Modifying
	@Query(value="delete from beneficiary where customer_id = :custID and beneficiary_ac_no = :beneficiaryID", nativeQuery= true)
	public int deleteCustomersBeneficiary(@Param("beneficiaryID") long benficiaryID ,@Param("custID") long custID);
	
}
