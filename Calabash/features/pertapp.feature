#language: pt
#encoding UTF-8
 
Funcionalidade: Calculo de Pert
 Cenário: Calculando a estimativa de uma atividade
   Dado que eu estou na tela PertApp
   E eu clicar no botao Estimativa de Pert
   Dado que estou na tela Calculo de Pert
   Quando eu preencher a estimativa otmista com "6"
   E eu preencher a estimativa mais provavel com "9"
   E eu preecher a estimativa pessimista com "20"
   E eu clicar no botao Gerar Pert
 Entao a mensagem "Estimativa da Atividade: 10.0 dias/horas" sera exibida  