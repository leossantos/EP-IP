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
		if (n<1) return -1;//CAso o valor de n seja menor que 1, pois é necessário pelo menos uma iteração
		double resul, soma=0, h= (b-a)/n; 
		/*resul: Variavel que guarda o valor aproximado
		soma: variavel que guarda valor do somatório de f(xi)
		h: variavel que coontém o valor h
		*/

		for (int i=1; i<n;i++){//Calcula o somatatório de f(xi)
			soma += f.valor(a+i*h);
		}
		
		resul = (h/2)*(f.valor(a)+f.valor(b)+2*soma);//aproximação que será retornada
		return resul;
	}
}
