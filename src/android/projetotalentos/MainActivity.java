package android.projetotalentos;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.View;
import android.widget.Chronometer;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

//import java.util.Arrays;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Chronometer cronometro = (Chronometer) findViewById(R.id.chronometer1);
        cronometro.setBase(SystemClock.elapsedRealtime());
        cronometro.start();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        RatingBar nota = (RatingBar) findViewById(R.id.ratingBar1);
       
        //Define afirma��o
        Resources res = getResources();
        String[] afirmacoes = res.getStringArray(R.array.Afirmacoes);
         
        // Cria descri��o das estrelas
        nota.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
        	public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
 
        		/* N�o consegui transformar rating em int
        		switch(rating.intValue()) {
        			case 1: 
        				Toast.makeText(getApplicationContext(),"Discordo plenamente",Toast.LENGTH_LONG).show();
        				break;
        			case 2:
        				Toast.makeText(getApplicationContext(),"Discordo em partes",Toast.LENGTH_LONG).show();
        				break;
        			case 3:
        				Toast.makeText(getApplicationContext(),"Neutro",Toast.LENGTH_LONG).show();
        				break;
        			case 4:
        				Toast.makeText(getApplicationContext(),"Concordo",Toast.LENGTH_LONG).show();
        				break;
        			case 5:
        				Toast.makeText(getApplicationContext(),"Concordo plenamente",Toast.LENGTH_LONG).show();
        				break;
        		} */
        		
        		if(rating == 1.0)
        			Toast.makeText(getApplicationContext(),"Discordo plenamente",Toast.LENGTH_LONG).show();
        		else if(rating == 2.0)
        			Toast.makeText(getApplicationContext(),"Discordo em partes",Toast.LENGTH_LONG).show();
        		else if(rating == 3.0)
        			Toast.makeText(getApplicationContext(),"Neutro",Toast.LENGTH_LONG).show();
        		else if(rating == 4.0)
        			Toast.makeText(getApplicationContext(),"Concordo",Toast.LENGTH_LONG).show();
        		else if (rating == 5.0)
        			Toast.makeText(getApplicationContext(),"Concordo plenamente",Toast.LENGTH_LONG).show();
        		
        		//Toast.makeText(getApplicationContext(),"Your Selected Ratings  : " + String.valueOf(rating),Toast.LENGTH_LONG).show();
        		       		
            }
           });
        
        TextView afirmacao = (TextView) findViewById(R.id.textView2);
        afirmacao.setText(afirmacoes[1].toString());
        
        
        return true;
    }
    
    public void mostrarDescricao(View view) {
    	//Define afirma��o
        Resources res = getResources();
        String[] afirmacoes = res.getStringArray(R.array.Afirmacoes);
    	
        Chronometer cronometro = (Chronometer) findViewById(R.id.chronometer1);
        cronometro.stop();
        Toast.makeText(getApplicationContext(),cronometro.getText(),Toast.LENGTH_LONG).show();
        
        TextView afirmacao = (TextView) findViewById(R.id.textView2);
        afirmacao.setText(afirmacoes[2].toString());
    	
    }
    
    
    
}
