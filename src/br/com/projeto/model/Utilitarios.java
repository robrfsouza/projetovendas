package br.com.projeto.model;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Utilitarios {

	public void LimparTela(JPanel container) {
		Component components[] = container.getComponents();
		for (Component component : components) {
			if (component instanceof JTextField) {
				((JTextField) component).setText(null);
			}
		}
	}

	public static String AtualizaDataHora() {
		Date agora = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
		return formato.format(agora);

	}

}
