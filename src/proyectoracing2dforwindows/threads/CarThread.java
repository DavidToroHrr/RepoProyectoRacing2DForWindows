package proyectoracing2dforwindows.threads;

import proyectoracing2dforwindows.models.Car;

public class CarThread implements Runnable {
    private Car car;
    private volatile boolean running; // Bandera volátil para controlar la ejecución del hilo
    private static final int DELAY = 20; // Tiempo en milisegundos entre cada actualización

    public CarThread(Car car) {
        this.car = car;
        this.running = true;
    }

    @Override
    public void run() {
        while (running) {
            car.move(); // Actualiza la posición del carro
            try {
                Thread.sleep(DELAY); // Espera un breve periodo de tiempo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        running = false; // Establece la bandera running en false para detener el bucle
    }
}
