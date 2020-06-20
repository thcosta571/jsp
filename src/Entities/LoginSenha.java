package Entities;

public class LoginSenha {
	private String usuarioPadrao;
	private String senhaPadrao;

	public LoginSenha(String usuarioPadrao, String senhaPadrao) {
		
		this.usuarioPadrao = usuarioPadrao;
		this.senhaPadrao = senhaPadrao;
	}

	public String getUsuario() {
		return usuarioPadrao;
	}

	public String getSenha() {
		return senhaPadrao;
	}

	public boolean validarSenha(String usuario, String senha) {
		if (usuarioPadrao.equals(usuario)==true && senhaPadrao.equals(senha)==true) {
			
			return true;
		} else {
			
			return false;}

	}

}
