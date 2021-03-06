/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user;

import executable.Client;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import server.actors.Group;
import view.util.GroupRenderer;

/**
 *
 * @author David
 */
public class ViewGroups extends JPanel {

    private final Client client;
    private final Home home;
    
    private DefaultListModel<Group> groupModel;
    private List<String> ids;
    
    /**
     * Creates new form Groups
     * @param c
     * @param home
     */
    public ViewGroups(Client c, Home home) {
        this.client = c;
        this.home = home;
        
        groupModel = new DefaultListModel<>();
        ids = new ArrayList<>();
        
        initComponents();
        listMyGroups(false);
    }

    private void listMyGroups(boolean reload){
        if(reload){
            groupModel.clear();
        }
        Iterator it = client.getDatabase().getGroups().entrySet().iterator();
        int i;
        for(i = 0; it.hasNext(); i++){
            Map.Entry pair = (Map.Entry) it.next();
            Group group = (Group) pair.getValue();
            if(group.isRelative(client.getUser())){
                groupModel.add(i, group);
                ids.add(pair.getKey().toString());
            } else {
                i--;
            }
        }
        myGroupsList.setCellRenderer(new GroupRenderer());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myGroupsLabel = new javax.swing.JLabel();
        aScrollPane = new javax.swing.JScrollPane();
        myGroupsList = new JList<>(groupModel);
        searchGroupField = new javax.swing.JTextField();
        btSearchGroup = new javax.swing.JButton();
        createGroupLabel = new javax.swing.JLabel();
        createGroupNameField = new javax.swing.JTextField();
        createGroupNameLabel = new javax.swing.JLabel();
        createGroupIdLabel = new javax.swing.JLabel();
        createGroupIdField = new javax.swing.JTextField();
        createGroupTosBox = new javax.swing.JCheckBox();
        btCreateGroup = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 0, 102));

        myGroupsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        myGroupsLabel.setText("Crie seu Grupo:");

        myGroupsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                myGroupsListValueChanged(evt);
            }
        });
        aScrollPane.setViewportView(myGroupsList);

        searchGroupField.setText("Pesquise um grupo pelo ID aqui...");
        searchGroupField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchGroupFieldMouseClicked(evt);
            }
        });

        btSearchGroup.setText("Pesquisar");
        btSearchGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchGroupActionPerformed(evt);
            }
        });

        createGroupLabel.setText("Seus Grupos:");

        createGroupNameLabel.setText("Nome do Grupo");

        createGroupIdLabel.setText("ID do Grupo");

        createGroupTosBox.setBackground(new java.awt.Color(255, 0, 102));
        createGroupTosBox.setText("N�o li, mas concordo com os Termos de Servi�o");

        btCreateGroup.setText("Criar");
        btCreateGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCreateGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchGroupField, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSearchGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(aScrollPane)
                    .addComponent(createGroupLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myGroupsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createGroupNameField)
                    .addComponent(createGroupIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createGroupIdField)
                    .addComponent(createGroupTosBox, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addComponent(btCreateGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createGroupNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myGroupsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createGroupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createGroupNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createGroupNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createGroupIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createGroupIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createGroupTosBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCreateGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(aScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchGroupField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearchGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btCreateGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCreateGroupActionPerformed
        if(createGroupNameField.getText().trim().equals("")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(client, "O nome est� vazio!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if(createGroupIdField.getText().trim().equals("")){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(client, "O ID est� vazio!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if(client.getDatabase().groupIdInUse(createGroupIdField.getText().toLowerCase())){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(client, "ID em uso!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if(!createGroupTosBox.isSelected()){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(client, "Voc� deve concordar com os Termos de Servi�o e Pol�tica de Privacidade para Criar um Grupo!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else {
            Group newGroup = new Group(createGroupNameField.getText(), createGroupIdField.getText().toLowerCase(), client.getUser());
            client.getDatabase().addGroupToDb(newGroup);
            home.getPage().removeAll();
            home.getPage().add(new Profile(client, newGroup, home));
            home.getPage().revalidate();
        }
    }//GEN-LAST:event_btCreateGroupActionPerformed

    private void btSearchGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchGroupActionPerformed
        Toolkit.getDefaultToolkit().beep();
        String id = searchGroupField.getText().toLowerCase();
        if(client.getDatabase().groupIdInUse(id)){
            Toolkit.getDefaultToolkit().beep();
            String[] options = {"Solicitar Entrada", "Cancelar"};
            if(client.getDatabase().getFromGroupId(id).isRelative(client.getUser())){
                options[0] = "Sair";
            }
            Group group = client.getDatabase().getFromGroupId(id);
            int selection = JOptionPane.showOptionDialog(client, "O que deseja fazer com " + group.getName() + " ?" , "Op��es de Intera��o", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);           
            if(selection == 0){
                if(group.isRelative(client.getUser())){
                    if(group.isAdmin(client.getUser()) && group.getAdmins().size() == 1){
                        JOptionPane.showMessageDialog(client, "Voc� era o �nico moderador de " + group.getName() + " e por isso o grupo foi desfeito!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        client.getDatabase().removeGroupFromDb(group);
                    } else {
                        JOptionPane.showMessageDialog(client, "Voc� saiu de " + group.getName(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        group.removeRelative(client.getUser());
                    }
                    listMyGroups(true);
                } else if(group.isBlocked(client.getUser())){
                    JOptionPane.showMessageDialog(client, group.getName() + " bloqueoou voc�!", "Aviso", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(client, "Pedido enviado para os moderadores de " + group.getName(), "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    group.sendNewRequest(client.getUser());
                }
            }
            searchGroupField.setText("Pesquise um grupo pelo ID aqui...");  
        } else {
            JOptionPane.showMessageDialog(client, "O grupo n�o existe!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btSearchGroupActionPerformed

    private void myGroupsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_myGroupsListValueChanged
        Toolkit.getDefaultToolkit().beep();
        int index = myGroupsList.getSelectedIndex();
        if(index >= 0){
            Group selected = client.getDatabase().getFromGroupId(ids.get(index));
            int confirm = JOptionPane.showConfirmDialog(client, "Voc� deseja visitar a p�gina de " + selected.getName() + " ?", "Aviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == 0) {
                home.getPage().removeAll();
                home.getPage().add(new Profile(client, selected, home));
                home.getPage().revalidate();
            }
        }
    }//GEN-LAST:event_myGroupsListValueChanged

    private void searchGroupFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchGroupFieldMouseClicked
        if(searchGroupField.getText().equals("Pesquise um grupo pelo ID aqui...")){
            searchGroupField.setText("");
        }
    }//GEN-LAST:event_searchGroupFieldMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane aScrollPane;
    private javax.swing.JButton btCreateGroup;
    private javax.swing.JButton btSearchGroup;
    private javax.swing.JTextField createGroupIdField;
    private javax.swing.JLabel createGroupIdLabel;
    private javax.swing.JLabel createGroupLabel;
    private javax.swing.JTextField createGroupNameField;
    private javax.swing.JLabel createGroupNameLabel;
    private javax.swing.JCheckBox createGroupTosBox;
    private javax.swing.JLabel myGroupsLabel;
    private javax.swing.JList<Group> myGroupsList;
    private javax.swing.JTextField searchGroupField;
    // End of variables declaration//GEN-END:variables
}
