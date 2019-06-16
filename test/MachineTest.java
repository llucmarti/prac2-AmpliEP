import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineTest {

    private Machine machine;
    @BeforeEach
    void setUp() {
        machine = new Machine();
    }

    @Test
    public void setBrokenTest(){
        assertFalse(machine.isBroken());
        machine.setBroken();
        assertTrue(machine.isBroken());
    }

    @Test
    public void repairTest(){
        machine.setBroken();
        assertTrue(machine.isBroken());
        machine.repair();
        assertFalse(machine.isBroken());
    }



}