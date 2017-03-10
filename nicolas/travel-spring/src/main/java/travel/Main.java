package travel;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
//creation d'un context  (on est plus en mode web mais en mode local)
	// ici on considère une région comme base de donnée de plein de truc don le dépot de lac (qui vien de lakerepositori) qui cntien les objet de la classe lac et la classe lac a la compilation
	public static void main(String[] args) {
		System.out.println("nos voyages scandinaves");  //creation d'un  context bean avec spring ( les ligne suivante
		AbstractApplicationContext ctx= new FileSystemXmlApplicationContext("classpath:spring.xml");
		ctx.registerShutdownHook();  //création d'un context
		for (String n:ctx.getBeanDefinitionNames()) System.out.println(n);
		if(ctx.containsBean("cruiseSource"))System.out.println("ok");
		CruiseSource cs=(CruiseSource)ctx.getBean("cruiseSource");   //récupère un bean le met dans une variable et on l'utilise 
		if(cs.getActive()) 	System.out.println("actifs");
		System.out.println(cs.getHelsinkiBergen());
		LakeSource ls=(LakeSource)ctx.getBean("lakesource");
		ls.fillInfos(); //appel le remplisseur ou ya les info sinon ya rien a afficher
		if(ls.getInfo() !=null)
		System.out.println(ls.getInfo());
		Lake powel= new Lake(1L,"powel","usa",23.2f);
		System.out.println(powel); //le print ln appel une chaine et come mon objet lake n'est pas une chaine mais un objet c'est tostring qui est appeler.
		System.out.println(powel.getId());
	
	}
}

