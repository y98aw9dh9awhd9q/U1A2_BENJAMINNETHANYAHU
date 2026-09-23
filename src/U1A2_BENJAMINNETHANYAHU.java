import javax.swing.*;
import java.awt.Dimension;



public class U1A2_BENJAMINNETHANYAHU extends JFrame {

    //set the constants for the coin values
    final int NICKEL   = 5  ;
    final int DIME     = 10 ;
    final int QUARTER  = 25 ;
    final int LOONIE   = 100;
    final int TOONIE   = 200;
    final int QUAD     = 400;

    //swing ui elements
    private JPanel     JPANEL;
    private JTextField MONEYINPUT;
    private JButton    CALCULATE_BUTTON;
    private JLabel     OUTPUT_FIELD;

    public U1A2_BENJAMINNETHANYAHU(){
        setContentPane(JPANEL);
        setTitle("calculator panel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        CALCULATE_BUTTON.addActionListener(_ -> calculateStuff());
        OUTPUT_FIELD.setPreferredSize(new Dimension(250,250));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void calculateStuff(){
        float userInputMoney = Math.round(Float.parseFloat(MONEYINPUT.getText()) * 100.0f) / 100.0f;//get the user inputted money then round to two decimal
        //convert to whole cents to avoid rounding errors
        int cents = (int) Math.round(userInputMoney * 100);

        int quadAmount = cents / QUAD;      //check how many quads fit in the money input
        cents %= QUAD;                      //make the money into the remainder after all the quads are taken out


        //same logic
        int toonieAmount = cents / TOONIE;
        cents %= TOONIE;

        int loonieAmount = cents / LOONIE;
        cents %= LOONIE;

        int quarterAmount = cents / QUARTER;
        cents %= QUARTER;

        int dimeAmount = cents / DIME;
        cents %= DIME;

        int nickelAmount = cents / NICKEL;
        cents %= NICKEL;


        //finally the left over amount of money is the amount of pennies
        int pennyAmount = cents;

        String result = String.format(
                "<html><pre>" +
                        "Amount entered : $%.2f<br>" +
                        "quad           : %d<br>"    +
                        "toonie         : %d<br>"    +
                        "loonie         : %d<br>"    +
                        "quarter        : %d<br>"    +
                        "dime           : %d<br>"    +
                        "nickel         : %d<br>"    +
                        "penny          : %d</pre></html>",
                userInputMoney, quadAmount, toonieAmount, loonieAmount,
                quarterAmount, dimeAmount, nickelAmount, pennyAmount);

        OUTPUT_FIELD.setText(result);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(U1A2_BENJAMINNETHANYAHU::new);
    }
}
