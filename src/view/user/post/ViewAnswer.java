/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.user.post;

import executable.Client;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import server.actors.actions.Answer;
import server.actors.actions.Comment;
import util.Validator;

/**
 *
 * @author David
 */
public class ViewAnswer extends JPanel {

    private final Comment comment;
    private final Answer answer;

    private final boolean isOwner;
    private boolean isEditing;
    
    public ViewAnswer(Client c, Comment comment, Answer answer, boolean isWallOwner){
        this.comment = comment;
        this.answer = answer;
        
        if(isWallOwner){
            isOwner = true;
        } else {
            isOwner = Validator.isSameEmail(c.getUser().getId(), answer.getAuthor().getId());
        }
        
        isEditing = false;
        
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

        textField = new javax.swing.JTextPane();
        answersPanel = new javax.swing.JPanel();
        answersButtonsPanel = new javax.swing.JPanel();
        btDeleteAnswer = new javax.swing.JButton();
        btEditAnswer = new javax.swing.JButton();
        answersLabel = new javax.swing.JLabel();
        answersContentPanel = new javax.swing.JPanel();

        textField.setEditable(false);
        textField.setText(answer.getAnswer());
        textField.setToolTipText("");

        answersButtonsPanel.setLayout(new java.awt.GridLayout(1, 0));

        btDeleteAnswer.setText("Apagar");
        btDeleteAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteAnswerActionPerformed(evt);
            }
        });
        answersButtonsPanel.add(btDeleteAnswer);
        if(!isOwner){
            btDeleteAnswer.setEnabled(false);
        }

        btEditAnswer.setText("Editar");
        btEditAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditAnswerActionPerformed(evt);
            }
        });
        answersButtonsPanel.add(btEditAnswer);
        if(!isOwner){
            btEditAnswer.setEnabled(false);
        }

        answersLabel.setText("<html><b>" + answer.getAuthor().getName() + "</b> respondeu: </html>");

        answersContentPanel.setLayout(new javax.swing.BoxLayout(answersContentPanel, javax.swing.BoxLayout.LINE_AXIS));
        answersContentPanel.add(new JScrollPane(textField));

        javax.swing.GroupLayout answersPanelLayout = new javax.swing.GroupLayout(answersPanel);
        answersPanel.setLayout(answersPanelLayout);
        answersPanelLayout.setHorizontalGroup(
            answersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(answersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(answersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(answersLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addComponent(answersContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answersButtonsPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        answersPanelLayout.setVerticalGroup(
            answersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(answersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(answersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answersContentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answersButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(answersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(answersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btDeleteAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteAnswerActionPerformed
        comment.getAnswers().remove(answer);
        this.getParent().revalidate();
        this.getParent().remove(this);
    }//GEN-LAST:event_btDeleteAnswerActionPerformed

    private void btEditAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditAnswerActionPerformed
        if(!isEditing){
            textField.setEditable(true);
            btEditAnswer.setText("Salvar");
            isEditing = true;
        } else {
            textField.setEditable(false);
            comment.setText(textField.getText());
            btEditAnswer.setText("Editar");
            isEditing = false;
        }
    }//GEN-LAST:event_btEditAnswerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel answersButtonsPanel;
    private javax.swing.JPanel answersContentPanel;
    private javax.swing.JLabel answersLabel;
    private javax.swing.JPanel answersPanel;
    private javax.swing.JButton btDeleteAnswer;
    private javax.swing.JButton btEditAnswer;
    private javax.swing.JTextPane textField;
    // End of variables declaration//GEN-END:variables
}
