package com.controller.erp_icbc.loanAfter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.service1.loan.LoanOverdueService;
import com.util.creditutil;
/**
 * 自动任务
 * 
 * 用于每日凌晨00:00逾期列表客户逾期天数增加一天
 * 
 * @author 三十画生
 * 2019-3-27
 */
@Component
public class LoanAutomaticTaskController {
	private static Logger log = LogManager.getLogger(LoanAutomaticTaskController.class.getName());
	@Autowired
	private LoanOverdueService loanOverdueService;
	 
	@Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次   
//	@Scheduled(cron = "0 0 1 * * ?") //每天凌晨1点执行
	public void tasktest(){	
		// 1. 准备连接数据库的 4 个字符串.
        // 驱动的全类名.
        String driverClass = "com.mysql.jdbc.Driver";
        // JDBC URL
        String jdbcUrl = "jdbc:mysql://localhost:3306/kcway2?relaxAutoCommit=true&zeroDateTimeBehavior=convertToNull&characterEncoding=UTF-8&useUnicode=true&autoReconnect=true";
        // user
        String user = "kcway";
        // password
        String password = "NDXppG2qUNB6pXcA";
        Connection connection = null;
        try {
        	// 2. 加载数据库驱动程序(对应的 Driver 实现类中有注册驱动的静态代码块.)
			Class.forName(driverClass);
			// 3. 通过 DriverManager 的 getConnection() 方法获取数据库连接.
			connection = (Connection) DriverManager.getConnection(jdbcUrl, user,password);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "UPDATE loan_overdue_list l set dt_edit=sysdate(),l.overdue_days=l.overdue_days+1,l.type_status=(CASE WHEN l.overdue_days>=(select c.overdue_one from loan_config c where c.gems_fs_id=l.gems_fs_id) and l.overdue_days<(select c.overdue_two from loan_config c where c.gems_fs_id=l.gems_fs_id) THEN 11 WHEN l.overdue_days>=(select c.overdue_two from loan_config c where c.gems_fs_id=l.gems_fs_id) and l.overdue_days<(select c.overdue_three from loan_config c where c.gems_fs_id=l.gems_fs_id) THEN 12 WHEN l.overdue_days>=(select c.overdue_three from loan_config c where c.gems_fs_id=l.gems_fs_id) THEN 13 ELSE l.type_status END) where l.overdue_amount>0 and l.type_id=1";
        int counts = 0;
		try {
			Statement stmt = (Statement) connection.createStatement();
			counts = stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		int counts = loanOverdueService.updateOverdueDay();
//		System.out.println("自动执行:"+creditutil.time()+"---"+counts);
		log.info("自动执行:"+creditutil.time()+"---"+counts);
	};
}
