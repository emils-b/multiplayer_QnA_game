import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameFrame extends JFrame {
	private int width = 700;
	private int height = 500;
	Container cont;
	private String question;
	private String correctAnswer;
	private JLabel questionLabel;
	private JLabel tryLabel;
	private JLabel statusLabel;
	private JTextField answerInput;
	
	GameFrame(String question, String answer){
		this.question = question;
		this.correctAnswer = answer;
		this.setTitle("QnA game");
		this.setBounds(200, 100, width, height);
		this.cont = this.getContentPane();
		this.cont.setBackground(Color.decode("#303330"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}
	
	private void init(){
		this.cont.setLayout(null);
		Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		Font textFont = new Font(Font.SANS_SERIF, Font.PLAIN, 20);
		this.questionLabel = new JLabel(this.question);
		this.questionLabel.setForeground(Color.WHITE);
		this.questionLabel.setFont(titleFont);
		this.questionLabel.setBounds(60, 30, 500, 30);
		this.cont.add(this.questionLabel);
		
		this.statusLabel = new JLabel("Test status");
		this.statusLabel.setForeground(Color.WHITE);
		this.statusLabel.setFont(textFont);
		this.statusLabel.setBounds(60, 70, 500, 30);
		this.cont.add(this.statusLabel);
	}
}
