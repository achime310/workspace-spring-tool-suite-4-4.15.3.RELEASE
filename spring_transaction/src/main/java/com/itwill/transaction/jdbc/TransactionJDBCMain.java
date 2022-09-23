package com.itwill.transaction.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
<< accountA , accountB >> 
이름          널        유형           
----------- -------- ------------ 
ACC_NO      NOT NULL NUMBER(20)   
ACC_NAME             VARCHAR2(20) 
ACC_BALANCE          NUMBER(10)    
 */
/*
 * JDBC Transaction
 */
public class TransactionJDBCMain {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		
		String updateSqlA="update accountA set acc_balance = acc_balance - ? where acc_no = ?";
		String updateSqlB="update accountB set acc_balance = acc_balance + ? where acc_no = ?";
		String selectSqlA="select acc_balance from accountA where acc_no=?";
		String selectSqlB="select acc_balance from accountB where acc_no=?";
		try{
			
			con = ConnectionFactory.getConnection();
			/*
			 * 1. con.setAutoCommit(false);
			 */
			con.setAutoCommit(false);
			/*
			 * transaction start(dml statement)
			 */
			pstmt = con.prepareStatement(updateSqlA);
			int acc_no = 10000;
			int money  = 100000;
			pstmt.setInt(1, money);
			pstmt.setInt(2, acc_no);
			int rowCount=pstmt.executeUpdate();
			
			System.out.println("1.accountA "+acc_no+" 계좌잔고 "+money+ "원 감소:"+rowCount);
			pstmt.close();
			
			pstmt = con.prepareStatement(updateSqlB);
			pstmt.setInt(1, money);
			pstmt.setInt(2, acc_no);
			rowCount =pstmt.executeUpdate();
			System.out.println("2.accountB "+acc_no+" 계좌잔고 "+money+ "원 증가:"+rowCount);
			pstmt.close();
			
			pstmt=con.prepareStatement(selectSqlA);
			pstmt.setInt(1, acc_no);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				int balanceA = rs.getInt(1);
				if(balanceA < 0){
					/*
					 * transaction end [rollback]
					 */
					con.rollback();
					
					System.out.println("3-1.A계좌잔고 "+ balanceA +"음수--> rollback");
				}else{
					/*
					 * transaction end [commit]
					 */
					con.commit();
					System.out.println("3-2.A계좌잔고 "+ balanceA +"양수--> commit");
				}
				
			}else{
				//rs객체가 존재하지 않는다면, exception을 던져서 아래의 catch에 걸리게 됨 
				throw new Exception("unknown error!!");
			}
		}catch(Exception e){
			
			try {
				/*
				 * transaction end [rollback]
				 */
				con.rollback();
				System.out.println("99.rollback(Exception)");
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
		}
		

	}

}











