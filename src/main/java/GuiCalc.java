import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GuiCalc implements ActionListener {
    private JFrame frame;
    private JTextField xField, yField;
    private JLabel result;
    private JLabel xLabel, yLabel;
    private JButton computeButton;
    private JPanel xPanel, yPanel, resultPanel;

    public GuiCalc() {
        instantiateFields();
        frame.setMinimumSize(new Dimension(200, 200));
        frame.setLayout(new GridLayout(4, 1));
        xPanel.add(xLabel);
        xPanel.add(xField);
        yPanel.add(yLabel);
        yPanel.add(yField);
        resultPanel.add(result);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.add(xPanel);
        frame.add(yPanel);
        frame.add(resultPanel);
        frame.add(computeButton);
        computeButton.addActionListener(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        try {
            result.setText("x*y= " + Integer.parseInt(xField.getText()) * Integer.parseInt(yField.getText()));
        } catch(NumberFormatException e) {
            result.setText("Invalid inputs");
        }
    }

    private void instantiateFields() {
        frame = new JFrame();
        xLabel = new JLabel("x:");
        yLabel = new JLabel("y:");
        result = new JLabel("x*y=");
        xField = new JTextField("", 5);
        yField = new JTextField("", 5);
        xPanel = new JPanel();
        yPanel = new JPanel();
        resultPanel = new JPanel();
        computeButton = new JButton("Compute");
    }
}