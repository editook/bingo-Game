package bingoPrueba;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JuradoTest {
    public JuradoTest() {
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
    public void Compara_bingo_15_aciertos_true(){
        String [][] prueba=new String[3][9];
        generadorTabla matriz = new generadorTabla ();
        matriz.llenarVacios(prueba);
        matriz.llenarNumeros(prueba);
        boolean verdad = Jurado.verificarMarcados(prueba);
        Assert.assertEquals(true,verdad);
}
      @Test
    public void Compara_bingo_14_aciertos_false(){//en caso de que mande false
        Jurado juez=new Jurado();
        String carton[][]={{"X","X","1","X","X","*","*","*","*"},
                           {"X","X","X","X","X","*","*","*","*"},
                           {"X","X","X","X","X","*","*","*","*"}};
        Assert.assertEquals(false,juez.verificarMarcados(carton));
}
}
