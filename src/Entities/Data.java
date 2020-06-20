package Entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	Calendar calNasc = Calendar.getInstance();
	Calendar calSist = Calendar.getInstance();

	private Date dataNasc;
	private Date dataSist;
	private int idade;
	private int dia;
	private byte mes;
	private short ano;
	private String dataTemp;
	private int data;

	public Data(String dataTemp, short ano, byte mes, byte dia) throws ParseException {

		this.dataTemp = dataTemp;
		if (ano > calSist.getWeekYear()) {
			data = -1;
		}
		if (validaAno(ano) && validaMes(mes) && validaDia(dia) == true) {
			if (fevereiro28(ano, mes, dia) == true || fevereiro29(ano, mes, dia) == true || dia30(mes, dia) == true
					|| dia31(mes, dia) == true) {

				this.dia = dia;
				this.mes = mes;
				this.ano = ano;
				this.dataSist = new Date();
				this.dataNasc = sdf.parse(dataTemp);
				CalcularIdade();
			} else
				data = -1;

		} else
			data = -1;
	}

	public int getData() {
		return data;
	}

	public short getAno() {
		return ano;
	}

	public byte getMes() {
		return mes;
	}

	public int getDia() {
		return dia;
	}

	public void setAno(short ano) {
		this.ano = ano;
	}

	public void setMes(byte mes) {
		this.mes = mes;
	}

	public void setDia(byte dia) {

		this.dia = dia;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(byte idade) {
		this.idade = idade;
	}

	// Validar se ano está no intervalo correto.
	public boolean validaAno(short ano) {
		if (ano > 0 && ano <= 9999) {
			return true;
		}
		return false;
	}

	// Validar se o ano atende aos parametros para ser BISSEXTO.
	public boolean checaAnoBissexto(short ano) {

		if (ano % 4 == 0 && ano % 100 != 0 || ano % 4 == 0 && ano % 400 == 0) {

			return true;

		} else
			return false;
	}

	// Validar se MES está no intervalo correto.
	public boolean validaMes(byte mes) {

		if (mes > 0 && mes <= 12) {

			return true;
		}
		return false;
	}

	// Validar se DIA está no intervalo correto.
	public boolean validaDia(byte dia) {
		if (dia > 0 && dia <= 31) {

			return true;
		}
		return false;
	}

	// FEVEREIRO
	public boolean fevereiro28(short ano, byte mes, byte dia) {
		if ((mes == 2) && (checaAnoBissexto(ano) == false) && (dia <= 28)) {
			return true;

		}

		return false;

	}

	public boolean fevereiro29(short ano, byte mes, byte dia) {
		if (mes == 2 && checaAnoBissexto(ano) == true && dia <= 29) {
			return true;
		}
		return false;
	}

	public boolean dia30(byte mes, byte dia) {
		if (dia <= 30 && mes == 4 || dia <= 30 && mes == 6 || dia <= 30 && mes == 9 || dia <= 30 && mes == 11) {
			return true;

		}
		return false;

	}

	public boolean dia31(byte mes, byte dia) {
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12 && dia <= 31) {
			return true;
		}
		return false;

	}

	public void CalcularIdade() {

		calSist.setTime(dataSist);
		calNasc.setTime(dataNasc);
		idade = (calSist.getWeekYear() - calNasc.getWeekYear());
		int anoN = calNasc.getWeekYear();
		int anoS = calSist.getWeekYear();

		int mesSist = dataSist.getMonth() + 1;

		int diaS = (dataSist.getDate());

		// Aqui é calculado a idade em "meses"
		if (anoN == anoS) {
			idade = mesSist - mes;
		}

		if (mes > mesSist) {
			idade -= 1;

		} else {
			if (mes == mesSist) {
				if (dia > diaS) {
					idade -= 1;

				}

			}
		}

	}
}
