package database.control;

public abstract class AbstractController {

    protected ControllersHolder holder;

    AbstractController ( ControllersHolder holder ) {
        this.holder = holder;
    }
}
