package bingoPrueba;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class generadorTablaTest {
    
    public generadorTablaTest() {
    }
    @BeforeClass
    public static void setUpClass() {
    }
    @AfterClass
    public static void tearDownClass() {
    }
    @Before
    public void setUp() {
    }   
    @After
    public void tearDown() {
    }
     @Test
    public void testLlenarVacios() {
        System.out.println("llenarVacios");        
        String[][] carton = {{null,"1","2","56","14",null,"22",null,null},//fracmento de clase inicio de llenar vacios
                            {"4","12",null,"66","21",null,null,null,null},
                             {"48","72",null,"63","51",null,null,null,null}};
        assertEquals(null, carton[0][0]);
        carton[0][0]="***";
        Assert.assertEquals("***", carton[0][0]);
    }
    @Test
    public void testCartonSoloAsteriscos() {        
     System.out.println("Verifica 12 asteriscos");
        String [][] prueba=new String[3][9];
        generadorTabla matriz = new generadorTabla ();
        matriz.llenarVacios(prueba);
        int salida=matriz.contadorAsterisco(prueba);
        Assert.assertEquals(12, salida);
        System.out.println(salida);     
    }
    @Test
    public void testLlenarNumeros() {
        System.out.println("llenarNumeros");
        String[][] carton = {{null,null,"1","3","53"},
                            {"33","54","65","7","96"}};
        Assert.assertNull(carton[0][0]);
        String valor=(String.valueOf(1));
        carton[0][0]=valor;
        Assert.assertNotNull(carton[0][0]);
    }
    @ Test
    public void testVerificaRangoNumeros_90(){
        String [][] prueba=new String[3][9];
        generadorTabla matriz = new generadorTabla ();
        matriz.llenarVacios(prueba);
        matriz.llenarNumeros(prueba);
        int dato=matriz.contadornumeros(prueba);
        Assert.assertEquals(15,dato);
    }
    @ Test
    public void noRepetidos () {
        String [][] prueba=new String[3][9];
        generadorTabla matriz = new generadorTabla ();
       matriz.llenarVacios(prueba);
       matriz.llenarNumeros(prueba);
        int salida=matriz.detectaRepetidos(prueba);//elimina repetidos y muestra la cant de datos Numericos
        Assert.assertEquals(15,salida);
    }
    
}
