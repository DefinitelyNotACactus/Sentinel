/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user.profile;

import executable.Client;
import util.Constants;
import view.user.post.NewPostPanel;
import view.user.post.PostPanel;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import server.Post;
import server.actors.User;
import view.user.Profile;

/**
 *
 * @author David
 */
public class Wall extends javax.swing.JPanel {

    private final Client client;
    private final User user;
    
    private NewPostPanel newPost;
    private boolean isNewPost;

    private DefaultListModel userPostModel;
    private DefaultListModel thirdUserPostModel;
    
    public Wall(Client c, User user){
        newPost = null;
        isNewPost = true;
        this.client = c;
        this.user = user;
        
        userPostModel = new DefaultListModel();
        thirdUserPostModel = new DefaultListModel();
        
        initComponents();
        listPosts(false);
    }
    
    private void listPosts(boolean reload){
        if(reload){
            userPostModel.clear();
        }
        Iterator it = user.getPosts().iterator();
        int i;
        for(i = 0; it.hasNext(); i++) {
            userPostModel.add(i, it.next().toString());
        }
        it = user.getPostsFromOthers().iterator();
        for(i = 0; it.hasNext(); i++){
            thirdUserPostModel.add(i, it.next().toString());
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

        userWallPostLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userWallPostList = new javax.swing.JList<>(userPostModel);
        thirdPersonWallPostLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        thirdPersonWallPostList = new javax.swing.JList<>(thirdUserPostModel);
        postPanel = new javax.swing.JPanel();
        btReply = new javax.swing.JButton();
        btLike = new javax.swing.JButton();
        btNewPost = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 102, 153));
        setPreferredSize(new java.awt.Dimension(1086, 638));

        userWallPostLabel.setText("userWallPostLabel");

        userWallPostList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                userWallPostListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(userWallPostList);

        thirdPersonWallPostLabel.setText("thirdPersonWallPostLabel");

        thirdPersonWallPostList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                thirdPersonWallPostListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(thirdPersonWallPostList);

        postPanel.setPreferredSize(new java.awt.Dimension(830, 570));
        postPanel.setLayout(new javax.swing.BoxLayout(postPanel, javax.swing.BoxLayout.LINE_AXIS));
        postPanel.add(new JLabel("Selectione uma mensagem para visualizá-la"));

        btReply.setText("Responder");
        btReply.setEnabled(false);

        btLike.setText("Curtir");
        btLike.setEnabled(false);

        btNewPost.setText("Nova Mensagem");
        btNewPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewPostActionPerformed(evt);
            }
        });

        btDelete.setText("Apagar");
        btDelete.setEnabled(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userWallPostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thirdPersonWallPostLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btNewPost, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btReply, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btLike, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(postPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userWallPostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thirdPersonWallPostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(postPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btNewPost, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btReply, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btLike, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btNewPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewPostActionPerformed
        if(isNewPost){
            newPost = new NewPostPanel();
            postPanel.removeAll();
            postPanel.add(newPost);
            btNewPost.setText("Enviar");
            isNewPost = false;
        } else {
            if(newPost.getTitle().trim().equals("")){
                JOptionPane.showMessageDialog(client, Constants.NULL_TITLE, "Aviso", JOptionPane.WARNING_MESSAGE);  
            } else if(newPost.getText().trim().equals("")){
                JOptionPane.showMessageDialog(client, Constants.NULL_TEXT, "Aviso", JOptionPane.WARNING_MESSAGE);  
            } else {
                Post post = new Post(newPost.getTitle(), newPost.getText(), client.getUser());
                if(client.getUser().getId().equals(user.getId())){
                    user.addPost(post);
                } else {
                    user.addPostFromOthers(post);
                }
                postPanel.removeAll();
                postPanel.add(new PostPanel(post));
                btNewPost.setText("Nova Mensagem");
                listPosts(true);
                isNewPost = true;
            }
        }
        postPanel.revalidate();
    }//GEN-LAST:event_btNewPostActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        //TODO
    }//GEN-LAST:event_btDeleteActionPerformed

    private void userWallPostListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_userWallPostListValueChanged
        int index = userWallPostList.getSelectedIndex();
        if(index >= 0){
            Post post = user.getPost(index);
            postPanel.removeAll();
            postPanel.add(new PostPanel(post));
            postPanel.revalidate();
        }
    }//GEN-LAST:event_userWallPostListValueChanged

    private void thirdPersonWallPostListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_thirdPersonWallPostListValueChanged
        int index = thirdPersonWallPostList.getSelectedIndex();
        if(index >= 0){
            Post post = user.getPostFromOthersByIndex(index);
            postPanel.removeAll();
            postPanel.add(new PostPanel(post));
            postPanel.revalidate();
        }
    }//GEN-LAST:event_thirdPersonWallPostListValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btLike;
    private javax.swing.JButton btNewPost;
    private javax.swing.JButton btReply;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel postPanel;
    private javax.swing.JLabel thirdPersonWallPostLabel;
    private javax.swing.JList<Post> thirdPersonWallPostList;
    private javax.swing.JLabel userWallPostLabel;
    private javax.swing.JList<Post> userWallPostList;
    // End of variables declaration//GEN-END:variables
}
