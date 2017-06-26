package diogo.miranda.pert.Model;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculoPertTest  {

    CalculoPert calculoPert = new CalculoPert ();

   @Test
    public void CalculoPert(){
        int o = 6;
        int m = 9;
        int p = 20;
        Long otimista = Long.valueOf (o);
        Long mais_provavel = Long.valueOf (m);
        Long pessimista = Long.valueOf (p);
        CalculoPert calculoPert = new CalculoPert(otimista,mais_provavel,pessimista);
        assertEquals(10.0,calculoPert.getResultado());

    }

}