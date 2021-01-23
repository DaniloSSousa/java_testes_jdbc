package br.com.alura.jdbc.modelo;

public class TestaConta {
  public static void main(String[] args) throws ClassNotFoundException {
//	Conta c = new Conta(0001L, 222L, "Danilo");
	Conta c2 = new Conta(0001L, 223L, "Danilo Sousa");
	
	new ContaDao().adiciona(c2);
  }
}
