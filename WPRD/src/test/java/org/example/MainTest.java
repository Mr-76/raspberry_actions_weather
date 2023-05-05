package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

public class MainTest {
	ControllerWPRD controlador = new ControllerWPRD();

	@BeforeEach

	public void setup() {
		System.out.printf("TESTANDO");
	}

	@Test
	public void testaCriar() {
		String codigo = "BBAS3";
		controlador.createAcao(codigo);
		Assertions.assertEquals(true, controlador.acaoExiste(codigo));
	}

	@Test
	public void testaDeletar() {
		String codigo = "BBAS3";
		controlador.RemoveAcao(codigo);
	}

	@Test
	public void testaUpdate() {
		String codigo = "BBAS3";
		controlador.RemoveAcao(codigo);
	}
}
