package org.podxboq.mandelboq.ui.palettes;

import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.Collections;

public class Palette {

	private String nombre;
	private Integer[] colores;

	Palette(String nombre, Integer[] colores) {
		this.nombre = nombre;
		this.colores = colores;
	}

	@Override
	public String toString() {
		return nombre;
	}

	private int getPaletteColor(int result) {
		return colores[result % colores.length];
	}

	public Color getColor(int iteraciones) {
		int intColor = 0;
		if (iteraciones < 500) {
			intColor = getPaletteColor(iteraciones);
		}
		int red = (intColor >> 16) & 0xff;
		int green = (intColor >> 8) & 0xff;
		int blue = intColor & 0xff;
		return Color.rgb(red, green, blue);
	}

	public void push(){
		Collections.rotate(Arrays.asList(colores), 1);
	}

}
