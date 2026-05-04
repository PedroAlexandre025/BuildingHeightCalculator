package classes;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Interface extends JFrame implements ActionListener {


	private int validation;
	private double height, fallT, windowT, heightBuilding;
	private JTextField heightField, windowTime, fallBack;
	private JLabel result;
	private JButton calc, reset, simulateButton;
	private Simulation sim;
	private Calculator calculator;


	public Interface() {

		setSize(400, 720);// tam janela
		setTitle("Calculadora");//titulo
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //encerra o programa quando fecha janela
		setLocationRelativeTo(null); //abrir janela no meio da tela
		setLayout(null);

		JLabel WindowHeight = new JLabel("Altura da Janela (m): "); //texto para pedir altura
		WindowHeight.setBounds(65, 30, 130, 30);
		heightField = new JTextField(); 	//caixa de input de altura da janela
		heightField.setBounds(225, 30, 100, 30);

		JLabel timeInWindow = new JLabel("Tempo na janela (s): ");//texto para pedir tempo de queda na janela
		timeInWindow.setBounds(65, 65, 130, 30);
		windowTime = new JTextField(); 							//input
		windowTime.setBounds(225, 65, 100, 30);

		JLabel fallBackTime = new JLabel("Queda e volta(s): ");//texto para pedir tempo de queda e volta da bola
		fallBackTime.setBounds(65, 100, 130, 30);
		fallBack = new JTextField();							//input
		fallBack.setBounds(225, 100, 100, 30);

		reset = new JButton("Resetar"); //botao reset
		calc = new JButton("Calcular"); //botao calcular
		simulateButton = new JButton("Ver Simulação");


		calc.setBounds(65, 140, 130, 30);
		reset.setBounds(225, 140, 100, 30);
		simulateButton.setBounds(140, 250, 120, 30);

		calc.setForeground(new Color(0, 0, 0));
		reset.setForeground(new Color(165, 12, 12));



		JPanel output = new JPanel(); //painel de output
		output.setBounds(65, 180, 260, 60);
		output.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), "Altura do prédio",
				TitledBorder.LEFT, TitledBorder.TOP)); //setar cores e borda do output
		output.setLayout(new GridBagLayout());
		result = new JLabel(); //texto resultado
		result.setText("0,00m");
		result.setBounds(150, 200, 50, 40);
		result.setForeground(new Color(10, 90, 170));
		result.setFont(new Font("Arial", Font.BOLD, 20));

		calc.addActionListener(this); //adicionar metodo de funcionalidade dos botões
		reset.addActionListener(this);
		simulateButton.addActionListener(this);



		//adicionar cada coisa a interface
		add(WindowHeight);
		add(heightField);

		add(timeInWindow);
		add(windowTime);

		add(fallBackTime);
		add(fallBack);
		output.add(result);
		add(output);

		add(reset);
		add(calc);

		//botão de simulação invisivel antes de realizar o calculo
		simulateButton.setVisible(false);

		add(simulateButton);

		//deixar interface visivel
		setVisible(true);

	}
	//metodo de funcionalidade de botões
	@Override
	public void actionPerformed(ActionEvent e) {

		//funcionalidade botão calcular
		if(e.getSource()==calc) {
			try{
				String h = heightField.getText();
				String t1 = windowTime.getText();
				String t2 = fallBack.getText();		//conversão das caixas de string para double
				height = Double.parseDouble(h);
				windowT = Double.parseDouble(t1);
				fallT = Double.parseDouble(t2);

				validation = new InputsValidation().validation(height, windowT, fallT); //metódo de classe para validação de dados

				if(validation == 1) {
					printErrorMessage("Erro 1","Altura inválida da janela! Deve ser maior que zero e menor que 17,2" ); //valor 1 retorna erro no primeiro input

				}
				else if(validation == 2) {
					String err2_0 = String.format("%.2f", height/ InputsValidation.getMaxSpeed());
					String err2_1 = String.format("%.2f", Math.sqrt((2 * height) / 9.8));
					printErrorMessage("Erro 2","Tempo na janela Inválido! Deve ser maior que "+err2_0+ " e menor que "+err2_1 ); //valor 2 retorna erro no segundo input

				}else if (validation ==3) {
					String err3 = String.format("%.2f", 2*windowT);
					printErrorMessage("Erro 3","Tempo de queda e volta inválido! Deve ser maior que "+err3 ); //valor 3 retorna erro no terceiro input

				}
				else {
					calculator = new Calculator(height, windowT, fallT);
					heightBuilding = calculator.Calculate(); //se passar na verificação calcula
					String res = String.format("%.2f", heightBuilding);
					result.setText(res+"m");
					simulateButton.setVisible(true);

				}

			}catch(NumberFormatException ex) {
			printErrorMessage("Erro de Entrada", "Insira dados válidos"); //verificação para inputs diferentes de números
			}

		}
		else if(e.getSource() == reset) {//função botão reset, limpar as caixas e zerar o resultado e remover simulação da tela
			heightField.setText("");
			fallBack.setText("");     	//valores nulos nos inputs
			windowTime.setText("");
			result.setText("0,00m");//0 no output
			simulateButton.setVisible(false);//simulação invisivel
			sim.timer.stop();//parar o timer dela
			remove(sim);//remover da tela

			repaint();	//pintar novamente
			revalidate();

		}
		else if(e.getSource() == simulateButton ){ //botão para gerar quadro de simulação

				if(sim != null){
					sim.timer.stop(); //verificação para permitir reiniciar simulação
					remove(sim);
				}
				sim = new Simulation();
				sim.setBounds(0, 300, 400, 400);
				sim.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), "",
						TitledBorder.LEFT, TitledBorder.TOP));
				sim.setLayout(new GridBagLayout());
				add(sim);
				sim.setVisible(true);

				repaint();
				revalidate();

			//}

		}

	}

	//metodo para printar erro
	public void printErrorMessage(String title, String error) {
		JOptionPane.showMessageDialog(null,  error, title, JOptionPane.INFORMATION_MESSAGE);
	}




	//classe de simulação
	//tamanho setado do painel 400x400px
	public class Simulation extends JPanel{
		private static final double SCALE = 1.2;//escala base em pixels para definir a altura do prédio dinamicamente de acordo com resultado.
		private static final double windowScale = 3.0; // escala para a janela não ficar muito pequena
		private int pixelsBuildingHeight, pixelsWindowTop, buildingPosition;
		private Timer timer;	//timer para simulação
		private double ballY, windowBasePixels;
		private int goingUp = 0;	//ints para gerenciamento de maquina de estados //0 cai, 1 recocheteia e sobe até o peitoril, 2 sobe até metade do peitoril
		private int valid =0;

		public Simulation(){
			setBackground(new Color(45, 205, 218));
			pixelsBuildingHeight = (int)(heightBuilding * SCALE);//calculo da altura em pixels

			double positionTopWindow = 0.5*9.8*(calculator.getTimeRoofToWindowPeak()*calculator.getTimeRoofToWindowPeak()); //calculo da posição do topo da janela usando y - y0 = v0*t + (1/2)*at²


			if(pixelsBuildingHeight < 120) {
				pixelsBuildingHeight = 120;
			}
			else if(pixelsBuildingHeight < 210) {	//verificações para o tamanho do prédio em px para nao estourar o tamanho do painel e nem ficar muito pequeno
				pixelsBuildingHeight = 210;			// definindo base (120), ponto médio (210) e ponto maximo (350)
			}
			else if(pixelsBuildingHeight > 350) {
				pixelsBuildingHeight = 350;
			}

			buildingPosition = 380-pixelsBuildingHeight;//calculo da posição onde o prédio começa a ser desenhado
			ballY = buildingPosition;//definir altura onde a bola começa a cair
			pixelsWindowTop = (int)(positionTopWindow*SCALE)+buildingPosition; //ṕosição do topo da janela em pixels
			 windowBasePixels= pixelsWindowTop+(calculator.getWindowHeight()*windowScale); //posição da base da janela em pixels



			double frameSpeed =  pixelsBuildingHeight/(calculator.getTotalTime()*60); //calculo da velocidade por frame  altura em pixels/tempo total*frames por segundo


			timer = new Timer(16, e ->{//maquina de estados para simulação

				if (goingUp ==0){
					ballY += frameSpeed; //bolinha começa a cair
					if (ballY >= 375){ //condicional para se chegar no chão

						if (valid ==2){
							goingUp = 2;//se valid = 2 vai para o 3 estado
						}
						else if(valid==3){
							timer.stop();//se valid =3 acaba a simulação

						}else {
							goingUp = 1;
							valid++;	//senao, vai para o segundo e estado e incrementa valid (1)
						}
					}
					repaint();
				}
				else if(goingUp == 1){
					ballY-= frameSpeed;//bola começa a subir

					if (ballY<=windowBasePixels){//quando chegar ao peitoril da janela incrementa valid (2)e volta para o primeiro estado
						valid++;
						goingUp = 0;
					}
					repaint();
				}else {//bola subindo novamente, mas apenas metade do caminho
					ballY-=frameSpeed;
					if (ballY<=windowBasePixels+(380-windowBasePixels)/2){//condicional para ir até metade do caminho do peitoril da janela
						goingUp = 0;//volta ao primeiro estado
						valid++; //valid (3)
					}
					repaint();//redesenhar a cada frame
				}
			});
			timer.start();//começar o timer

		}

		@Override
		public void paintComponent(Graphics g) {

			super.paintComponent(g);
			//

			//predio
			g.setColor(Color.GRAY);
			g.fillRect(160, buildingPosition, 80, pixelsBuildingHeight);
			//BORDA
			g.setColor(Color.BLACK);
			g.drawRect(160, buildingPosition, 80, pixelsBuildingHeight);
			//janela principal

			g.setColor(Color.YELLOW);
			g.fillRect(190, pixelsWindowTop, 20, ((int)windowBasePixels-pixelsWindowTop) );

			//chão
			g.setColor(Color.GREEN);
			g.fillRect(1 ,380, 400, 20);
			//porta
			g.setColor(new Color(81, 80, 80, 255));
			g.fillRect(190, 350, 20,30);

			//bola
			g.setColor(Color.red);
			g.fillOval(197, (int)ballY, 7,	7);

			//janelinhas
			g.setColor(Color.YELLOW);

			for(int y = buildingPosition + 10; y < 340; y += 25){

				g.fillRect(165, y, 10, 10);
				g.fillRect(225, y, 10, 10);

			}
			//arvore
			g.setColor(new Color(64, 19, 19));
			g.fillRect(90, 350, 10, 30);
			g.fillRect(300, 350, 10, 30);
			g.setColor(new Color(27, 67, 19));
			g.fillOval(80, 330, 30,25);
			g.fillOval(290, 330, 30,25);


		}
	}

}