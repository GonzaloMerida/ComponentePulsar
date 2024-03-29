/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package componentePulsar;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author Gonzalo
 */
public class ComponentePulsar extends javax.swing.JPanel {

    private File rutaImagen;
    private PulsacionListener pulsacionListener;

    /**
     * Creates new form ComponentePulsar
     */
    public ComponentePulsar() {
        initComponents();
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A,0),"pressedA");
        getActionMap().put("pressedA", new AbstractAction(){
        @Override
        public void actionPerformed(ActionEvent e){
            if(pulsacionListener != null){
                pulsacionListener.pulsacion();
            }
        }
    });
        this.setFocusable(true);
        this.requestFocusInWindow(); 
    }

    public void addPulsacionListener(PulsacionListener pulsacionListener) {
        this.pulsacionListener = pulsacionListener;
    }

    public void removePulsacionListener(PulsacionListener pulsacionListener) {
        this.pulsacionListener = null;
    }

    public File getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(File rutaImagen) {
        this.rutaImagen = rutaImagen;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (rutaImagen != null && rutaImagen.exists()) {
            //Creamos un objeto imagen a partir de la ruta que nos llega
            ImageIcon imageIcon = new ImageIcon(rutaImagen.getAbsolutePath());
            //Image imagenEscalada = imageIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
            g.drawImage(imageIcon.getImage(), 0, 0, null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
