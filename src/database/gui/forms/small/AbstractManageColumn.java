package database.gui.forms.small;

import database.control.ControllersHolder;
import database.control.ErrorHolder;
import database.entity.Column;
import database.entity.ColumnType;
import database.entity.Table;
import database.gui.AbstractSubsidiaryForm;
import database.model.combobox.MyComboBoxModel;
import java.util.List;
import javax.swing.JFrame;

public abstract class AbstractManageColumn
        extends AbstractSubsidiaryForm {

    private Boolean simpleTypeFlag;
    private MyComboBoxModel<String> complexTypeModel;
    private MyComboBoxModel<ColumnType> simpleTypeModel;
    private ErrorHolder holder;

    public AbstractManageColumn ( JFrame mainForm, String okButtonText, List<Table> tables, ErrorHolder holder ) {
        super( mainForm );

        this.okButton.setText( okButtonText );
        this.cancelButton.setText( "Вiдмiна" );
        this.holder = holder;

        initComplexModel( tables );
        initSimpleModel();
    }

    @Override
    protected void initForm () {
        initComponents();
        buttonGroup1.add( simpleRB );
        buttonGroup1.add( complexRB );

        simpleTypeFlag = true;
    }

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tableNameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        simpleRB = new javax.swing.JRadioButton();
        complexRB = new javax.swing.JRadioButton();
        typeComboBox = new javax.swing.JComboBox();
        pkCheckBox = new javax.swing.JCheckBox();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Назва:");

        jLabel2.setText("Тип:");

        simpleRB.setText("Простий");
        simpleRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpleChanged(evt);
            }
        });

        complexRB.setText("Комплексний");
        complexRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complexChanged(evt);
            }
        });

        pkCheckBox.setText("Первинный ключ");

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okAction(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAction(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tableNameTextField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(simpleRB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(complexRB))
                    .addComponent(pkCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpleRB)
                    .addComponent(complexRB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pkCheckBox)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected abstract void okAction ( java.awt.event.ActionEvent evt );

    private void cancelAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAction
        this.dispose();
    }//GEN-LAST:event_cancelAction

    private void complexChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complexChanged
        simpleTypeFlag = false;
        if ( complexTypeModel != null ) {
            typeComboBox.setModel( complexTypeModel );
        }
    }//GEN-LAST:event_complexChanged

    private void simpleChanged(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpleChanged
        simpleTypeFlag = true;
        if ( simpleTypeModel != null ) {
            typeComboBox.setModel( simpleTypeModel );
        }
    }//GEN-LAST:event_simpleChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JRadioButton complexRB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton okButton;
    private javax.swing.JCheckBox pkCheckBox;
    private javax.swing.JRadioButton simpleRB;
    private javax.swing.JTextField tableNameTextField;
    private javax.swing.JComboBox typeComboBox;
    // End of variables declaration//GEN-END:variables

    private void initComplexModel ( List<Table> tables ) {
        complexTypeModel = new MyComboBoxModel<String>();
        for ( Table table : tables ) {
            complexTypeModel.addElement( table.getName() );
        }
    }

    private void initSimpleModel () {
        simpleTypeModel = new MyComboBoxModel<ColumnType>();
        for ( ColumnType type : ColumnType.values() ) {
            simpleTypeModel.addElement( type );
        }
    }

    protected Column getColumn () {
        Column result = new Column( this.tableNameTextField.getText() );
        result.setPrimaryKey( pkCheckBox.isSelected() );
        result.setComplexType( simpleTypeFlag ?
                               null :
                               typeComboBox.getSelectedItem().toString() );
        result.setSimpleType( simpleTypeFlag ?
                              ColumnType.valueOf( typeComboBox.getSelectedItem().toString() ) :
                              null );
        return result;
    }

    protected boolean checkData () {
        
        String name = this.tableNameTextField.getText();
        if ( name == null || name.isEmpty() )
            holder.addError( "Назва порожня." );

        Object type = typeComboBox.getSelectedItem();
        if ( type == null )
            holder.addError( "Тип не обрано." );

        return holder.getMessage().isEmpty();
    }
}
