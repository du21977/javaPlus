package cn.enjoyedu.analysis;

/**
 * 通过动态代理调用实际被代理对象
 * 小王通过婚介所与王美丽约会
 * 动态代理隐藏了具体的细节，并且可以对方法增强
 */
public class King {
	
	public static void main(String[] args) {
		//隔壁有个女孩，叫王美丽
		Girl girl = new WangMeiLi();
		//他有个庞大的家庭，想要跟她约会必须征得她家里人的同意
		WangMeiLiProxy   family = new WangMeiLiProxy(girl);
		//有一次我去约王美丽，碰到了她的妈妈，我征得了她妈妈的同意
		Girl mother = (Girl) family.getProxyInstance();
		//通过她的妈妈这个代理才能与王美丽约会
		mother.date();
	}

}
