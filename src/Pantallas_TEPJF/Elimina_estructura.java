/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantallas_TEPJF;


import java.awt.Color;
import java.sql.SQLException;
import java.time.Year;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mx.org.inegi.Procedure.TEPJF.CreaEstructura;
import mx.org.inegi.Procedure.TEPJF.EliminaEstructura;

/**
 *
 * @author LAURA.MEDINAJ
 */
public class Elimina_estructura extends javax.swing.JFrame {

    public static String YearTEPJF = "";

    public Elimina_estructura() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);//JFRAME COLOR POR DEFAULT BLANCO
        Field_yearTEPJF.setEnabled(false);
        Field_yearTEPJF.setText(String.valueOf(Year.now().getValue()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelLogo = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        Panel_BlueLabel = new javax.swing.JPanel();
        LabelTRIBUNALELECTORALFEDERAL = new javax.swing.JLabel();
        Button_CreaEstructura = new javax.swing.JToggleButton();
        Field_yearTEPJF = new javax.swing.JTextField();
        Button_anotherYear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PanelLogo.setBackground(new java.awt.Color(255, 255, 255));

        LabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo CNG.png"))); // NOI18N

        Panel_BlueLabel.setBackground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout Panel_BlueLabelLayout = new javax.swing.GroupLayout(Panel_BlueLabel);
        Panel_BlueLabel.setLayout(Panel_BlueLabelLayout);
        Panel_BlueLabelLayout.setHorizontalGroup(
            Panel_BlueLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Panel_BlueLabelLayout.setVerticalGroup(
            Panel_BlueLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        LabelTRIBUNALELECTORALFEDERAL.setBackground(new java.awt.Color(0, 0, 102));
        LabelTRIBUNALELECTORALFEDERAL.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        LabelTRIBUNALELECTORALFEDERAL.setText("TRIBUNAL ELECTORAL FEDERAL");

        javax.swing.GroupLayout PanelLogoLayout = new javax.swing.GroupLayout(PanelLogo);
        PanelLogo.setLayout(PanelLogoLayout);
        PanelLogoLayout.setHorizontalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_BlueLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLogoLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(LabelTRIBUNALELECTORALFEDERAL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        PanelLogoLayout.setVerticalGroup(
            PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelLogoLayout.createSequentialGroup()
                        .addComponent(LabelTRIBUNALELECTORALFEDERAL)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(17, 17, 17)
                .addComponent(Panel_BlueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Button_CreaEstructura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BValidar.png"))); // NOI18N
        Button_CreaEstructura.setText("Eliminar");
        Button_CreaEstructura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CreaEstructuraActionPerformed(evt);
            }
        });

        Button_anotherYear.setText("Otro año");
        Button_anotherYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_anotherYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Button_CreaEstructura)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(Field_yearTEPJF, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Button_anotherYear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Field_yearTEPJF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_anotherYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(Button_CreaEstructura)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_CreaEstructuraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CreaEstructuraActionPerformed
        YearTEPJF = Field_yearTEPJF.getText();
        int crear = JOptionPane.showConfirmDialog(Elimina_estructura.this, // Usamos la ventana actual como padre
                "¿Está seguro de eliminar estructura TEPJF " + YearTEPJF + "?",
                "Confirmar ELIMINACIÓN de estructura",
                JOptionPane.YES_NO_OPTION
        );

        if (crear == JOptionPane.YES_OPTION) {
            EliminaEstructura estructura = new EliminaEstructura();
            try {
                estructura.EliminaEstructura();
                JOptionPane.showMessageDialog(Elimina_estructura.this, "La estructura ha sido eliminada");
            } catch (SQLException ex) {
                Logger.getLogger(Elimina_estructura.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else {

            JOptionPane.showMessageDialog(Elimina_estructura.this, "Acción cancelada.");
        }


    }//GEN-LAST:event_Button_CreaEstructuraActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Menu men = new Menu();
        men.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void Button_anotherYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_anotherYearActionPerformed
        Field_yearTEPJF.setText("");
        Field_yearTEPJF.setEnabled(true);
    }//GEN-LAST:event_Button_anotherYearActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Elimina_estructura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Elimina_estructura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Elimina_estructura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Elimina_estructura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Elimina_estructura().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Button_CreaEstructura;
    private javax.swing.JButton Button_anotherYear;
    private static javax.swing.JTextField Field_yearTEPJF;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelTRIBUNALELECTORALFEDERAL;
    private javax.swing.JPanel PanelLogo;
    private javax.swing.JPanel Panel_BlueLabel;
    // End of variables declaration//GEN-END:variables

   
}
