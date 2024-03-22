package houm.testing.Steps;

import static org.junit.Assert.assertTrue;

import houm.testing.Page.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {

	HomePage homePage = new HomePage();

	@Given("valido title de la pagina")
	public void valido_title_de_la_pagina() {
		homePage.IsVisibleTitle();
	}

	@When("presiono crear visita y crear")
	public void presiono_crear_visita_y_crear() {
		homePage.clickBtnCreateVisit();
		homePage.clickBtnCreate();
	}

	@Given("se muesta mensaje de validacion {string}")
	public void se_muesta_mensaje_de_validacion(String name) {
		assertTrue("El mensaje de campo necesario no es existe", homePage.IsVisibleSatisfactoryPurchase(name));

	}

	@And("completo formulario creacion de visita con")
	public void completo_formulario_creacion_de_visita_con(DataTable dataTable) {
		homePage.completeForm(dataTable);

	}

	@And("ingreso fecha actual {string}")
	public void ingreso_fecha_actual(String date) {
		homePage.sendKeysDate(date);
	}

	@Then("presiono boton crear")
	public void presiono_boton_crear() {
		homePage.clickBtnCreate();

	}

	@Then("valido cracion de la visita {string}")
	public void valido_cracion_de_la_visita(String name) {
		assertTrue("El nuevo addres actualizado no existe ", homePage.IsVisibleNewAddress(name));
	}

	///

	@When("edito el visitante con nombre de {string}")
	public void edito_el_visitante_con_nombre_de(String string) {
		if (string.isEmpty()) {
			homePage.fistClickEdit();

		} else {
			homePage.clickEdit(string);
		}
	}

	@When("limpio campos y valido")
	public void limpio_campos_y_valido() {
		homePage.cleanCampAndValidateEditVisit();

	}

	@When("modifico address por {string}")
	public void modifico_address_por(String address) {
		homePage.sendKeysAddress(address);

	}

	@When("valido modificacion {string}")
	public void valido_modificacion(String name) {
		assertTrue("El nuevo addres actualizado no existe ", homePage.IsVisibleNewAddress(name));

	}

	@When("modifico estado por {string}")
	public void modifico_estado_por(String state) {
		String modifiedState = homePage.capitalizeFirstLetter(state);
		if (state.equalsIgnoreCase("Completed") || state.equalsIgnoreCase("Canceled")) {
			homePage.modificateStateAndComment(modifiedState);

		} else {
			homePage.modificateState(modifiedState);

		}

	}

	@Then("ingreso comentario {string}")
	public void ingreso_comentario(String comment) {
		homePage.sendKeysComment(comment);

	}

}
