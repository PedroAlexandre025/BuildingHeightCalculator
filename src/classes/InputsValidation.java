package classes;

public class InputsValidation {
	//teto de velocidade plausível para o modelo
	//usado para restrição, pois o usuario pode digitar uma altura de por exemplo 10 m para janela
	// e 0.01 s para tempo, dando uma velociade impossivel de 10/0.01 = 1000m/s, algo supersonico.
	private static final double MAX_SPEED = 75.0;

	public static double getMaxSpeed(){
		return MAX_SPEED;
	}

	public int validation(double windowHeight, double timeInWindow, double fallAndBackTime ) {

		//tamanho da janela não pode ser negativo e maior que 17.2(janela mais alta construida no mundo)
		if (windowHeight <= 0 ||windowHeight>17.2) {
			return 1;
		}

		// o tempo na janela não pode ser maior ou igual a raiz quadrada de 2*altura da
		// janela/gravidade,
		// pois na equação de dy = v0*t + (1/2)*at², quando isolamos o v0, t passa
		// dividindo, logo ele necessariamente é >0
		// então para equação ser valida (positiva) só depende do numerador. logo:
		// dy - 1/2gt² > 0
		// dy > 1/2gt²
		// 2dy>gt²
		// 2dy/g>t²
		// t < sqrt(2dy/g)
		//o tempo também não pode ser menor ou igual a windowHeight/MAX_SPEED
		if (timeInWindow<= windowHeight/MAX_SPEED|| timeInWindow >= Math.sqrt((2 * windowHeight) / 9.8)) {
			return 2;
		}

		if (fallAndBackTime <= 0 || fallAndBackTime <= 2 * timeInWindow) {
			return 3;
		}

		return 0;
	}
}
