/*******************************************************************/
/** ACH2001 - Introducao a Programacao                            **/
/** EACH-USP - Primeiro Semestre de 2015                          **/
/**                                                               **/
/** Segundo Exercicio-Programa                                    **/
/**                                                               **/
/** Juliana Witzke de Brito  10258959              				  **/
/**                                                               **/
/*******************************************************************/

class Integral {
	/**
		Retorna a área sob a curva definida pela função f, entre os pontos
		a e b, pela regra dos trapézios, aproximando a curva por n trapézios.
		
		O método retorna -1 caso n não seja maior ou igual a 1.
	*/
	static double resolve(Funcao f, double a, double b, int n) {
		if (n <= 0)
			return -1;
		// a funcao e objeto
		// retornar -1 caso n<=0
		// x1 = x0 + h
		// xi = x0 + i × h.
		// h = xi − xi−1
		// h (largura) = (b-a)/n
		

		// valor de h (largura dos trapezios)
		double h = (b-a)/(double)n;
		// encontrando o valor da funcao no menor ponto (a) do intervalo e maior ponto do intervalo (b)
		double fa = f.valor(a);
		double fb = f.valor(b);
		/* na formula sera necessario encontrar o valor de f em cada posicao de intervalo entre [a,b]
		por isso sera criada a variavel xi que corresponde a essa posicao que varia de acordo com i
		e que sera implementada dentro do lado, para assim corresponder a todos os valores possiveis */
		double xi = 0;
		
		/* a formula dos trapezios depende de f(a), f(b), da constante 2 e da soma dos valores de f(xi)
		entao para isso foi separado a parte "fixa" e a soma de todos os "xi", que ocorrerá no laco for */
		double soma = 0;

		// laco para calcular os valores de f(xi) de acordo com a formula (i comeca em 0 e vai ate n-1)
			for (int i=1; i<= n-1; i++){
				xi = a + h*i;
				// como xi = a + i*h, o laco fara com que todos os valores entre a e b sejam calculados
				soma += f.valor(xi);
			}

		// a area corresponde a formula a seguir
		double s = h/2 * (fa+ fb+ 2*soma);
		// retorna a area
		return s;

	}
}
