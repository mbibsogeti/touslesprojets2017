package travel.tapestry.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class Korea {
	
@Persist @Property private String text;

private String[]texts={" le pays a  visiter est"," les site dans ce pays sont tatata","votre voyage est prévu a partir de la ville de départ jusqua la ville darrivaye"};
public Object onAction(int i){
	text=texts[i];
return textZone.getBody();
	
}
@InjectComponent private Zone textZone;
}
