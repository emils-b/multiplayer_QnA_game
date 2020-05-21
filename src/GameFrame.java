import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameFrame extends JFrame implements KeyListener {
	
	private int width = 700;
	private int height = 500;
	Container cont;
	private String question;
	private String correctAnswer;
	private JLabel questionLabel;
	private JLabel tryLabel;
	private JLabel statusLabel;
	private JTextField answerInput;
	private int totalTries;
	private int playerTries;
	
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
		Font statusFont = new Font(Font.SANS_SERIF, Font.ITALIC, 14);
		this.questionLabel = createNewLabel(this.question, titleFont, Color.WHITE, 60, 30, 500, 30);
		this.statusLabel = createNewLabel("Test status", statusFont, Color.WHITE, 60, 100, 500, 30);
		
		this.tryLabel = createNewLabel("", textFont, Color.WHITE, 520, 60, 160, 60);
		this.tryLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		this.updateTries();
		
		this.answerInput = new JTextField(3);
		this.answerInput.setBounds(60, 140, 400, 60);
		this.answerInput.setFont(textFont);
		this.answerInput.addKeyListener(this);
		this.cont.add(this.answerInput);
	}
	
	private JLabel createNewLabel(String text, Font font, Color color, int x, int y, int w, int h) {
		JLabel label = new JLabel(text);
		label.setForeground(color);
		label.setFont(font);
		label.setBounds(x, y, w, h);
		this.cont.add(label);
		return label;
	}
	
	private void updateTries() {
		String tryHtml = "<html><div style='padding: 7px'>Total tries: "+this.totalTries+"<br/>Your tries: "+this.playerTries+"</div></html>";
		this.tryLabel.setText(tryHtml);
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode()!=KeyEvent.VK_ENTER) return;
		String text = this.answerInput.getText().trim();
		if (text.length()==0) return;
		this.playerTries++;
		this.totalTries++;
		this.updateTries();
		boolean isCorrect = text.equalsIgnoreCase(this.correctAnswer);
		this.answerInput.setText("");
		if (isCorrect) {
			this.statusLabel.setText("Yup, you are right. Congratz!");
		} else {
			if (this.playerTries==1) this.statusLabel.setText("Nope. Try again!");
			this.statusLabel.setText("You have been wrong "+this.playerTries+" times. Try again!");
		}
	}

	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
