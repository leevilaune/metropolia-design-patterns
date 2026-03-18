package dev.onesnzeroes.designpatterns.memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private int mementoIndex;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.mementoIndex = 0;
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (mementoIndex <= 0) return;
        mementoIndex--;
        IMemento state = history.get(mementoIndex);
        model.restoreState(state);
        gui.updateGui();
    }

    public void redo() {
        if (mementoIndex >= history.size()) return;
        IMemento state = history.get(mementoIndex);
        mementoIndex++;
        model.restoreState(state);
        gui.updateGui();
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
        this.mementoIndex = this.history.size()-1;
    }
    public List<IMemento> getHistory() {
        return history;
    }

    public int getCurrentStateIndex() {
        return mementoIndex - 1;
    }

    public void revertToState(int index) {
        if (index < 0 || index >= history.size()) return;

        mementoIndex = index + 1;
        IMemento state = history.get(index);
        model.restoreState(state);
        gui.updateGui();
    }
    public void updateGui(){
        this.gui.updateGui();
    }
}