package come.example.fraleo.circulito;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private BitmapDrawable miImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView (this));

    }
    public class EjemploView extends View{

        public EjemploView (Context contexto){
            super (contexto);
            Resources res = contexto.getResources();
            miImagen = (BitmapDrawable) res.getDrawable(R.drawable.descarga);
            miImagen.setBounds(new Rect(30,30,200,200));
        }
        protected void onDraw (Canvas canvas){
            Paint pincel = new Paint();
            pincel.setColor(Color.BLUE);
            pincel.setStrokeWidth(15);
            pincel.setStyle(Paint.Style.STROKE);
            miImagen.draw(canvas);
            canvas.drawCircle(150, 150, 80, pincel);
            canvas.drawLine(300,300,90,100,pincel);
        }
    }
}
