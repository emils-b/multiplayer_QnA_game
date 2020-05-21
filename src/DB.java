import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	private Connection con;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public DB() {
		try {
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qna_game", "root", "");
			this.stat = con.createStatement();
			this.createTables();
		} catch (SQLException e) {
			System.out.println("Problems with database setup");
		}
	}
	
	private String getActiveQuestion() {
		
	}
	
	private void createTables() {
		String createQuestionTable = "CREATE TABLE IF NOT EXISTS `tbl_question` (  `id` INT(11) NOT NULL AUTO_INCREMENT,  `question` VARCHAR(500) NOT NULL DEFAULT '' COLLATE 'utf8mb4_general_ci',  `answer` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'utf8mb4_general_ci',  `is_answer` TINYINT(1) NOT NULL DEFAULT '0',  `winner_name` VARCHAR(50) NULL COLLATE 'utf8mb4_general_ci',  PRIMARY KEY (`id`) USING BTREE)COLLATE='utf8mb4_general_ci'ENGINE=InnoDB;";
		String createAnswerTryTable = "CREATE TABLE IF NOT EXISTS `tbl_answer_try` (  `id` INT(11) NOT NULL AUTO_INCREMENT,  `question_id` INT(11) NOT NULL,  `player` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',  `text` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',  `is_correct` TINYINT(1) NOT NULL DEFAULT '0',  `is_winner` TINYINT(1) NOT NULL DEFAULT '0',  `answer_time` DATETIME NOT NULL,  PRIMARY KEY (`id`) USING BTREE)COLLATE='utf8mb4_general_ci'ENGINE=InnoDB;";
		this.insert(createQuestionTable);
		this.insert(createAnswerTryTable);
	}
	
	private void insert (String query) {
		try {
			this.stat.executeUpdate(query);
		} catch (Exception e) {
			System.out.println("Problems with insert query ");
			System.out.println(query);
		}
	}
}
