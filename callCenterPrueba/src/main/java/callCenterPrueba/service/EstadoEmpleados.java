package callCenterPrueba.service;

import java.util.Random;
/**
 * EstadoEmpleados
 * @author vera
 *metodo encargado de asignar un estado
 *aleatorio a un empleado
 *true=ocupado
 *false=libre
 */
public class EstadoEmpleados {
    Random random = new Random();
    public boolean getBoolean() {
        return random.nextBoolean();
    } 

}
