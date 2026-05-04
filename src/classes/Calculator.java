package classes ;

public class Calculator {
	private double windowHeight;
	private double timeInWindow;
	private double fallAndBackTime;
	private double fallTime;
	private double speedAtTopWindow;
	private double timeRoofToWindowPeak;
	private double totalTime;

//construtor de calculadora
	public Calculator(double windowHeight, double timeInWindow, double fallAndBackTime) {
		if (windowHeight <= 0 || timeInWindow <= 0 || fallAndBackTime <= 0) {
			throw new IllegalArgumentException(" Valores não pode ser menores ou igual a zero");
		}

		this.windowHeight = windowHeight;
		this.timeInWindow = timeInWindow;
		this.fallAndBackTime = fallAndBackTime;
	}

	// getters
	public double getFallAndBackTime() {
		return fallAndBackTime;
	}

	public double getTimeInWindow() {
		return timeInWindow;
	}

	public double getWindowHeight() {
		return windowHeight;
	}

	public double getTotalTime() {
		return totalTime;
	}

	public double getFallTime() {
		return fallTime;
	}

	public double getTimeRoofToWindowPeak() {
		return timeRoofToWindowPeak;
	}

	public double getSpeedAtTopWindow() {
		return speedAtTopWindow;
	}

	// metodo para calcular
	public double Calculate() {
		double gravity = 9.8;

		// tempo de queda
		fallTime = getFallAndBackTime() / 2;

		// calculo de velocidade da bola enquanto percorre a janela
		// y - y0 = v0*t + (1/2)*at² : windowHeight = speedAtTopWindow * timeInWindow + (1/2) * gravity* timeInWindow²
		// speedAtTopWindow = (windowHeight - (1/2) * gravity* timeInWindow²)/timeInWindow
		speedAtTopWindow = (windowHeight - 0.5 * gravity * (timeInWindow * timeInWindow)) / timeInWindow;

		// calculo do tempo do telhado ao topo da janela
		// v = v0+a*t : speedAtTopWindow = 0 + gravity * timeRoofToWindowPeak;
		// TimeRoofToWindowPeak = speedAtTopWindow/gravity + 0
		timeRoofToWindowPeak = speedAtTopWindow / gravity;

		// tempo total de queda do topo até o chão
		totalTime = timeInWindow + fallTime + timeRoofToWindowPeak;

		// Calculo altura do prédio, que é igual posição final da bola, quando cai no
		// chão
		// y - y0 = v0*t + (1/2)*at² : TotalHeight = 0 + (1/2) * gravity * totalTime²
		double totalHeight = 0.5 * gravity * (totalTime * totalTime);

		return totalHeight;
	}

}
