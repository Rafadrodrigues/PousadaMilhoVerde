/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

/**
 *
 * @author rafar
 */
public class GerenciarFinanceiro extends javax.swing.JInternalFrame {

    /**
     * Creates new form GerenciarFinanceiro
     */
    public GerenciarFinanceiro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lancarDiaria = new javax.swing.JButton();
        PrecoQuarto = new javax.swing.JButton();
        balancoMensal = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gerenciar Financeiro");

        jLabel8.setFont(new java.awt.Font("Roboto Slab Medium", 0, 12)); // NOI18N
        jLabel8.setText("Lançar Diária");

        jLabel9.setFont(new java.awt.Font("Roboto Slab Medium", 0, 12)); // NOI18N
        jLabel9.setText("Balanço Mensal");

        jLabel10.setFont(new java.awt.Font("Roboto Slab Medium", 0, 12)); // NOI18N
        jLabel10.setText("Preço dos Quartos");

        lancarDiaria.setFont(new java.awt.Font("Roboto Slab Medium", 0, 12)); // NOI18N
        lancarDiaria.setText("Lançar Diária");
        lancarDiaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lancarDiariaActionPerformed(evt);
            }
        });

        PrecoQuarto.setFont(new java.awt.Font("Roboto Slab Medium", 0, 12)); // NOI18N
        PrecoQuarto.setText("Preço dos Quartos");
        PrecoQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecoQuartoActionPerformed(evt);
            }
        });

        balancoMensal.setFont(new java.awt.Font("Roboto Slab Medium", 0, 12)); // NOI18N
        balancoMensal.setText("Balanço Mensal");
        balancoMensal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balancoMensalActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel7.setText("SELECIONE A OPÇÃO DESEJADA");

        jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lancarDiaria, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(PrecoQuarto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(balancoMensal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(73, 73, 73))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(balancoMensal, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(lancarDiaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PrecoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(107, 107, 107))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(52, 52, 52)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PrecoQuarto, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(lancarDiaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(90, 90, 90)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balancoMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/Imagens/icons8-voltar-24.png"))); // NOI18N
        jMenu1.setText("Voltar");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lancarDiariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lancarDiariaActionPerformed
        // TODO add your handling code here:
        LancarDiaria realizarRes = new LancarDiaria();
        jDesktopPane1.add(realizarRes);
        realizarRes.setVisible(true);

    }//GEN-LAST:event_lancarDiariaActionPerformed

    private void PrecoQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecoQuartoActionPerformed
        // TODO add your handling code here:
        ValorQuarto editarRes = new ValorQuarto();
        jDesktopPane1.add(editarRes);
        editarRes.setVisible(true);
    }//GEN-LAST:event_PrecoQuartoActionPerformed

    private void balancoMensalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balancoMensalActionPerformed
        // TODO add your handling code here:
        BalancoMensal cancelarRes = new BalancoMensal();
        jDesktopPane1.add(cancelarRes);
        cancelarRes.setVisible(true);
    }//GEN-LAST:event_balancoMensalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PrecoQuarto;
    private javax.swing.JButton balancoMensal;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton lancarDiaria;
    // End of variables declaration//GEN-END:variables
}
