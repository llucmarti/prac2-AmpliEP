import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MachineComposite extends MachineComponent implements Observer {

    private List<MachineComponent> components = new ArrayList<>();
    private int brokenComponents = 0;

    public void addComponent(MachineComponent mc){
        components.add(mc);
        mc.addObserver(this);
        if(mc.isBroken()){
            brokenComponents+=1;
            if(!broken && brokenComponents == 1){
                setChanged();
                notifyObservers();
            }
        }
    }

    public boolean isBroken(){
        return broken || brokenComponents>0;
    }

    public void update(Observable observable, Object o) {
        MachineComponent machineComponent = (MachineComponent) o;
        if(machineComponent.isBroken()){
            brokenComponents+=1;
            boolean wasBroken = isBroken();
            if(!wasBroken){
                setChanged();
                notifyObservers();
            }
        }else{
            brokenComponents-=1;
            if(!isBroken()){
                setChanged();
                notifyObservers();
            }
        }
    }
}
