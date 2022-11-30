package Jobs;
import models.TipoAnimal;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {

	@Override
	public void doJob() throws Exception {
		 if (TipoAnimal.count() == 0) {
			 TipoAnimal ta1 = new TipoAnimal();
			 ta1.descricao = "Cachorro";
			 ta1.save();
			 
			 TipoAnimal ta2 = new TipoAnimal();
			 ta2.descricao = "Gato";
			 ta2.save();
			 
			 TipoAnimal ta3 = new TipoAnimal();
			 ta3.descricao = "Hamster";
			 ta3.save();
			 
			 TipoAnimal ta4 = new TipoAnimal();
			 ta4.descricao = "Periquito";
			 ta4.save();
			 
			 TipoAnimal ta5 = new TipoAnimal();
			 ta5.descricao = "Cobra";
			 ta5.save();

			 TipoAnimal ta6 = new TipoAnimal();
			 ta6.descricao = "GADO MANSO";
			 ta6.save();
		 }
	}
}
