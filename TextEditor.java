
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

/**
 *
 * @author apple
 */
public class TextEditor extends JFrame {

    /**
     * Creates new form TextEditor
     */
    Style stbold;
    int screenWidth, screenHeight, frameWidth, frameHeight;
    Color currentColor;
    int startIndex, endIndex;
    StyledDocument doc;
    AttributeSet as;

    private void setDimention() {
        // Set the Screen Dimention
        Dimension dim = getToolkit().getScreenSize();
        screenWidth = dim.width;
        screenHeight = dim.height;
        frameWidth = (screenWidth) / 2;
        frameHeight = (screenHeight) / 2;

        setLocation(((screenWidth) / 4), (screenHeight - frameHeight));
        setSize(900, 1000);
    }

    private void setGraphics() {
        // Set the Graphics Environment and set Font-Family
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();
        ComboBoxModel model = new DefaultComboBoxModel(fontNames);
        fontCombo.setModel(model);
    }

    public TextEditor() {
        initComponents();

        // setDimension of the Frame
        setDimention();

        // set the Graphics Environment
        setGraphics();

        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        colorBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        fontLable = new javax.swing.JLabel();
        fontCombo = new javax.swing.JComboBox();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        fontSizeLabel = new javax.swing.JLabel();
        sizeCombo = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        fontStyleLabel = new javax.swing.JLabel();
        styleCombo = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textPane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                textPaneMouseDragged(evt);
            }
        });
        jScrollPane1.setViewportView(textPane);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(636, 24));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 758, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jToolBar1.setRollover(true);
        jToolBar1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        colorBtn.setText("Color");
        colorBtn.setFocusable(false);
        colorBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        colorBtn.setPreferredSize(new java.awt.Dimension(58, 43));
        colorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorBtnActionPerformed(evt);
            }
        });
        jToolBar1.add(colorBtn);
        jToolBar1.add(jSeparator1);

        fontLable.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        fontLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fontLable.setText("Font");
        fontLable.setAlignmentX(0.5F);
        fontLable.setPreferredSize(new java.awt.Dimension(50, 46));
        fontLable.setSize(new java.awt.Dimension(10, 5));
        jToolBar1.add(fontLable);

        fontCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Times New Roman", "Arial", " " }));
        fontCombo.setPreferredSize(new java.awt.Dimension(300, 27));
        fontCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fontComboActionPerformed(evt);
            }
        });
        jToolBar1.add(fontCombo);
        jToolBar1.add(jSeparator4);

        fontSizeLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        fontSizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fontSizeLabel.setText("Font Size");
        fontSizeLabel.setAlignmentX(0.5F);
        jToolBar1.add(fontSizeLabel);

        sizeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "12", "14", "16", "18", "20" }));
        sizeCombo.setPreferredSize(new java.awt.Dimension(100, 27));
        sizeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeComboActionPerformed(evt);
            }
        });
        jToolBar1.add(sizeCombo);
        jToolBar1.add(jSeparator3);

        fontStyleLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        fontStyleLabel.setText("Style");
        fontStyleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToolBar1.add(fontStyleLabel);

        styleCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bold", "Italic", "Underline", "Plain" }));
        styleCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                styleComboActionPerformed(evt);
            }
        });
        jToolBar1.add(styleCombo);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fontComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fontComboActionPerformed

        startIndex = textPane.getSelectionStart();
        endIndex = textPane.getSelectionEnd();

        if (startIndex == endIndex) { // No selection, cursor position.
            textPane.setFont(new Font(fontCombo.getSelectedItem().toString(), Font.PLAIN, Integer.parseInt(sizeCombo.getSelectedItem().toString())));
        } else {
            doc = textPane.getStyledDocument();

            as = textPane.getCharacterAttributes();

            Style fontStyle = textPane.addStyle("MyFont", null);

            StyleConstants.setFontFamily(fontStyle, fontCombo.getSelectedItem().toString());
            doc.setCharacterAttributes(startIndex, endIndex - startIndex, fontStyle, false);
        }
    }//GEN-LAST:event_fontComboActionPerformed

    private void backwardSelection() {
        int life = startIndex;
        startIndex = endIndex;
        endIndex = life;
    }
    private void colorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorBtnActionPerformed

        Color selectedColor;

        selectedColor = JColorChooser.showDialog(null, "Select Color", currentColor);
        if (selectedColor != null) {
            doc = textPane.getStyledDocument();
            startIndex = textPane.getSelectionStart();
            endIndex = textPane.getSelectionEnd();
            if (startIndex == endIndex) { // No selection, cursor position.
                textPane.setForeground(selectedColor);
            } else if (startIndex > endIndex) { // Backwards selection?
                backwardSelection();
            }

            Style colorStyle = textPane.addStyle("MyColor", null);
            StyleConstants.setForeground(colorStyle, selectedColor);
            doc.setCharacterAttributes(startIndex, endIndex - startIndex, colorStyle, false);
        }
    }//GEN-LAST:event_colorBtnActionPerformed

    private void sizeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeComboActionPerformed

        startIndex = textPane.getSelectionStart();
        endIndex = textPane.getSelectionEnd();
        if (startIndex == endIndex) { // No selection, cursor position.
            textPane.setFont(new Font(fontCombo.getSelectedItem().toString(), Font.PLAIN, Integer.parseInt(sizeCombo.getSelectedItem().toString())));
        } else {
            doc = textPane.getStyledDocument();

            as = textPane.getCharacterAttributes();
            if (startIndex > endIndex) {// Backwards selection? 
                backwardSelection();
            }
            Style fontSize = textPane.addStyle("MySize", null);

            StyleConstants.setFontSize(fontSize, Integer.parseInt((String) sizeCombo.getSelectedItem()));
            doc.setCharacterAttributes(startIndex, endIndex - startIndex, fontSize, false);
        }
    }//GEN-LAST:event_sizeComboActionPerformed

    private void textPaneMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textPaneMouseDragged

        startIndex = textPane.getSelectionStart();
        endIndex = textPane.getSelectionEnd();

        if (startIndex > endIndex) { // Backwards selection?
            backwardSelection();
        }
    }//GEN-LAST:event_textPaneMouseDragged

    private void styleComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_styleComboActionPerformed

        startIndex = textPane.getSelectionStart();
        endIndex = textPane.getSelectionEnd();
        doc = textPane.getStyledDocument();
        as = textPane.getCharacterAttributes();

        stbold = textPane.addStyle("MyB", null);
        if (styleCombo.getSelectedIndex() == 0) {
            StyleConstants.setBold(stbold, rootPaneCheckingEnabled);
            if (startIndex == endIndex) {
                doc.setCharacterAttributes(0, doc.getLength(), stbold, false);
            } else {
                if (startIndex > endIndex) {
                    backwardSelection();
                }
                doc.setCharacterAttributes(startIndex, endIndex - startIndex, stbold, false);
            }
        } else if (styleCombo.getSelectedIndex() == 1) {
            StyleConstants.setItalic(stbold, rootPaneCheckingEnabled);
            if (startIndex == endIndex) {
                doc.setCharacterAttributes(0, doc.getLength(), stbold, false);
            } else {
                if (startIndex > endIndex) {
                    backwardSelection();
                }
                doc.setCharacterAttributes(startIndex, endIndex - startIndex, stbold, false);
            }
        } else if (styleCombo.getSelectedIndex() == 2) {
            StyleConstants.setUnderline(stbold, rootPaneCheckingEnabled);
            if (startIndex == endIndex) {
                doc.setCharacterAttributes(0, doc.getLength(), stbold, false);
            } else {
                if (startIndex > endIndex) {
                    backwardSelection();
                }
                doc.setCharacterAttributes(startIndex, endIndex - startIndex, stbold, false);
            }
        } else if (styleCombo.getSelectedIndex() == 3) {
            Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
            if (startIndex == endIndex) {
                doc.setCharacterAttributes(0, doc.getLength(), defaultStyle, false);
            } else {
                if (startIndex > endIndex) {
                    backwardSelection();
                }
                doc.setCharacterAttributes(startIndex, endIndex - startIndex, defaultStyle, true);
            }
        }
    }//GEN-LAST:event_styleComboActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton colorBtn;
    private javax.swing.JComboBox fontCombo;
    private javax.swing.JLabel fontLable;
    private javax.swing.JLabel fontSizeLabel;
    private javax.swing.JLabel fontStyleLabel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox sizeCombo;
    private javax.swing.JComboBox styleCombo;
    private javax.swing.JTextPane textPane;
    // End of variables declaration//GEN-END:variables
}
