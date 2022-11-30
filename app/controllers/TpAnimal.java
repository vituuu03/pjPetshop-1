package controllers;
import play.*;
import play.mvc.*;
import models.Animal;
import java.util.*;

import models.*;
public class TpAnimal extends Controller{
    public static void TipoAnimalForm(){
        render();
    }

    public static void salvar(TipoAnimal a) {
			a.save();
			TipoAnimalList();
	}

    public static void TipoAnimalList (){
        String termo = params.get("termo");
		
		List<TipoAnimal> tpsAnimal = Collections.EMPTY_LIST;
		if (termo == null || termo.isEmpty()) {
			tpsAnimal = TipoAnimal.findAll();
		} else {
			tpsAnimal = TipoAnimal.find("(lower(descricao) like ?1)",
					"%" + termo.toLowerCase() + "%").fetch();
		}
		render(tpsAnimal, termo);
  
  
  
    }
    
    public static void editar(Long id) {
		TipoAnimal tpsAnimal = TipoAnimal.findById(id);
		renderTemplate("TpAnimal/TipoAnimalForm.html", tpsAnimal);
	}

    public static void remover (long id){
        TipoAnimal tpAnimalDelete = TipoAnimal.findById(id);
        tpAnimalDelete.delete();
       TipoAnimalList();
        
    }
    
    public static void detalharTipo(Long id) {
		TipoAnimal a = TipoAnimal.findById(id);
		
        String termo = params.get("termo");
		
		List<Animal> animaisList = Collections.EMPTY_LIST;
		if (termo == null || termo.isEmpty()) {
			animaisList = Animal.find("status = ?1", Status.ATIVO).fetch();
		} else {
			
			animaisList = Animal.find("(lower(nome) like ?1 )",
					"%" + termo.toLowerCase() + "%"
					).fetch();
		}
		render(animaisList, termo, a);
        
                    

				
                
            
        
        
        
        
	}

}