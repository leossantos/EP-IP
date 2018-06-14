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
		double juros, jurosk=0.5, funcao, derivada, diferenca;
		/*	juros= Taxa de Juros
			jurosk= proxima taxa de juros
			funcao= função em função da taxa de juros
			derivada= derivada da função acima
			diferença= Guarda diferença entre juros e jurok
		*/
		if (epsilon<=0||epsilon>=1) return -1;//Retorna -1, pois o epsilon precisa estar entre 0 e 1
		do{	
			funcao=0;//zera a função 
			derivada=0;//zera a derivada			
			juros=jurosk;//atualiza valor de juros 
			for (int i=0;i<depositos.length-1 ;i++ ) {//calculo dos depositos e sua derivada
				funcao+=depositos[i]*Math.pow(1+juros,datas[datas.length-1]-datas[i]);//Soma dos depositos
				derivada+=((datas[datas.length-1]-datas[i])*depositos[i])*(Math.pow(1+juros,datas[datas.length-1]-datas[i]-1));//Soma das derivadas de cada de deposito
			}
			funcao-=depositos[depositos.length-1];//funcao(juros)=Soma dos depositos -Saldo Final
			jurosk=juros-(funcao/derivada);//definir próximo valor de juros
			if(jurosk-juros>0) diferenca=jurosk-juros;//Caso a diferença entre jurosk e juros seja positiva a armazena na variavel diferença
			else diferenca=(jurosk-juros)*-1;//Caso seja negativa é multiplicado por -1 para q a diferença fique em módulo
		}while(diferenca>=epsilon);//Testa se a difernça é maior que epsilon
		
		return juros;//retorna o valor de juros
	}
	
	
	
	
	/*
		Use isso apenas para seus testes. Ele pode até ser removido para entrega. Use-o para abastecer valores nos arranjos e então testar o método newton.
		
		O MAIN SERa COMPLETAMENTE IGNORADO.
	*/
	public static void main(String[] args) {
		// será ignorado
	}
}
