package com.awsmsoft.awesomelistapp.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.awsmsoft.awesomelistapp.R;

/**
 * Created by sierisimo on 12/04/15.
 */
public class Helpers {

    /**
     * Para la navegacion de entre fragments
     *
     * @param fragmentReplace   int el Id del recurso que es ocupado como contenedor de los
     *                          fragments
     * @param fragmentSiguiente fragment el fragment que se va a cargar en la posicion de
     *                          fragmentReplace
     * @param fragmentManager   fragment manager, si es FragmnetActivity se usa
     *                          getSupportFragmentMnager, si es Fragment se ocupa
     *                          getFragmnetManager
     */
    public static void fragmentChooser(int fragmentReplace, Fragment fragmentSiguiente, FragmentManager fragmentManager) {
        FragmentTransaction transactionList = fragmentManager.beginTransaction();
        transactionList.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        transactionList.replace(fragmentReplace, fragmentSiguiente);
        transactionList.addToBackStack("pila");
        transactionList.commit();
    }

    /**
     * Para la navegacion de entre fragments
     *
     * @param fragmentReplace   int el Id del recurso que es ocupado como contenedor de los
     *                          fragments
     * @param fragmentSiguiente fragment el fragment que se va a cargar en la posicion de
     *                          fragmentReplace
     * @param fragmentManager   fragment manager, si es FragmnetActivity se usa
     *                          getSupportFragmentMnager, si es Fragment se ocupa
     *                          getFragmnetManager
     * @param tag               String que representa el nombre del fragment que se guarda
     */
    public static void fragmentChooser(int fragmentReplace, Fragment fragmentSiguiente, FragmentManager fragmentManager, String tag) {
        FragmentTransaction transactionList = fragmentManager.beginTransaction();
        transactionList.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        transactionList.replace(fragmentReplace, fragmentSiguiente, tag);
        transactionList.addToBackStack("pila");
        transactionList.commit();
    }

    public static void fragmentChooserWithoutAddToBackStack(int fragmentReplace, Fragment fragmentSiguiente, FragmentManager fragmentManager) {
        FragmentTransaction transactionList = fragmentManager.beginTransaction();
        transactionList.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        transactionList.replace(fragmentReplace, fragmentSiguiente);
        transactionList.commit();

    }

    public static void fragmentChooserWithoutAddToBackStack(int fragmentReplace, Fragment fragmentSiguiente, FragmentManager fragmentManager, String tag) {
        FragmentTransaction transactionList = fragmentManager.beginTransaction();
        transactionList.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        transactionList.replace(fragmentReplace, fragmentSiguiente, tag);
        transactionList.commit();
    }
}
