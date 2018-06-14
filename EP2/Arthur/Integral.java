/*******************************************************************/
/** ACH2001 - Introducao a Programacao                            **/
/** EACH-USP - Primeiro Semestre de 2017                          **/
/**                                                               **/
/** Segundo Exercicio-Programa                                    **/
/**                                                               **/
/** <Arthur Croce Jeronymo>  <10259050>                          **/
/**                                                               **/
/*******************************************************************/

class Integral {
	/**
		Retorna a área sob a curva definida pela função f, entre os pontos
		a e b, pela regra dos trapézios, aproximando a curva por n trapézios.
		
		O método retorna -1 caso n não seja maior ou igual a 1.
	*/
	static double resolve(Funcao f, double a, double b, int n) {
		// coloque seu código aqui
		if (n<1) return -1;// Se o valor de n for menor que 1, porque é necessário que exista ao menos uma iteração.
		double aprox;// aprox: Variável que guarda o valor aproximado.
		double s = 0;// s: Variável que guarda valor do somatório de f(xi).
		double h = (b-a)/n;// h: Variável que contém o valor h. 
		double fa = f.valor(a);// fa: Guarda o valor de f(a)
		double fb = f.valor(b);// fb: Guarda o valor de f(b)
	

		for (int i=1; i<n;i++){// Realiza o cálculo do somatório de f(xi).
			double xi = a+i*h; 
			s += f.valor(xi);
		}
		
		aprox = (h/2)*(fa+fb+2*s);// aprox: Aproximação que vai ser retornada. 
		return aprox;
	}
}
