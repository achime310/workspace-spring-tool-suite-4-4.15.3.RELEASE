package com.itwill.transaction.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;



public class EmployeeServiceImplByProgramatic implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	private PlatformTransactionManager transactionManager;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}


	public void registerEmployee(Employee person) {
		employeeDao.insert(person);
	}

	public void deleteEmployee(int idx) {
		employeeDao.delete(idx);
	}

	public void udpateEmployee(Employee emp) {
		employeeDao.update(emp);
	}

	public List<Employee> getEmps() {
		return employeeDao.list();
	}
	
	
	public void increaseSalaryForAll() {
		DefaultTransactionDefinition def = 
				new DefaultTransactionDefinition();
		/*
		 * 1) 대부분 Transaction Propagation(Required)속성을 사용한다.
			→ 걸려들어오면 같이 사용하고, 안걸려 들어오면 만들어서 사용
			**@Transactional( Propagation = propagation.required)**
		 */
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		//ISOLATION_READ_COMMITTED : 다른 트랜잭션이 변경했지만 아직 커밋하지 않은 데이터는 읽어낼수없음.
		def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);	
		def.setTimeout(10);
		def.setReadOnly(false);
		
		TransactionStatus status = transactionManager.getTransaction(def);
		
		List<Employee> emps = getEmps();
		try {
			int index = 1;
			for (Employee emp : emps) {
				employeeDao.increaseSalary(emp.getId(),50);
				index++;
				if (index == 3) {
					throw new RuntimeException(">>>throw exception");
				}
			}
			transactionManager.commit(status);
			System.out.println("commit[programmatic]");
		} catch (RuntimeException e) {
			transactionManager.rollback(status);
			System.out.println("rollback[programmatic]");
			throw e;
		}
	}

	

	
}
