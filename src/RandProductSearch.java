import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandProductSearch extends JFrame {
    private JTextField searchField;
    private JTextArea resultsArea;
    private JButton searchButton, quitButton;

    //exact size match
    private static final int NAME_CHAR_LIMIT = 35;
    private static final int DESC_CHAR_LIMIT = 75;
    private static final int ID_CHAR_LIMIT = 6;
    private static final int RECORD_SIZE = (NAME_CHAR_LIMIT + DESC_CHAR_LIMIT + ID_CHAR_LIMIT) * 2 + 8;

    /* PERSONAL NOTE FOR FUTURE REFERENCE:
     WHY * 2 + 8?
     * 1. Java uses two bytes for every single letter or space. So the 116 total characters take up 232 bytes of space.
     * 2. The price (double) is a specific type of data that always takes up 8 bytes, no matter how big the number is. Adding those together (232 + 8) gives us 240 bytes.
     This lets the computer "jump" exactly 240 bytes to find the next product.
     */

    public RandProductSearch() {
        setTitle("Random Product Search");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //top pnl (search)
        JPanel topPnl = new JPanel();
        topPnl.add(new JLabel("Search by Name:"));
        searchField = new JTextField(20);
        topPnl.add(searchField);

        searchButton = new JButton("Search");
        topPnl.add(searchButton);

        add(topPnl, BorderLayout.NORTH);

        //mid area (results)
        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        add(new JScrollPane(resultsArea), BorderLayout.CENTER);

        //bot pnl (quit)
        quitButton = new JButton("Quit");
        add(quitButton, BorderLayout.SOUTH);

        searchButton.addActionListener(e -> performSearch());
        quitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void performSearch() {

    }

}
