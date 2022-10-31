/**
 * 
 */
package com.learning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Greg N.
 * @date :
 * 
 */
@Repository
public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Long>{
	
	@Query(value="select * From beneficiary where account_number = :acctID", nativeQuery= true)
	public List<Beneficiary> getgetBeneficiaryForAccount(@Param("acctID") long accountID);
	
	@Query(value="delete from beneficiary where customer_id = :custID and id = :beneficiaryID")
	public String deleteCustomersBeneficiary(@Param("beneficiaryID") long benficiaryID ,@Param("custID") long custID);

}