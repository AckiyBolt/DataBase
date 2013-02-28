package database.gui;

public interface UpdatableModel {

    void updateWhenChanged();
    void updateWhenAdded();
    void updateWhenRemoved();
}
