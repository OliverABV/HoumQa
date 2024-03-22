#utf8
@Houm
Feature: Pagina de inicio de sesion http://localhost:5173/
  Background:
      Given valido title de la pagina
      
  @Houm1
  Scenario: crear visitas con validacion de campo
    When presiono crear visita y crear
    And se muesta mensaje de validacion "String must contain at least 1 character(s)"
    And completo formulario creacion de visita con
      |Address          |Visitor name  |Houmer name	|
      |Constantinopla   |Oliver Houm   |New member  |
    And ingreso fecha actual "22-03-2024T10:00"
    Then presiono boton crear
    And valido cracion de la visita "Constantinopla2"
    
# si no se la pasa por este medio el visitante este tomara el primero
	
  @Houm2
  Scenario: editar visitas con validación de campo.
    When edito el visitante con nombre de ""
    And limpio campos y valido
    And modifico address por "Oliver"
    Then valido modificacion "Oliver"
    
  @Houm3
  Scenario: cambiar el estado de la visita
    When edito el visitante con nombre de ""
    Then modifico estado por "DelaYed"
    
  @Houm4
  Scenario: cambiar el estado de la visita
    When edito el visitante con nombre de ""
    And modifico estado por "Completed"
    Then ingreso comentario "Cumple con los requisitos"
    
  @Houm5
  Scenario: cambiar el estado de la visita
    When edito el visitante con nombre de ""
    And modifico estado por "Completed"
    Then ingreso comentario "No Cumple requisitos"
    
    
    
    