package java_mid1;


public class EqualsMainV2 {

	public static void main(String[] args) {
		UserV2 user1 = new UserV2("id-100");
		UserV2 user2 = new UserV2("id-100");
		System.out.println("identity = " + (user1 == user2));
		System.out.println("equality = " + user1.equals(null));

	}

}

class UserV2 {
	private String id;

	public UserV2(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj == null || !(obj instanceof UserV2)) {
	        return false; // null이거나 다른 타입이면 false 반환
	    }

	    UserV2 user = (UserV2) obj; // ✅ 먼저 UserV1 타입으로 캐스팅
	    return id.equals(user.id);  // ✅ 그 후 id 비교
	}
	
}