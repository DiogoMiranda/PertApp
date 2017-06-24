Dado(/^que eu estou na tela PertApp$/) do
  element_exists("* text:'PertApp'") 	
end
Dado(/^eu clicar no botao Estimativa de Pert$/) do
 touch ("* id:'main_button_display'")
end
Dado(/^que estou na tela Calculo de Pert$/) do
 element_exists("* text:'Calculo de Pert'")
end
Quando(/^eu preencher a estimativa otmista com "([^"]*)"$/) do |valor_otmista|
enter_text "* id:'edtvalor1'", "${valor_otmista}"
end
Quando(/^eu preencher a estimativa mais provavel com "([^"]*)"$/) do |valor_mais_provavel|
enter_text "* id:'edtvalor2'", "${valor_mais_provavel}"
end
Quando(/^eu preecher a estimativa pessimista com "([^"]*)"$/) do |valor_pessimista|
enter_text "* id:'edtvalor3'", "${valor_pessimista} " 
end
Quando(/^eu clicar no botao Gerar Pert$/) do 
end
Entao(/^a mensagem "([^"]*)" sera exibida$/) do |mensagem|
end



