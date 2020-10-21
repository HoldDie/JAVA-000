import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloClassLoader extends ClassLoader {

	public static void main(String[] args) {
		try {
			Class<?> hClass = new HelloClassLoader().findClass("Hello");
			Object obj = hClass.newInstance();
			Method method = hClass.getMethod("hello", null);
			method.invoke(obj);
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Class<?> findClass(String name) {
		byte[] bytes = null;
		try {
			bytes = Files.readAllBytes(Paths.get("/Users/zeyangg/ww/JAVA-000/Week_01/src/main/resources/Hello.xlass"));
			for (int i = 0; i < bytes.length; i++) {
				byte a = (byte) (255 - bytes[i]);
				bytes[i] = a;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return defineClass(name, bytes, 0, bytes.length);
	}

}
