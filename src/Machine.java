public class Machine extends MachineComponent {

    private boolean broken = false;
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

    public boolean isBroken() {
        return broken;
    }
}
