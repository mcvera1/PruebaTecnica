package callCenterPrueba.callCenterPrueba;

import callCenterPrueba.implement.Dispatcher;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	/**
	 * pruba unitaria para cuando ingresan 10 llamadas
	 * asignadas a 10 empleados
	 */
	public void llamadasTest(){
    	Dispatcher di = new Dispatcher();
    	di.duracionLlamada(10);
    	di.cantidadEmpleado(10);
    	di.dispatcherCall();
    	assertEquals(10, 10);
	}
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	llamadasTest();
    }
}
