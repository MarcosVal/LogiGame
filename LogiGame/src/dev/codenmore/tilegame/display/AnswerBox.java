package dev.codenmore.tilegame.display;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dev.codenmore.tilegame.Handler;
import dev.codenmore.tilegame.entities.Entity;
import dev.codenmore.tilegame.gfx.Assets;
import dev.codenmore.tilegame.states.ProblemState;
import dev.codenmore.tilegame.states.State;

public class AnswerBox implements ActionListener {
	Handler handler;
	JTextField writeSpace = new JTextField();
	JFrame f = new JFrame();
	boolean confirmed;
	String[] answers = new String[] { "A", "B", "C" };

	public AnswerBox() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int scrWid = (int) screenSize.getWidth();
		int scrHei = (int) screenSize.getHeight();

		// setting up a frame
		f.setSize(400, 150);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setLocation(scrWid / 2 - 400 / 2, scrHei - 190);
		f.setIconImage(Assets.activator[0]);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// to make both windows active:
		f.setFocusableWindowState(true);
		f.setAlwaysOnTop(true);

		// setting up a label
		JLabel labelM = new JLabel("Enter your answer:");
		labelM.setBounds(35, 20, 400, 40);
		Font fnt1 = new Font("Eras Bold ITC", Font.PLAIN, 30);
		labelM.setFont(fnt1);
		;

		// setting up a textfield
		writeSpace.setBounds(35, 65, 245, 30);

		// setting up a button
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(this);
		confirm.setBounds(285, 65, 80, 30);

		// add elements to the frame
		f.add(labelM);
		f.add(writeSpace);
		f.add(confirm);
		confirmed = false;

	}

	public void checkAnswer(int id, Handler handler) {
		String answer = writeSpace.getText();
		if (answer.equals(answers[id])) {
			System.out.println("YESSSS");
			// State.setState(handler.getGame().theGame);
			for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
				if (e.equals(handler.getWorld().getEntityManager().getPlayer()))
					continue;
				if (e.getCollisionBounds(0, 0).intersects(handler.getWorld()
						.getEntityManager().getPlayer().getIr()))
					e.hurt(10);}}}

	//getters+setters
	public void actionPerformed(ActionEvent e) {
		confirmed = true;}

	public boolean isConfirmed() {
		return confirmed;}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;}

	public JFrame getF() {
		return f;}

	public void setF(JFrame f) {
		this.f = f;}

	public JTextField getWriteSpace() {
		return writeSpace;}

	public void setWriteSpace(JTextField writeSpace) {
		this.writeSpace = writeSpace;}
}
