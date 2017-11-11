
package principal;
import java.io.*;
import sun.audio.*;
public class sonido {
      InputStream in ;
      AudioStream audio ; 
    public void  ruidillo() throws IOException{
        in=getClass().getResourceAsStream("sonidos/crip.wav");
        audio =new AudioStream(in);
        AudioPlayer.player.start(audio);
    }
     public void  moneditaSonido() throws IOException{
        in=getClass().getResourceAsStream("sonidos/moneda.wav");
        audio =new AudioStream(in);
        AudioPlayer.player.start(audio);
    }
}
