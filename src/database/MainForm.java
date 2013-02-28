package database;

import database.entity.Column;
import database.entity.ColumnType;
import database.entity.DataBase;
import database.entity.Entity;
import database.entity.Table;
import database.gui.table.AbstractMyTableModel;
import database.gui.table.MetadataTableModel;
import database.gui.table.list.MyListModel;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.ListModel;
import javax.swing.table.TableModel;

public class MainForm
        extends JFrame {

    private DataForm dataForm;
    private DataBase db;
    private int tableListSelectedIndex = -1;
    private AbstractMyTableModel<Column> metaTableModel;
    private MyListModel tableListModel;

    public MainForm () {
        //createNewDB( null );
        dataForm = new DataForm( this );
        initComponents();

        //db = new DataBase( "mock" );

        metaTableModel = new MetadataTableModel();
        dataTable.setModel( metaTableModel );

        //tableListModel = createTableListModel();
        //tableList.setModel( tableListModel );
    }

    @SuppressWarnings ( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Базу даних не обрано" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        tableList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                tableSelected(evt);
            }
        });
        jScrollPane1.setViewportView(tableList);

        jLabel1.setText("Таблицi:");

        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Заголовок 1"
            }
        ));
        jScrollPane2.setViewportView(dataTable);

        jLabel2.setText("Метаданi:");

        jMenu1.setText("База даних");

        jMenuItem1.setText("Створити");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createDB(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator2);

        jMenuItem2.setText("Вiдкрити");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDB(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Зберегти");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDB(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Метаданi");

        jMenuItem6.setText("Зберегти");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMetadata(evt);
            }
        });
        jMenu2.add(jMenuItem6);
        jMenu2.add(jSeparator1);

        jMenu5.setText("Таблиця");

        jMenuItem9.setText("Додати");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTable(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuItem10.setText("Видалити");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delTable(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenu2.add(jMenu5);

        jMenu4.setText("Колонка");

        jMenuItem4.setText("Додати");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addColumn(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem8.setText("Видалити");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delColumn(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenu2.add(jMenu4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Данi");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createDB(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createDB
        // TODO add your handling code here:
    }//GEN-LAST:event_createDB

    private void openDB(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openDB
        // TODO add your handling code here:
    }//GEN-LAST:event_openDB

    private void saveDB(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDB
        // TODO add your handling code here:
    }//GEN-LAST:event_saveDB

    private void saveMetadata(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMetadata
        // TODO add your handling code here:
    }//GEN-LAST:event_saveMetadata

    private void addTable(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTable
        // TODO add your handling code here:
    }//GEN-LAST:event_addTable

    private void delTable(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delTable
        // TODO add your handling code here:
    }//GEN-LAST:event_delTable

    private void addColumn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addColumn
        // TODO add your handling code here:
    }//GEN-LAST:event_addColumn

    private void delColumn(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delColumn
        // TODO add your handling code here:
    }//GEN-LAST:event_delColumn

    private void tableSelected(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_tableSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_tableSelected
/*
    private void showDataForm(java.awt.event.MouseEvent evt) {
        dataForm.setVisible( true );
        this.setEnabled( false );
    }

    private void createNewDB(java.awt.event.MouseEvent evt) {
        if ( db == null ) {
            db = new DataBase( "db" );
            db.setTables( new ArrayList<Table>() );
        }
        Table table = new Table( "test" );
        table.setColumns( new ArrayList<Column>() );
        Column column1 = new Column( "test col1" );
        column1.setSimpleType( ColumnType.DATE );
        Column column2 = new Column( "test col2" );
        column2.setSimpleType( ColumnType.DATE );
        Column column3 = new Column( "test col3" );
        column3.setSimpleType( ColumnType.DATE );
        table.getColumns().add( column1 );
        table.getColumns().add( column2 );
        table.getColumns().add( column3 );
        table.setData( new ArrayList<Entity>() );

        db.getTables().add( table );
    }

    private void addTable(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void delTable(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void tableListMouseClicked(java.awt.event.MouseEvent evt) {

        int tableIndex = tableList.getSelectedIndex();

        if ( tableListSelectedIndex == tableIndex )
            return;

        Table table = db.getTables().get( tableIndex );
        TableModel bufModel = dataTable.getModel();

        if ( bufModel instanceof AbstractMyTableModel ) {
            AbstractMyTableModel<Column> model = ( AbstractMyTableModel<Column> ) bufModel;
            model.clear();
            model.addValues( table.getColumns() );
        }
    }

    private void saveDB(java.awt.event.ActionEvent evt) {
        Table table = new Table( "test1" );
        table.setColumns( new ArrayList<Column>() );
        Column column1 = new Column( "test col11" );
        column1.setSimpleType( ColumnType.DATE );
        Column column2 = new Column( "test col22" );
        column2.setSimpleType( ColumnType.DATE );
        Column column3 = new Column( "test col33" );
        column3.setSimpleType( ColumnType.DATE );
        table.getColumns().add( column1 );
        table.getColumns().add( column2 );
        table.getColumns().add( column3 );
        table.setData( new ArrayList<Entity>() );

        db.getTables().add( table );
        tableListModel.updateWhenAdded();
        // TODO add your handling code here:
    }
*/
    private MyListModel<Table> createTableListModel () {
        tableListModel = new MyListModel<Table>( db.getTables() );
        return tableListModel;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dataTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JList tableList;
    // End of variables declaration//GEN-END:variables
}
