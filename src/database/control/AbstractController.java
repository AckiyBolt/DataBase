package database.control;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public abstract class AbstractController {

    protected ControllersHolder holder;

    AbstractController ( ControllersHolder holder ) {
        this.holder = holder;
    }
}