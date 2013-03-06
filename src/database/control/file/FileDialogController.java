package database.control.file;

import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileDialogController {

    private JFileChooser chooser;

    public FileDialogController () {

        chooser = new JFileChooser();
        chooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
        chooser.setMultiSelectionEnabled( false );
        chooser.setApproveButtonText( "Обрати" );
        chooser.setDialogTitle( "Оберiть базу даних" );

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "База даних [*.db]", "db" );
        chooser.setFileFilter( filter );
    }

    public File showDialogAndGetFile ( Component parentComponent ) {
        File result = null;
        
        int dialogResult = chooser.showOpenDialog( parentComponent );
        if ( dialogResult == JFileChooser.APPROVE_OPTION ) {
            result = chooser.getSelectedFile();
        }

        return result;
    }
}
