/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi.view;

import java.sql.Connection;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import sistem_akuntansi.Factory;
import sistem_akuntansi.entity.PembelianDetail;
import sistem_akuntansi.model.PembelianDetailModel;
import sistem_akuntansi.model.PembelianDetailTableModelReturn;
/**
 *
 * @author VELIK
 */
public class PembelianDetailData extends javax.swing.JDialog {

    
    private Connection connection;
    private PembelianDetailModel pembelianDetailModel;
    private PembelianDetailTableModelReturn pembelianDetailTableModel;
    /**
     * Creates new form PembelianDetailData
     */
    public PembelianDetailData(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        connection = Factory.getConnection();
        pembelianDetailModel= new PembelianDetailModel(connection);
        pembelianDetailTableModel = new PembelianDetailTableModelReturn(new Vector<PembelianDetail>());
        restructureTable();
    }
    private void restructureTable(){
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        tabelDetailPembelian.setModel(pembelianDetailTableModel);
                    
        //pengaturan perataan kolom
       /// tabelPembelian.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        //tabelPembelian.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        
        
        //pengaturan lebar kolom
        tabelDetailPembelian.getColumnModel().getColumn(0).setPreferredWidth(300);
        tabelDetailPembelian.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabelDetailPembelian.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabelDetailPembelian.getColumnModel().getColumn(3).setPreferredWidth(400);
        tabelDetailPembelian.getColumnModel().getColumn(4).setPreferredWidth(400);
        tabelDetailPembelian.getColumnModel().getColumn(5).setPreferredWidth(300);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textPencarian = new javax.swing.JTextField();
        buttonCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDetailPembelian = new javax.swing.JTable();
        buttonPilih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DAFTAR DATA DETAIL PEMBELIAN");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Masukan Kata Pencarian");

        buttonCari.setText("CARI");
        buttonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariActionPerformed(evt);
            }
        });

        tabelDetailPembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelDetailPembelian);

        buttonPilih.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        buttonPilih.setText("PILIH");
        buttonPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPilihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonPilih))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textPencarian, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCari)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPilih)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPilihActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_buttonPilihActionPerformed

    private void buttonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariActionPerformed
        // TODO add your handling code here:
        pembelianDetailTableModel.setData(pembelianDetailModel.search(textPencarian.getText()));
        pembelianDetailTableModel.fireTableDataChanged();
    }//GEN-LAST:event_buttonCariActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        pembelianDetailTableModel.setData(pembelianDetailModel.search(textPencarian.getText()));
        pembelianDetailTableModel.fireTableDataChanged();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PembelianDetailData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PembelianDetailData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PembelianDetailData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PembelianDetailData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PembelianDetailData dialog = new PembelianDetailData(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCari;
    private javax.swing.JButton buttonPilih;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelDetailPembelian;
    private javax.swing.JTextField textPencarian;
    // End of variables declaration//GEN-END:variables
public PembelianDetail getDataSelection() {
        int index = tabelDetailPembelian.getSelectedRow();
        PembelianDetail pembelianDetail = null;
        if (index >= 0){
            pembelianDetail = pembelianDetailTableModel.getData().get(tabelDetailPembelian.convertRowIndexToModel(index));
        }
        return pembelianDetail;
    }
}