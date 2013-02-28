package database.gui;

import javax.swing.JFrame;

public abstract class AbstractSubsidiaryForm
        extends JFrame {

    private JFrame mainForm;

    public AbstractSubsidiaryForm ( JFrame mainForm ) {
        initForm();
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        this.mainForm = mainForm;
        this.mainForm.setEnabled( false );
        this.setVisible( true );
        this.setLocation( 400, 400 );
    }

    protected abstract void initForm ();

    @Override
    public void dispose () {
        mainForm.setEnabled( true );
        mainForm.setVisible( true );
        this.setVisible( false );
        super.dispose();
    }
}
