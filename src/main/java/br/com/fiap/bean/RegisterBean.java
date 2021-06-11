package br.com.fiap.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.RegisterDAO;
import br.com.fiap.model.Register;

@Named
@RequestScoped
public class RegisterBean {
	
	private Register register = new Register();
	
	public void save() {
		new RegisterDAO().save(this.register);
		System.out.println("saving..." + this.register);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registered successfully"));
	}
	
	public List<Register> getRegisters(){
		return new RegisterDAO().getAll();
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}
	
	
	
}
