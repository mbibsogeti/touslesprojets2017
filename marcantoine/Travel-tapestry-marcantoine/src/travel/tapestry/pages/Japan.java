package travel.tapestry.pages;

import java.util.Locale;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;

@Import(module="japan")
public class Japan {

	@Inject
	private PersistentLocale pl;

	public void onChangeLocale(String l) {
		pl.set(new Locale(l));
	}

}
