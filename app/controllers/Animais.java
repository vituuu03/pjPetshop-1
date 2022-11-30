package controllers;
import play.*;
import play.mvc.*;
import models.TipoAnimal;
import java.util.*;
import models.Animal;
import models.TipoAnimal;


import models.*;
public class Animais extends Controller{
    public static void form(){
        List <TipoAnimal> tpAnimais = TipoAnimal.findAll();
        render(tpAnimais);
    }

    public static void salvar(Animal a) {
			a.save();
            listar();
	}
    
    public static void remover(Long id) {
		Animal aniRemover = Animal.findById(id);
		aniRemover.status = Status.INATIVO;
		aniRemover.save();
		listar();
	}
    public static void listar (){
        String termo = params.get("termo");
		
		List<Animal> animaisList = Collections.EMPTY_LIST;
		if (termo == null || termo.isEmpty()) {
			animaisList = Animal.find("status = ?1", Status.ATIVO).fetch();
		} else {
			
			animaisList = Animal.find("(lower(nome) like ?1 )",
					"%" + termo.toLowerCase() + "%"
					).fetch();
		}
		render(animaisList, termo);
  
  
  
    }
    public static void detalhar(Long id) {
		Animal a = Animal.findById(id);
		render(a);
	}

    public static void editar(Long id) {
		List<TipoAnimal>  tpAnimais = TipoAnimal.findAll();
		Animal animalEdit = Animal.findById(id);
		renderTemplate("Animais/form.html", animalEdit, tpAnimais);
	}

}
