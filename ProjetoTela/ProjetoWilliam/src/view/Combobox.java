/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
/**
 *
 * @author jpgam
 */
public class Combobox<E> extends JComboBox<E>{
    private String labelText="Status";
    private Color lineColor = new Color(3,155,216);
    private boolean mouseIsOver;
    public Combobox(){
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(15,3,5,3));
//        setUI(new ComboUI());
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    public String getLabelText() {
        return labelText;
    }

    public Color getLineColor() {
        return lineColor;
    }
//    private class ComboUI extends BasicComboBoxUI{
//        public ComboUI(){
//            
//        }
//    }
}
