import java.util.Observable;

public abstract class MachineComponent extends Observable {
    protected boolean broken = false;
    private boolean wasBroken;

    public void setBroken(){
        wasBroken = broken;
        broken = true;
        if(!wasBroken){
            setChanged();
            notifyObservers();
        }
    }

    public void repair() {
        wasBroken = broken;
        broken = false;
        if(wasBroken){
            setChanged();
            notifyObservers();
        }
    }

    public abstract boolean isBroken();
}
