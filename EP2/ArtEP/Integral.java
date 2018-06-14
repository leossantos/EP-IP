/*******************************************************************/
/** ACH2001 - Introducao a Programacao                            **/
/** EACH-USP - Primeiro Semestre de 2017                          **/
/**                                                               **/
/** Segundo Exercicio-Programa                                    **/
/**                                                               **/
/** <Leonardo Soares Santos>  <10284782>                          **/
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
		if (n<1) return -1;//Caso o valor de n seja menor que 1, pois é necessário pelo menos uma iteração
		double aprox;//aprox: Variavel que guarda o valor aproximado
		double s = 0;//s: variavel que guarda valor do somatório de f(xi)
		double h = (b-a)/n;//variavel que coontém o valor h
		double fa = f.valor(a);//Guarda o valor de f(a)
		double fb = f.valor(b);//Guarda o valor de f(b)
	

		for (int i=1; i<n;i++){//Calcula o somatatório de f(xi)
			double xi = a+i*h; 
			s += f.valor(xi);
		}
		
		aprox = (h/2)*(fa+fb+2*s);//aproximação que será retornada
		return aprox;
	}
}
