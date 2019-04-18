package com.lgchem.cms.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	// 문자열의 내용중 원하는 문자열을 다른 문자열로 변환
	// String str = replaceAll(str, "\r\n", "<br>"); // 엔터를 <br>로 변환
	public String replaceAll(String str, String oldStr, String newStr) throws Exception {
		if (str == null)
			return "";

		Pattern p = Pattern.compile(oldStr);

		// 입력 문자열과 함께 매쳐 클래스 생성
		Matcher m = p.matcher(str);

		StringBuffer sb = new StringBuffer();
		boolean result = m.find();

		// 패턴과 일치하는 문자열을 newStr 로 교체해가며 새로운 문자열을 만든다.
		while (result) {
			m.appendReplacement(sb, newStr);
			result = m.find();
		}

		// 나머지 부분을 새로운 문자열 끝에 덫 붙인다.
		m.appendTail(sb);

		return sb.toString();
	}

	// E-Mail 검사
	public boolean isEmail(String email) {
		if (email == null)
			return false;
		boolean b = Pattern.matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+", email.trim());
		return b;
	}

	// NULL 인 경우 ""로
	public String checkNull(String str) {
		String strTmp;
		if (str == null)
			strTmp = "";
		else
			strTmp = str;
		return strTmp;
	}

	// NULL 인 경우 ""로
	public static String checkNullIsZero(String str) {
		String strTmp;
		if (str == null)
			strTmp = "0";
		else
			strTmp = str;
		return strTmp;
	}

	// *******************************************************************************
	// 8859_1 를 euc-kr로
	public String isoToEuc(String str) {
		String convStr = null;
		try {
			if (str == null)
				return "";

			convStr = new String(str.getBytes("8859_1"), "euc-kr");
		} catch (UnsupportedEncodingException e) {
		}
		return convStr;
	}

	// 8859_1 를 utf-8로
	public String isoToUtf(String str) {
		String convStr = null;
		try {
			if (str == null)
				return "";

			convStr = new String(str.getBytes("8859_1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
		}
		return convStr;
	}

	// euc-kr 를 ISO-8859-1 로
	public String eucToIso(String str) {
		String convStr = null;
		try {
			if (str == null)
				return "";

			convStr = new String(str.getBytes("euc-kr"), "8859_1");
		} catch (UnsupportedEncodingException e) {
		}
		return convStr;
	}

	// KSC56O1 를 8859_1로
	public String fromKorean(String str) {
		String convStr = null;
		try {
			if (str == null)
				return "";

			convStr = new String(str.getBytes("KSC5601"), "8859_1");
		} catch (UnsupportedEncodingException e) {
		}
		return convStr;
	}

	// euc-kr 를 KSC5601 로
	public String eucToKsc(String str) {
		String convStr = null;
		try {
			if (str == null)
				return "";

			convStr = new String(str.getBytes("euc-kr"), "8859_1");
			convStr = new String(convStr.getBytes("8859_1"), "KSC5601");
		} catch (UnsupportedEncodingException e) {
		}
		return convStr;
	}

	public String clobToString(Clob clob) {
		StringBuffer s = new StringBuffer();
		BufferedReader br = null;
		try {
			br = new BufferedReader(clob.getCharacterStream());
			String ts = "";
			while ((ts = br.readLine()) != null) {
				s.append(ts + "\n");
			}
			br.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return s.toString();
	}

//	    파일읽기.
	public String fileTOString(String path) throws IOException {
		StringBuilder sb = new StringBuilder();
		FileInputStream fis = new FileInputStream(new File(path));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis, "utf-8"));
		String line = "";
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

//	    nEditor img 삭제
//	    내용에서 src 추출 후, 이미지삭제 dom생성. 
	public String nEditorImgDel(String str) {
		StringBuilder sb = new StringBuilder();
		String regex = "[^'/]*.(gif|jpg|bmp|png|jpge)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);

		while (m.find()) {
			String src = m.group();
			String id = src.substring(0, src.lastIndexOf("."));
			sb.append("<img src='http://image.chosun.com/cstv_new/nEditor_upload/" + src
					+ "' style='width:100px;height:100px;' onclick='del_img_list(\"" + src + "\", \"" + id
					+ "\");' id='img" + id + "'>");
		}
		return sb.toString();
	}

	// 오늘 날짜 포맷형식으로 가져오기 [한동훈 추가]
	public static String getTodayDateFomatString(String format) {
		/*
		 * G : 연대 : AD y : 년도 :2006 M : 월(1~12 또는 1월~12월) : 10 또는 10월, OCT w: 몇 년의 몇번째 주
		 * :50 W:월의 몇 째주:4 D:년의 몇 번째 일(1~366):100 d: 월의 몇 번째 일 :15 F:월의 몇 번째 요일(1~5) : 1
		 * E: 요일 :월 a: 오전/오후: PM H:시간0~23: 20 k:시간 1~24:13 K:시간 0~11:10 h: 시간(1~12) :11
		 * m:분(0~59):35 s:초(0~59):55 S:천분의 일초0~999 :253 z: Time zone :GMT+9:00 Z: Time
		 * zone :0900
		 */
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String val = sdf.format(today);
		return val;
	}

	// 파라미터에 넣은 일수를 바꾸줌 가져오기 [한동훈 추가]
	public static String getChangeDay(String date, int addday) {
		GregorianCalendar cal = new GregorianCalendar();
		int year = 0;
		int month = 0;
		int day = 0;
		if (date.length() != 8)
			return "";
		year = Integer.valueOf(date.substring(0, 4)).intValue();
		month = Integer.valueOf(date.substring(4, 6)).intValue();
		day = Integer.valueOf(date.substring(6, 8)).intValue();
		cal.set(year, month - 1, day + addday);

		String stryear = new DecimalFormat("0000").format(cal.get(Calendar.YEAR));
		String strmonth = new DecimalFormat("00").format((cal.get(Calendar.MONTH) + 1));
		String strday = new DecimalFormat("00").format((cal.get(Calendar.DATE)));

		return stryear + strmonth + strday;
	}

	// 파라미터에 넣은 날짜 요일 가져오기 숫자 [한동훈 추가]
	public static int getDayOfWeek(String yyyyMMdd) {
		// 일1 월2 화3 수4 목5 금6 토7
		GregorianCalendar cal = new GregorianCalendar();
		int year = 0;
		int month = 0;
		int day = 0;
		if (yyyyMMdd.length() != 8)
			return -1;
		year = Integer.valueOf(yyyyMMdd.substring(0, 4)).intValue();
		month = Integer.valueOf(yyyyMMdd.substring(4, 6)).intValue();
		day = Integer.valueOf(yyyyMMdd.substring(6, 8)).intValue();
		cal.set(year, month - 1, day);

		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);

		return day_of_week;
	}

	// 파라미터에 넣은 날짜 요일 가져오기 한글 [한동훈 추가]
	public static String getDayOfWeekStr(String yyyyMMdd) {
		// 일 월 화 수 목 금 토
		GregorianCalendar cal = new GregorianCalendar();
		int year = 0;
		int month = 0;
		int day = 0;
		if (yyyyMMdd.length() != 8)
			return "";
		year = Integer.valueOf(yyyyMMdd.substring(0, 4)).intValue();
		month = Integer.valueOf(yyyyMMdd.substring(4, 6)).intValue();
		day = Integer.valueOf(yyyyMMdd.substring(6, 8)).intValue();
		cal.set(year, month - 1, day);

		String returnStr = "";
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);

		if (day_of_week == 1)
			returnStr = "일";
		if (day_of_week == 2)
			returnStr = "월";
		if (day_of_week == 3)
			returnStr = "화";
		if (day_of_week == 4)
			returnStr = "수";
		if (day_of_week == 5)
			returnStr = "목";
		if (day_of_week == 6)
			returnStr = "금";
		if (day_of_week == 7)
			returnStr = "토";

		return returnStr;
	}

	// 파라미터 S에 숫자로되어있는 스트링을 넣으면 화폐' , ' 찍어줌 [한동훈 추가 2013-01-16]
	public static String s_Comma(String s) {
		String sign;

		s = s.trim();

		if (s.substring(0, 1).equals("-")) {
			sign = "-";
			s = s.substring(1, s.length());
		} else {
			sign = "";
		}

		if (s.length() < 4) {
			s = sign + s;
			return s;
		} else {
			int iDotCount = s.length() / 3;

			if (s.length() % 3 == 0)
				iDotCount -= 1;

			int iDotIndex = -1;

			for (int i = iDotCount; i > 0; i--) {
				iDotIndex = s.indexOf(",");
				if (iDotIndex == -1)
					s = s.substring(0, s.length() - 3) + "," + s.substring(s.length() - 3);
				else
					s = s.substring(0, iDotIndex - 3) + "," + s.substring(iDotIndex - 3);
			}

			s = sign + s;
			return s;
		}
	}

	public static String todayCompareEndDay(String start_date, String end_date) {
		String ret = "";

		String todayNow = StringUtil.getTodayDateFomatString("yyyy-MM-ddKKmm");

		if (todayNow.compareTo(end_date) > 0) {
			ret = "종료";
		} else if (todayNow.compareTo(start_date) > 0) {
			ret = "대기";
		} else {
			ret = "진행중";
		}

		return ret;
	}

	public static String getText(String content) {
		Pattern SCRIPTS = Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>", Pattern.DOTALL);
		Pattern STYLE = Pattern.compile("<style[^>]*>.*</style>", Pattern.DOTALL);
		Pattern TAGS = Pattern.compile("<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>");
		Pattern nTAGS = Pattern.compile("<\\w+\\s+[^<]*\\s*>");
		Pattern ENTITY_REFS = Pattern.compile("&[^;]+;");
		Pattern WHITESPACE = Pattern.compile("\\s\\s+");

		Matcher m;

		m = SCRIPTS.matcher(content);
		content = m.replaceAll("");
		m = STYLE.matcher(content);
		content = m.replaceAll("");
		m = TAGS.matcher(content);
		content = m.replaceAll("");
		m = ENTITY_REFS.matcher(content);
		content = m.replaceAll("");
		m = WHITESPACE.matcher(content);
		content = m.replaceAll(" ");

		return content;
	}

	public static String stringToHtmlSign(String str) {

		return str.replaceAll("[&]", "&amp;").replaceAll("[<]", "&lt;").replaceAll("[>]", "&gt;")
				.replaceAll("[\"]", "&quot;").replaceAll("[\\]", "&#39;");
	}
}
