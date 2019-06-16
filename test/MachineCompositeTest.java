import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MachineCompositeTest {

    private MachineComposite composite;

    @BeforeEach
    void setUp() {
        composite = new MachineComposite();
    }

    @Test
    void addNewMachineTest(){
        composite.addComponent(new Machine());
        assertFalse(composite.isBroken());
    }

    @Test
    void addNewBrokenMachineTest(){
        Machine machine = new Machine();
        machine.setBroken();
        composite.addComponent(machine);
        assertTrue(composite.isBroken());
    }
}
