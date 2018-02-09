package callCenterPrueba.service;

import java.util.Random;

public class EstadoEmpleados {
    Random random = new Random();
    public boolean getBoolean() {
        return random.nextBoolean();
    } 

}
