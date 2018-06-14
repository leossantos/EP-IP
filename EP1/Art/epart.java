/*********************************************************************/
/**   <nome do(a) aluno(a)>                   <número USP>          **/
/**                                                                 **/
/**   <data de entrega>                                             **/
/*********************************************************************/
class NewtonRaphson {
	/*
		Depósitos realizados, com saldo final
	*/
	static double[] depositos = new double[11];
	
	/*
		Datas correspondentes aos depósitos feitos e saldo final
	*/
	static int[] datas = new int[11];
	
	/*
		Você pode incluir métodos que ache necessários aqui. Contudo, apenas newton
		será executado diretamente. Então, para que seus métodos rodem, deve haver um
		caminho em que sejam rodados a partir de newton (ex: newton chama um método que
		chama outro. Nesse caso, os 2 acabarão sendo rodados via newton)
	*/
	

	/*
		Método para cálculo dos juros de aplicação, segundo Newton-Raphson
	*/
	static double newton(double epsilon) {
		if (epsilon<=0||epsilon>=1) return -1;//O valor de -1 é retornado caso epsilon não esteja no intervalo de 0 a 1
		double j=0.5;
		double jk=j;
		double funcao;
		double derivada;
		double diferenca=j;
		/*	j= Taxa de juros
			jk= proxima taxa de juros
			funcao= função em função da taxa de juros
			derivada= derivada da função acima
			diferença= Guarda diferença entre juros e jurok e é inicializada com um valor arbitrário
		*/
		if (epsilon<=0||epsilon>=1) return -1;//Retorna -1, pois o epsilon precisa estar entre 0 e 1
		while(diferenca>=epsilon){	//Testa se a difernça é maior que epsilon

			funcao=0;
			derivada=0;		
			j=jk;//atualiza valor de j

			for (int i=0;i<depositos.length-1 ;i++ ) {//calculo dos depositos e sua derivada
				funcao+=depositos[i]*Math.pow(1+j,datas[datas.length-1]-datas[i]);//Soma dos depositos
				derivada+=((datas[datas.length-1]-datas[i])*depositos[i])*(Math.pow(1+j,datas[datas.length-1]-datas[i]-1));//Soma das derivadas de cada de deposito
			}

			funcao-=depositos[depositos.length-1];//funcao(j)=Soma dos depositos -Saldo Final
			jk=j-(funcao/derivada);//definir próximo valor de j
			
			if(jk-j>0) diferenca=jk-j;//Caso a diferença entre jk e j seja positiva a armazena na variavel diferença
			else diferenca=(jk-j)*-1;//Caso seja negativa é multiplicado por -1 para q a diferença fique em módulo
		}
		
		return j;//retorna o valor de juros
	}
	
	
	
	
	/*
		Use isso apenas para seus testes. Ele pode até ser removido para entrega. Use-o para abastecer valores nos arranjos e então testar o método newton.
		
		O MAIN SERa COMPLETAMENTE IGNORADO.
	*/
	public static void main(String[] args) {
		// será ignorado
	}
}
