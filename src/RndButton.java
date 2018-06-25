import jdk.nashorn.internal.runtime.regexp.joni.exception.JOniException;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

class RndButton implements ActionListener {
    JFrame jtfMainFrame = new JFrame("RndButton");
    JButton jbnButton[] = new JButton[10];
    JButton b = new JButton("­Ë°h");
    JButton c = new JButton("²M°£");
    JTextArea d = new JTextArea("");
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new RndButton();
    }


    public RndButton() {

        jtfMainFrame.setSize(450, 450);
        JPanel jplPanel = new JPanel();
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        jplPanel.setLayout(new GridLayout(5, 3));

        int tmp;
        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            jbnButton[i] = new JButton();

            int myrandom = ran.nextInt(10 - i);
            tmp = array[9 - i];
            array[9 - i] = array[myrandom];
            array[myrandom] = tmp;
            jbnButton[i].setText("" + array[9 - i]);
            jbnButton[i].setActionCommand("" + array[9 - i]);
            jbnButton[i].addActionListener(this);
            d.setEditable(false);
            jplPanel.add(jbnButton[i]);
            jplPanel.add(b);
            jplPanel.add(c);
            jplPanel.add(d);
        }
        jtfMainFrame.getContentPane().add(jplPanel, BorderLayout.CENTER);
        jtfMainFrame.setVisible(true);
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(d.getText().length()-1!=-1) {
                    d.setText(d.getText().substring(0, d.getText().length() - 1));
                }
            }
        });
        c.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                d.selectAll();
                d.replaceSelection("");
            }

        });
    }

    public void actionPerformed(ActionEvent e) {
        d.append(e.getActionCommand());

}
}