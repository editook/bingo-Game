package bingoPrueba;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class ValidadorTest {
    
    public ValidadorTest() {
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
    public void VerificaCarton(){
       Validador Juez=new Validador ();
       String dato="2";
       String[][] prueba = {{null,null,null,null,null,null,null,null,null},
                             {"*","*","*","*","1","8","67","8","9"},
                            {"sd","as","sa","11","66","*","*","*","*"},
                            {"*","*","*","*","2","3","4","5","6"}};
       int acierto=Juez.verificarCarton(prueba,dato,3,4);
       Assert.assertEquals(1,acierto);
    }

    
}
     