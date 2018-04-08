package edu.mobile.digital.workshopandroid;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by brext409 on 08/04/2018.
 */

public class OuvinteEventos implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {

    Context context;

    private int xIncremento;
    private int yIncremento;
    private boolean foiClickada = false;
    private ObjectAnimator animation;


    public OuvinteEventos(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, "Imagem Clickada", Toast.LENGTH_SHORT).show();
        if(foiClickada) {
            animation = ObjectAnimator.ofFloat(v, "translationY", 0f);
            foiClickada = false;
        }else {
            animation = ObjectAnimator.ofFloat(v, "translationY", 700f);
            foiClickada = true;
        }
        animation.setDuration(2000);
        animation.start();
    }

    @Override
    public boolean onLongClick(View v) {
        Toast.makeText(context,"Imagem Pressionada",Toast.LENGTH_SHORT).show();
        if(foiClickada) {
            animation = ObjectAnimator.ofFloat(v, "translationX", 0);
            foiClickada = false;
        }else {
            animation = ObjectAnimator.ofFloat(v, "translationX", 500f);
            foiClickada = true;
        }
        animation.setDuration(2000);
        animation.start();
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        final int xAtual = (int) event.getRawX();
        final int yAtual = (int) event.getRawY();

        switch (event.getAction() & MotionEvent.ACTION_MASK){

            case MotionEvent.ACTION_DOWN:

                RelativeLayout.LayoutParams margensAtual = (RelativeLayout.LayoutParams) v.getLayoutParams();
                xIncremento = xAtual - margensAtual.leftMargin;
                yIncremento = yAtual - margensAtual.topMargin;
                break;

            case MotionEvent.ACTION_MOVE:

                RelativeLayout.LayoutParams margensModificadas = (RelativeLayout.LayoutParams) v.getLayoutParams();

                margensModificadas.leftMargin = xAtual - xIncremento;
                margensModificadas.topMargin = yAtual - yIncremento;
                margensModificadas.rightMargin = 0;
                margensModificadas.bottomMargin = 0;
                v.setLayoutParams(margensModificadas);
                break;
        }

        return true;
    }
}
