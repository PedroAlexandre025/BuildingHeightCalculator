package classes;

public class InputsValidation {

    private double windowHeight;
    private double timeInWindow;
    private double fallAndBackTime;

    public InputsValidation(double fallAndBackTime, double timeInWindow, double windowHeight) {
        this.fallAndBackTime = fallAndBackTime;
        this.timeInWindow = timeInWindow;
        this.windowHeight = windowHeight;
    }

    public int validation() {

        if (windowHeight <= 0) {
            return 1;
        }


        //o tempo na janela não pode ser maior ou igual a raiz quadrada de 2*altura da janela/gravidade,
        //pois na equação de dy = v0*t + (1/2)*at², quando isolamos o v0, t passa dividindo, logo ele necessariamente é >0
        //então para equação ser valida (positiva) só depende do numerador. logo:
        //dy - 1/2gt² > 0
        //dy > 1/2gt²
        //2dy>gt²
        //2dy/g>t²
        //t < sqrt(2dy/g)
        if (timeInWindow <= 0 || timeInWindow >= Math.sqrt((2 * windowHeight) / 9.8)) {
            return 2;
        }

        if (fallAndBackTime <= 0 || fallAndBackTime <= 2 * timeInWindow) {
            return 3;
        }

        return 0;
    }
}
