package au.com.telstra.simcardactivator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SimCardRecordRepository extends CrudRepository<SimCardRecord, Long> {

  List<SimCardRecord> findByCustomerEmail(String customerEmail);

  SimCardRecord findById(long id);
}