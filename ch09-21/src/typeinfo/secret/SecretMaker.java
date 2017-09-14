package typeinfo.secret;

/**
 * Created by wangcheng  on 2017/9/14.
 */
class Secret implements A2 {
	public void e() { System.out.println("public Secret.e()"); } 
	void f() { System.out.println("package Secret.f()"); }
	protected void g() { System.out.println("protected Secret.g()"); }
	private void h() { System.out.println("private Secret.h()"); }
}
public class SecretMaker {
    public static A2 makeSecret() { return new Secret();  }
}
