import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandProductMaker extends JFrame {
    //gui
    private JTextField idField, nameField, descField, costField, countField;
    private JButton addButton, quitButton;
    private int recordCount = 0;

    private static final int NAME_CHAR_LIMIT = 35;
    private static final int ID_CHAR_LIMIT = 6;
    private static final int DESC_CHAR_LIMIT = 75;

    public RandProductMaker() {
        setTitle("Random Product Maker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        //initialize
        idField = new JTextField();
        nameField = new JTextField();
        descField = new JTextField();
        costField = new JTextField();
        countField = new JTextField("0");
        countField.setEditable(false);

        add(new JLabel("ID (6 chars): "));
        add(idField);

        add(new JLabel("Name (35 chars): "));
        add(nameField);

        add(new JLabel("Description (75 chars): "));
        add(descField);

        add(new JLabel("Cost: "));
        add(costField);

        add(new JLabel("Record count: "));
        add(countField);

        addButton = new JButton("Add record");
        add(addButton);

        quitButton = new JButton("Quit");
        add(quitButton);

        addButton.addActionListener(e -> addRecord());
        quitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void addRecord() {
        //validate
        if (idField.getText().isEmpty() || nameField.getText().isEmpty() || descField.getText().isEmpty() || costField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields!");
            return;
        }

        try (RandomAccessFile raf = new RandomAccessFile("ProductData.dat", "rw")) {
            raf.seek(raf.length());

            raf.writeChars(padString(nameField.getText(), NAME_CHAR_LIMIT));
            raf.writeChars(padString(descField.getText(), DESC_CHAR_LIMIT));
            raf.writeChars(padString(nameField.getText(), ID_CHAR_LIMIT));
            raf.writeDouble(Double.parseDouble(costField.getText()));



            //ui update
            recordCount++;
            countField.setText(String.valueOf(recordCount));

            //claer fields
            idField.setText("");
            nameField.setText("");
            descField.setText("");
            costField.setText("");

            JOptionPane.showMessageDialog(this, "Record added successfully!");

        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Cost must be a valid number!");
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(this, "Error writing to file.");
        }

    }
    //force fixed length
    private String padString(String str, int length) {
        if (str.length() > length) return str.substring(0, length);
        return String.format("%-" + length + "s", str);
    }

    public static void main(String[] args) {
        new RandProductMaker();
    }
}

