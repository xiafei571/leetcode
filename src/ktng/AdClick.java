package ktng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdClick {
//3. Ads Conversion Rate
	public static void main(String[] args) {
		String[] completed_purchase_user_ids = { "3123122444", "234111110", "8321125440", "99911063" };

		// "IP_Address,Time,Ad_Text"
		String[] ad_clicks = { "122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
				"96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
				"122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
				"82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
				"92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
				"92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens" };

		// "User_ID,IP_Address"
		String[] all_user_ips = { "2339985511,122.121.0.155", "234111110,122.121.0.1", "3123122444,92.130.6.145",
				"39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000", "8321125440,82.1.106.8",
				"99911063,92.130.6.144" };
		
		List<String> res = adClick(completed_purchase_user_ids, ad_clicks, all_user_ips);
		for(String str : res) {
			System.out.println(str);
		}
	}
	
	// Expected output:
	// Bought Clicked Ad Text
	// 1 of 2  2017 Pet Mittens
	// 0 of 1  The Best Hollywood Coats
	// 3 of 3  Buy wool coats for your pets
	private static List<String> adClick(String[] completed_purchase_user_ids, String[] ad_clicks, String[] all_user_ips) {
		List<String> res = new ArrayList<>();
//		Map<String, String> USER_IP = new HashMap<>();
		Map<String, String> IP_USER = new HashMap<>();
		
		Map<String, Integer[]> AD_BOUGHT_CLICK = new HashMap<>();
		//1. userId to set() completed_purchase_user_ids
		//2. 遍历 ad_clicks
		
		return null;
		
	}
}
