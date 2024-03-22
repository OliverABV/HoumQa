package houm.testing.Page;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import houm.testing.Steps.HomeSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage {

	HomeSteps homeSteps = new HomeSteps();

	@Given("valido title de la pagina")
	public void valido_title_de_la_pagina() {
		homeSteps.IsVisibleTitle();
	}

	@When("presiono crear visita y crear")
	public void presiono_crear_visita_y_crear() {
		homeSteps.clickBtnCreateVisit();
		homeSteps.clickBtnCreate();
	}

	@Given("se muesta mensaje de validacion {string}")
	public void se_muesta_mensaje_de_validacion(String name) {
		assertTrue("El mensaje de campo necesario no es existe", homeSteps.IsVisibleSatisfactoryPurchase(name));

	}

	@And("completo formulario creacion de visita con")
	public void completo_formulario_creacion_de_visita_con(DataTable dataTable) {
		homeSteps.completeForm(dataTable);

	}

	@And("ingreso fecha actual {string}")
	public void ingreso_fecha_actual(String date) {
		homeSteps.sendKeysDate(date);
	}

	@Then("presiono boton crear")
	public void presiono_boton_crear() {
		homeSteps.clickBtnCreate();

	}

	@Then("valido cracion de la visita {string}")
	public void valido_cracion_de_la_visita(String name) {
		assertTrue("El nuevo addres actualizado no existe ", homeSteps.IsVisibleNewAddress(name));
	}

	///

	@When("edito el visitante con nombre de {string}")
	public void edito_el_visitante_con_nombre_de(String string) {
		if (string.isEmpty()) {
			homeSteps.fistClickEdit();

		} else {
			homeSteps.clickEdit(string);
		}
	}

	@When("limpio campos y valido")
	public void limpio_campos_y_valido() {
		homeSteps.cleanCampAndValidateEditVisit();

	}

	@When("modifico address por {string}")
	public void modifico_address_por(String address) {
		homeSteps.sendKeysAddress(address);

	}

	@When("valido modificacion {string}")
	public void valido_modificacion(String name) {
		assertTrue("El nuevo addres actualizado no existe ", homeSteps.IsVisibleNewAddress(name));

	}

	@When("modifico estado por {string}")
	public void modifico_estado_por(String state) {
		String modifiedState = homeSteps.capitalizeFirstLetter(state);
		if (state.equalsIgnoreCase("Completed") || state.equalsIgnoreCase("Canceled")) {
			homeSteps.modificateStateAndComment(modifiedState);

		} else {
			homeSteps.modificateState(modifiedState);

		}

	}

	@Then("ingreso comentario {string}")
	public void ingreso_comentario(String comment) {
		homeSteps.sendKeysComment(comment);

	}

}
