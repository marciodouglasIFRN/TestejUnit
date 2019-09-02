package ifrn.nc.util;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses( { TesteInserir.class, TesteBuscar.class, TesteRemover.class } )
public class AllTests {

}
