#language: pt
#Author: Bruno
#Date: 20/05/2021
#verison: 2.0

Funcionalidade: Compras

Contexto: 
Dado que estou no site "http://automationpractice.com/index.php"
	
	
Esquema do Cenário: compras de produtos
Quando seleciono a <roupa>
E escolho o tamanho <tamanho>
E seleciono <quantidade> unidades
E clico em "adicionar ao carrinho"
Então verifico se <quantidade> de produto foi adicionado ao carrinho com sucesso


Exemplos:
|  roupa	    | tamanho | quantidade |
| vestido estampado |    L    |     2      |
| vestido	    |	 L    |	    3 	   |

Esquema do Cenario: verificar valor do frete

Quando seleciono a <roupa>
E escolho o tamanho <tamanho>
E seleciono <quantidade> unidades
E clico em "adicionar ao carrinho"
Então verifico se o valor do frete é "$2.00"

Exemplos:
|  roupa	    | tamanho | quantidade|
| vestido estampado |  L      |     2     |

@esse
Esquema do Cenario: Cadastro com sucesso
Quando clico em sign in
E preencho meu e-mail com <E-mail> na aba de criar conta
E clico em Create an account
E preenche o campo nome com <nome>
E preenche o campo sobre nome com <sobre nome>
E preenche o campo senha com <senha>
E preenche o campo data de aniversario com <dia> <mes> e <ano>
E preenche o campo Endereço com <endereço>
E preenche o campo Cidade com <cidade>
E preenche o campo Estado com <estado>
E preenche o campo Cep com <Cep>
E preenche o campo Telefone com <telefone>


Exemplos:
| nome      | sobre nome   | E-mail		 | senha    | dia | mes 	| ano	 | nome      | sobre nome   | endereço   | cidade   | estado     | Cep     | telefone         |
| "Bruno"   | "Silva"      | "filho@hotmail.com" | "12345"  | "2" | "September" | "1991" | "Bruno"   | "Silva"      | "rua 25th" | "Denver" | "colorado" | "80207" | "011 99999-2222" | 
| "Gabriel" | "Silva"      | "jo@gmail.com"      | "12345"  | "2" | "September" | "1991" | "Gabriel" | "Silva"      | "rua 25th" | "Denver" | "colorado" | "80207" | "011 99999-2222" | 

