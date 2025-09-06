import javax.swing.*;

public class DialogBoxes{

    DialogBoxes(){
        JOptionPane.showMessageDialog(null,"This is some useless info", "Title", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null,"This is a question?", "Title", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null,"This is an error", "Title", JOptionPane.ERROR_MESSAGE);
        JOptionPane.showMessageDialog(null,"This is a warning", "Title", JOptionPane.WARNING_MESSAGE);

        JOptionPane.showConfirmDialog(null, "Do you like pizza?", "Title", JOptionPane.YES_NO_OPTION);
        int answer = JOptionPane.showConfirmDialog(null, "Are you sure?", "Title", JOptionPane.YES_NO_CANCEL_OPTION);
        System.out.println(answer);
        if(answer == 0){
            JOptionPane.showMessageDialog(null, "Ok you like pizza", "Title", JOptionPane.PLAIN_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Ok you don't like pizza", "Title", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
