
package numberGuessingGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class numberGuess extends JFrame {
    JTextField field_X, field_Y;
    JLabel jLab;
    JLabel text$;
    GuessButton gesButton;
    RetryButton retButton;
    static int random=(int) (Math.random()*100);
    int count=0;
    public numberGuess()
    {

        Container con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.WHITE);
        JLabel labelpic = new JLabel("");
        JLabel Heading=new JLabel("NUMBER GUESSING GAME");
        Heading.setForeground(Color.black);
        Heading.setFont(new Font("Courier",Font.BOLD,24));
        Heading.setSize(370,35);
        Heading.setLocation(60,35);
        JLabel intro=new JLabel("Guess number between 1-100");
        intro.setFont(new Font("tunga",Font.PLAIN,15));
        intro.setSize(370,20);
        intro.setLocation(90,80);
        JLabel welcome=new JLabel("Let's Start The Game");
        welcome.setFont(new Font("tunga",Font.BOLD,26));
        welcome.setSize(250,20);
        welcome.setLocation(130,130);
        welcome.setForeground(Color.GREEN);
        field_X =new JTextField(12);
        field_X.setSize(70,30);
        field_X.setLocation(230,165);
        jLab =new JLabel(" ");
        jLab.setFont(new Font("tunga",Font. ITALIC,16));
        jLab.setSize(370,20);
        jLab.setLocation(110,200);
        JLabel text2=new JLabel("Enter number to Guess: ");
        text2.setFont(new Font("tunga",Font.BOLD,13));
        text2.setSize(350,20);
        text2.setLocation(110,170);
        field_Y =new JTextField(10);
        field_Y.setSize(50,30);
        field_Y.setLocation(260,305);
        JLabel text1=new JLabel("Number of trials :- ");
        text1.setFont(new Font("tunga",Font.BOLD,16));
        text1.setSize(270,20);
        text1.setLocation(120,305);
        text$ =new JLabel(" ");
        text$.setFont(new Font("tunga",Font.BOLD,36));
        text$.setSize(410,60);
        text$.setLocation(60,375);
        JButton button1 =new JButton("Guess");
        button1.setSize(80,30);
        button1.setLocation(120,250);
        gesButton =new GuessButton();
        button1.addActionListener(gesButton);
        JButton button2=new JButton("Retry");
        button2.setSize(80,30);
        button2.setLocation(260,250);
        retButton =new RetryButton();
        button2.addActionListener(retButton);
        con.add(jLab);
        con.add(labelpic);
        con.add(Heading);
        con.add(intro);
        con.add(text2);
        con.add(field_X);
        con.add(field_Y);
        con.add(button1);
        con.add(button2);
        con.add(text1);
        con.add(text$);
        con.add(welcome);
        field_Y.setEditable(false);
        setTitle("GUESS THE NUMBER");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class GuessButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int num = Integer.parseInt(field_X.getText());
            count=count+1;
            if(count>7)
            {
                jLab.setText("You Lose!!!, Try Again");
                jLab.setForeground(Color.RED);
                count=0;
            }
            else {
                if(num <random)
                {
                    jLab.setText("Guess Wrong!!! because "+ num +" is Low, Try Again");
                    jLab.setForeground(Color.blue);
                }
                else if(num >random)
                {
                    jLab.setText("Guess Wrong!!! because "+ num +" is High, Try Again");
                    jLab.setForeground(Color.blue);
                }
                else
                {
                    jLab.setText("Yeahh... You Guessed it Correct, You Win!!!!");
                    jLab.setForeground(Color.green);
                    text$.setText("ThankYou for playing game...");
                    text$.setForeground(Color.PINK);

                }
                field_X.requestFocus();
                field_X.selectAll();

                field_Y.setText(count+"");
            }
        }
    }

    private class RetryButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            random=(int) (Math.random()*100);
            field_X.setText("");
            field_Y.setText("");
            jLab.setText("Try Again and Guess the Number.");
            jLab.setForeground(Color.black);
            field_Y.setText("");
            count=0;
            field_X.setEditable(true);
            field_X.requestFocus();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new numberGuess();
    }


}
