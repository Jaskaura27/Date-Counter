
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * represents an object DateCounterPanel and extends it to JPanel.
 */
public class DateCounterPanel extends JPanel{
    
    private JLabel startDateLabel;
    private JLabel endDateLabel;
    private JTextField startDate;
    private JTextField endDate;
    private JButton button;

    private JPanel panel;

    private String currentDate;

    private DateVerifier dateVerifier;

    //private DataVerifier dataVerifier;

    private static final String START_DATE = "1/1/2000";


    /**
     * Create object DateCounterPanel.
     */
    public DateCounterPanel(){
        getCurrentDate();
        createPanel();
        createButton();
    }

    /**
     * create a butto and add actionListener to it and add it to the panel.
     */
    private void createButton() {
        class DateVerifierListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                final String startDateString=startDate.getText();
                final String endDateString = endDate.getText();
                dateVerifier =new DateVerifier();
                final JOptionPane optionPane = new JOptionPane();
                try{
                    final LocalDate date1 = dateVerifier.verify("Start Date: ",startDateString);
                    final LocalDate date2 = dateVerifier.verify("End Date: ",endDateString);
                    final Period difference = Period.between(date1, date2);
                    JOptionPane.showMessageDialog(null, difference.getDays()+" days\n"+difference.getMonths()+" Month(s)\n"+difference.getYears()+" Year(s)\n"+ChronoUnit.DAYS.between(date1,date2)+" Day(s)");
                }catch(DateTimeException ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }


                

            }
        }
        button = new JButton("Count");
        button.addActionListener(new DateVerifierListener());
        panel.add(button);
    }

    /**
     * Create a panel and add JLabel,JTextField and JButtons to it.
     */
    private void createPanel() {
        startDateLabel = new JLabel("Start Date:");
        endDateLabel = new JLabel("End Date:");

        startDate= new JTextField(START_DATE);
        endDate = new JTextField(currentDate);

        panel = new JPanel();
        panel.add(startDateLabel);
        panel.add(startDate);
        panel.add(endDateLabel);
        panel.add(endDate);

        add(panel,BorderLayout.CENTER);
    }

    /**
     * returns a String with current Date.
     */
    private void getCurrentDate(){
        int day,month,year;
        day = LocalDateTime.now().getDayOfMonth();
        month = LocalDateTime.now().getMonthValue();
        year = LocalDateTime.now().getYear();

        currentDate = day+"/"+month+"/"+year;
    }
}