package com.buy.together.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.buy.together.dao.SearchDao;
import com.buy.together.dto.BuyTogetherDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@Service
public class SearchServiceImpl implements SearchService {

	@Inject
	private SearchDao searchDao;

	@Override
	public List<BuyTogetherDTO> searchBuyTogether(String[] keyWords) throws Exception {
		
		List<BuyTogetherDTO> buyTogetherList = null;

		/*for(int i=0; i<keyWords.length; i++) {
			List<BuyTogetherDTO> doc = searchDao.searchBuyTogether(keyWords[i]);
			System.out.println("doc:" + doc);
			//buyTogetherList.addAll(doc);
			
		}
		*/
		List<BuyTogetherDTO> doc = searchDao.searchBuyTogether(keyWords[0]);
		System.out.println("doc:"+doc.get(0).getTitle());
		APIExamSearchBlog();
		return buyTogetherList;
		
	}

	public void APIExamSearchBlog() {

		String clientId = "by6_tJPL7JlGEEddntmk";//애플리케이션 클라이언트 아이디값";
		String clientSecret = "WRUaNm8T4x";//애플리케이션 클라이언트 시크릿값";
		try {
			String text = URLEncoder.encode("강아쥐", "UTF-8");
			String apiURL = "https://openapi.naver.com/v1/search/errata?query="+ text; // json 결과
			//String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if(responseCode==200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {  // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println(response.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
