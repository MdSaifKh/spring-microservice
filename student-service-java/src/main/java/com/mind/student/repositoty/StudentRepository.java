package com.mind.student.repositoty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mind.student.entity.Student;





@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	@Query(value = "select s.id, s.first_name as firstName, s.last_name as lastName, s.email, st.street \r\n"
			+ "	,st.city from student as s inner join student_address as st on s.address_id = st.id;",
		nativeQuery = true)
    List<Object[]> findAllStudentAndAddress();
    
    @Query(value = "select addressId from Student where id = :param")
    List<Long> findAddressIdByStudentId(@Param("param") String param);
    
}
