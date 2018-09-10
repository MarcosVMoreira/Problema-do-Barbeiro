/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.pkgdo.barbeiro;

import java.util.concurrent.Semaphore;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 * @author root
 */
public class ProblemaDoBarbeiro extends Observable {

    private static Semaphore cadeiraBarbearia = new Semaphore(5, true);
    private Object lock = new Object();
    private static final ProblemaDoBarbeiro instance = new ProblemaDoBarbeiro();
    private int cadeirasOcupadas;
    private boolean cadeiraBarbeiroOcupada = false;
    private AtomicBoolean executa;

    public ProblemaDoBarbeiro() {
        cadeirasOcupadas = 0;
        lock = new Object();
        executa = new AtomicBoolean(true);
    }

    public static ProblemaDoBarbeiro getInstance() {
        return instance;
    }

    public void connect() throws InterruptedException {
        while (executa.get()) {
            try {
                System.out.println("Cadeira de espera ocupada");
                cadeiraBarbearia.acquire();
                cadeirasOcupadas++;
                setChanged();
                notifyObservers();
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Erro ao sentar na cadeira do barbeiro.");
            }

            try {
                System.out.println("Cadeira de espera liberada.");
                cadeiraBarbearia.release();
                cadeirasOcupadas--;
                cortar();
                setChanged();
                notifyObservers();
                Thread.sleep(500);
            } finally {
                cadeiraBarbeiroOcupada = false;
                System.out.println("Cadeira do barbeiro liberada");
            }
        }
    }

    private synchronized void cortar() {

        try {
            System.out.println("Cortando cabelo");
            cadeiraBarbeiroOcupada = true;
            Thread.sleep(500);
            setChanged();
            notifyObservers();
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println("Não foi possível fazer a thread dormir.");
        }

    }

    /**
     * @return the cadeirasOcupadas
     */
    public int getCadeirasOcupadas() {
        return cadeirasOcupadas;
    }

    /**
     * @return the cadeiraBarbeiroOcupada
     */
    public boolean isCadeiraBarbeiroOcupada() {
        return cadeiraBarbeiroOcupada;
    }

    /**
     * @param executa the executa to set
     */
    public void setExecuta(boolean executa) {
        this.executa.set(executa);
    }

}
