/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.pkgdo.barbeiro;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

/**
 *
 * @author root
 */
public class ProblemaDoBarbeiro implements Observable {

    private static Semaphore cadeiraBarbearia = new Semaphore(5, true);
    private final Object lock = new Object();

    public void connect() {
        try {
            cadeiraBarbearia.acquire();
        } catch (InterruptedException ex) {
            System.out.println("Erro ao sentar na cadeira do barbeiro.");
        }

        try {
            cortar();
        } finally {
            cadeiraBarbearia.release();
        }
    }

    private synchronized void cortar() {

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Não foi possível fazer a thread dormir.");
        }
        lock.notify();

    }

    @Override
    public void addListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeListener(InvalidationListener listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
